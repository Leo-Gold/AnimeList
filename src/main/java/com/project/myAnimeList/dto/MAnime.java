package com.project.myAnimeList.dto;

import java.util.Date;

import com.project.constants.userRate.STATUS;

public class MAnime {
	long id;
	STATUS status;
	Url url;
	String title;
	int score;
	Integer currentEpisode;
	Integer episodes;
	Date startDate;
	Date endDate;

	public MAnime() {
	}

	public MAnime(long id, STATUS status, Url url, String title, int score, Integer currentEpisode, Integer episodes,
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

	public STATUS getStatus() {
		return status;
	}

	public Url getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public int getScore() {
		return score;
	}

	public Integer getCurrentEpisode() {
		return currentEpisode;
	}

	public Integer getEpisodes() {
		return episodes;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setCurrentEpisode(Integer currentEpisode) {
		this.currentEpisode = currentEpisode;
	}

	public void setEpisodes(Integer episodes) {
		this.episodes = episodes;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
