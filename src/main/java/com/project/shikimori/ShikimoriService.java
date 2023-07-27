package com.project.shikimori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.project.shikimori.dto.anime.Anime;
import com.project.shikimori.dto.user.AnimeRate;
import com.project.shikimori.dto.user.History;
import com.project.shikimori.dto.user.User;

public class ShikimoriService {
	private String url = "https://shikimori.me/";
	private String urlUsers = "api/users/";
	private String nickname;
	private RestTemplate restTemplate = new RestTemplate();

	public ShikimoriService(String nickname) {
		this.nickname = nickname;
	}

	private HttpEntity<String> entity() {
		String key = "User-Agent";
		String value = "Api Test";
		HttpHeaders headers = new HttpHeaders();
		headers.add(key, value);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return entity;
	}

	public int getUserId() {
		String urlFull = new StringBuilder(url).append(urlUsers).append(nickname).append("/info").toString();
		User user = restTemplate.exchange(urlFull, HttpMethod.GET, entity(), User.class).getBody();
		return user.getId();
	}

	public List<AnimeRate> getUserAnimeRate() {

		ArrayList<AnimeRate> result = new ArrayList<>();

		int page = 1;
		String urlFull = new StringBuilder(url).append(urlUsers).append(getUserId()).append("/anime_rates/")
				.append("?").append("limit").append("=").append(5000 )
				.toString();

		AnimeRate[] animeRate = (AnimeRate[]) getPage(urlFull, page);
		
		while (animeRate.length > 0 && page <= 100000) {
			if (page == 1) {
				if (result.size() > animeRate.length - 1) {
					result = new ArrayList<>();
				}
			} else {
				animeRate = (AnimeRate[]) getPage(urlFull, page);
			}
			result.addAll(Arrays.asList(animeRate));
			page++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<AnimeRate> addInfoAnimeForUserRate() {

		List<AnimeRate> getAnimeRates = getUserAnimeRate();

		for (AnimeRate rateAnime : getAnimeRates) {
			String urlFull = new StringBuilder(url).append("api/animes/").append(rateAnime.getAnime().getId()).toString();

			Anime anime = restTemplate.exchange(urlFull, HttpMethod.GET, entity(), Anime.class).getBody();
			rateAnime.setAnime(anime);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		return getAnimeRates;
	}

	public ArrayList<History> getAnimeHistory() {
		ArrayList<History> result = new ArrayList<>();

		int page = 1;
		String urlFull = new StringBuilder(url).append(urlUsers).append(getUserId()).append("/history")
				.append('?').append("target_type").append('=').append("Anime")
				.append('&').append("limit").append('=').append(100)
				.toString();

		History[] history = (History[]) getPage(urlFull, page);
		while (history.length > 0 && page <= 100000) {
			if (page == 1) {
				if (result.size() > history.length - 1) {
					result = new ArrayList<>();
				}
			} else {
				history = (History[])  getPage(urlFull, page);
			}
			result.addAll(Arrays.asList(history));
			page++;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Object[] getPage(String urlString, int paramValue ) {
		String urlFull = new StringBuilder(urlString)
				.append('&').append("page").append('=').append(paramValue)
				.toString();
		return restTemplate.exchange(urlFull, HttpMethod.GET, entity(), Object[].class).getBody();
	}
}
