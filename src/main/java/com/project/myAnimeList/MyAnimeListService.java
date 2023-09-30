package com.project.myAnimeList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.constants.userRate.STATUS;
import com.project.myAnimeList.dto.MAnime;
import com.project.myAnimeList.dto.Url;

public class MyAnimeListService {
	String nickname;
	String url = "https://myanimelist.net/";

	public MyAnimeListService(String nickname) {
		this.nickname = nickname;
	}

	public HashMap<Long, MAnime> getAnimeList() {
		HashMap<Long, MAnime> anime = new HashMap<>();
		// countTd - all columns
		int countTd = 0;

		// i - page MyAnimeList status
		for (int i = 1; i <= 6; i++) {
			// missing 5 page
			if (i != 5) {
				if (i < 5) {
					countTd = 8;
				} else if (i > 5) {
					countTd = 6;
				}
				// j - style row, name class td1 or td2
				for (int j = 1; j <= 2; j++) {
					String td = "td".concat(Integer.toString(j));
					anime.putAll(requestAnimeList(td, i, countTd));
				}
			}

		}
		return anime;
	}

	public HashMap<Long, MAnime> requestAnimeList(String td, int pageStatus, int countTd) {
		HashMap<Long, MAnime> result = new HashMap<>();
		String urlFull = UriComponentsBuilder.fromHttpUrl(url).path("animelist/").path(nickname)
				.queryParam("status", pageStatus).queryParam("tag").toString();

		try {
			Document document = Jsoup.connect(urlFull).get();

			String statusString = document.select("div.header_title").text();
			STATUS status = null;
			switch (statusString) {
			case ("Watching"):
				status = STATUS.watching;
				break;
			case ("Completed"):
				status = STATUS.completed;
				break;
			case ("On-Hold"):
				status = STATUS.onHold;
				break;
			case ("Dropped"):
				status = STATUS.dropped;
				break;
			case ("Plan to Watch"):
				status = STATUS.planned;
				break;
			}
			Elements elementsTd = document.getElementsByClass(td);

			for (int i = 0; i < elementsTd.size(); i += countTd) {
				String title = elementsTd.get(i + 1).getElementsByClass("animetitle").text();

				String urlAnime = elementsTd.get(i + 1).getElementsByClass("animetitle").attr("href");

				long id = Long.parseLong(urlAnime.split("/")[2]);

				String scoreString = elementsTd.get(i + 2).getElementsByTag("span").text();
				int score = 0;
				if (!scoreString.equals("-")) {
					score = Integer.parseInt(scoreString);
				}

				String progress = elementsTd.get(i + 4).text();
				Integer currentEpisode = null, episodes = null;
				if (progress.contains("/")) {
					String currentEpisodeString = progress.split("/")[0];

					if (!currentEpisodeString.equals("-")) {
						currentEpisode = Integer.parseInt(currentEpisodeString);
					}
					String episodesString = progress.split("/")[1];

					if (!episodesString.equals("-")) {
						episodes = Integer.parseInt(episodesString);
					}

				} else {
					episodes = Integer.parseInt(progress);
					currentEpisode = episodes;
				}

				Date dateStart = null, dateEnd = null;

				if (pageStatus < 5) {
					try {
						dateStart = new SimpleDateFormat("dd-MM-yy").parse(elementsTd.get(i + 6).text());
						dateEnd = new SimpleDateFormat("dd-MM-yy").parse(elementsTd.get(i + 7).text());
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				Url urlMal = new Url();
				urlMal.setUrlMal(url.concat(urlAnime));

				result.put((Long) id, new MAnime(id, status, urlMal, title, score, currentEpisode, episodes, dateStart, dateEnd));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
