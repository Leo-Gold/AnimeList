package com.project.myAnimeList.dto;

import java.util.Date;

public class Anime {
	long id;
	String status;
	String url;
	String title;
	String score;
	int currentEpisode;
	int episodes;
	Date startDate;
	Date endDate;

	public Anime() {
	}

	public Anime(long id, String status, String url, String title, String score, int currentEpisode, int episodes,
			Date startDate, Date endDate) {
		this.id = id;
		this.status = status;
		this.url = url;
		this.title = title;
		this.score = score;
		this.currentEpisode = currentEpisode;
		this.episodes = episodes;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public String getScore() {
		return score;
	}

	public int getCurrentEpisode() {
		return currentEpisode;
	}

	public int getEpisodes() {
		return episodes;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
}
