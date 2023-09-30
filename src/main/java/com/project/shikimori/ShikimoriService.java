package com.project.shikimori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.constants.userRate.STATUS;
import com.project.myAnimeList.dto.MAnime;
import com.project.myAnimeList.dto.Url;
import com.project.shikimori.dto.user.User;
import com.project.shikimori.dto.anime.Anime;
import com.project.shikimori.dto.user.AnimeRate;
import com.project.shikimori.dto.user.History;

public class ShikimoriService {
	private String nickname, url = "https://shikimori.one";

	public ShikimoriService(String nickname) {
		this.nickname = nickname;
	}

	private HttpEntity<String> entity() {
		;
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "Api Test");
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return entity;
	}

	public void timeout() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public int getUserId() {
		String urlFull = UriComponentsBuilder.fromHttpUrl(url).path("/api/users/{nickname}/info").build(this.nickname)
				.toString();
		User user = new RestTemplate().exchange(urlFull, HttpMethod.GET, entity(), User.class).getBody();
		timeout();
		return user.getId();
	}

	public HashMap<String, MAnime> getUserAnimeRate() {

		HashMap<String, MAnime> result = new HashMap<>();
		List<AnimeRate> tempAnimeRateList = new ArrayList<>();
		int page = 1;

		AnimeRate[] animeArr = getPageAnimeRateNext(page);

		while (animeArr != null) {
			animeArr = getPageAnimeRateNext(page);
			List<AnimeRate> animeList = Arrays.asList(animeArr);
			tempAnimeRateList.addAll(animeList);
			page++;
		}

		for (AnimeRate anime : tempAnimeRateList) {
			int animeId = anime.getAnime().getId();
			String urlFull = UriComponentsBuilder.fromHttpUrl(url).path("/api/animes/{animeId}").build(animeId)
					.toString();
			Anime getAnime = new RestTemplate().exchange(urlFull, HttpMethod.GET, entity(), Anime.class).getBody();
			long myanimelistId = getAnime.getMyanimelistId();
			STATUS status = anime.getStatus();
			Url url = new Url();
			url.setUrlShiki(getAnime.getUrl());
			String title = getAnime.getName();
			int score = anime.getScore();
			Integer currentEpisode = null;
			Integer episodes = getAnime.getEpisodes();
			Date startDate = null;
			Date endDate = null;
			MAnime manime = new MAnime(myanimelistId, status, url, title, score, currentEpisode, episodes, startDate,
					endDate);
			result.put(title, manime);
		}

		return result;
	}

	public AnimeRate[] getPageAnimeRateNext(int page) {
		String urlFull = UriComponentsBuilder.fromHttpUrl(url).path("/api/users/{userId}/anime_rates/")
				.queryParam("limit", 1000).queryParam("page", page).queryParam("target_type", "Anime")
				.build(getUserId()).toString();
		AnimeRate[] result = new RestTemplate().exchange(urlFull, HttpMethod.GET, entity(), AnimeRate[].class)
				.getBody();
		timeout();
		return result;
	}

	public List<History> getUserAnimeHistory() {
		List<History> result = new ArrayList<>();
		int page = 1;
		History[] historyArr = getPageAnimeHistoryNext(page);
		while (historyArr.length > 0) {
			historyArr = getPageAnimeHistoryNext(page);
			result.addAll(Arrays.asList(historyArr));
			page++;
		}
		Collections.reverse(result);
		return result;
	}

	public History[] getPageAnimeHistoryNext(int page) {
		String urlFull = UriComponentsBuilder.fromHttpUrl(url).path("/api/users/{userId}/history")
				.queryParam("limit", 100).queryParam("page", page).queryParam("target_type", "Anime").build(getUserId())
				.toString();
		History[] result = new RestTemplate().exchange(urlFull, HttpMethod.GET, entity(), History[].class).getBody();
		timeout();
		return result;
	}

	public List<MAnime> getAnimeShikiUser() {
		HashMap<String, MAnime> result = getUserAnimeRate();
		for (History history : getUserAnimeHistory()) {
			
			MAnime anime = result.get(history.getTarget().getName());
			String description = history.getDescription();
			if (anime.getStatus().equals(STATUS.rewatching)) {
				anime.setStatus(STATUS.watching);
			}
			if (anime.getCurrentEpisode() + 1 == anime.getEpisodes() && description.contains("Просмотрено")
					&& !description.contains("эпизодов") && anime.getEndDate() == null) {
				anime.setStatus(STATUS.completed);
				anime.setEndDate(Date.from(history.getCreatedAt()));
			} else if (description.contains("Просмотрен") && !description.contains("оценено")
					&& pullEpisodes(description) > anime.getCurrentEpisode() && !description.equals("Просмотрено")){
				anime.setCurrentEpisode(pullEpisodes(description));
			} else if (description.equals("Смотрю")) {
				anime.setStartDate(Date.from(history.getCreatedAt()));
			}
		}
		return result.values().stream().collect(Collectors.toList());
	}
	
	public int pullEpisodes(String description) {
		String[] episodeString = description.split("\\D+");
		int index = episodeString.length - 1;
		int episode = Integer.parseInt(episodeString[index]);
		return episode;
	}
}