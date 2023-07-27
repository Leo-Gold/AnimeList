package com.project.myAnimeList;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.project.myAnimeList.dto.Anime;


public class MyAnimeListService {
	 String nickname;
	    String url = "https://myanimelist.net";

	    public MyAnimeListService(String nickname) {
	        this.nickname = nickname;
	    }

	    public List<Anime> getAnimeList() {
	        List<Anime> anime = new ArrayList<>();
	        int countTd = 8;

	        for (int i = 1; i < 7; i++) {
	            if (i == 5) {
	                countTd = 6;
	            }
	            requestAnimeList("td1", anime, i, countTd);
	            requestAnimeList("td2", anime, i, countTd);
	        }
	        return anime;
	    }

	    public void requestAnimeList(String td, List<Anime> anime, int pageStatus, int countTd) {

	        String animelist = "/animelist/";
	        String headerName1 = "status";
	        String headerName2 = "tag";

	        String urlFull = new StringBuilder(url).append(animelist).append(nickname)
	        .append("?").append(headerName1).append("=").append(pageStatus)
	        .append("&").append(headerName2).append("=")
	        .toString();

	        try {
	            Document document = Jsoup.connect(urlFull).get();

	            String status = document.select("div.header_title").text();
	            Elements elementsTd1 = document.getElementsByClass(td);

	            for (int i = 0; i < elementsTd1.size(); i += countTd) {
	                String title = elementsTd1.get(i + 1).getElementsByClass("animetitle").text();
	                String urlAnime = elementsTd1.get(i + 1).getElementsByClass("animetitle").attr("href");
	                long id = Long.parseLong(urlAnime.split("/")[2]);
	                String score = elementsTd1.get(i + 2).getElementsByTag("span").text();
	                int currentEpisode = Integer.parseInt(elementsTd1.get(i + 4).text().split("/")[0]);
	                int episodes  = Integer.parseInt(elementsTd1.get(i + 4).text().split("/")[1]);
	                Date dateStart = null, dateEnd = null;

	                if (pageStatus != 6) {
	                    try {
	                        dateStart = new SimpleDateFormat("dd-MM-yy").parse(elementsTd1.get(i + 6).text());
	                        dateEnd = new SimpleDateFormat("dd-MM-yy").parse(elementsTd1.get(i + 7).text());
	                    } catch (ParseException e) {
	                        e.printStackTrace();
	                    }
	                }
	                anime.add(new Anime(id, status, url.concat(urlAnime), title, score, currentEpisode, episodes, dateStart, dateEnd));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
