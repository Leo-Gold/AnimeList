package com.project.shikimori.dto.user;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shikimori.dto.anime.Anime;

public class AnimeRate {
	int id;
    int score;
    String status;
    String text;
    int episodes;
    Integer chapters;
    Integer volumes;
    @JsonProperty("text_html")
    String textHtml;
    int rewatches;
    @JsonProperty("created_at")
    Instant createdAt;
    @JsonProperty("updated_at")
    Instant updatedAt;
    User user;
    Anime anime;
    Object manga;
	public AnimeRate() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getEpisodes() {
		return episodes;
	}
	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	public Integer getChapters() {
		return chapters;
	}
	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}
	public Integer getVolumes() {
		return volumes;
	}
	public void setVolumes(Integer volumes) {
		this.volumes = volumes;
	}
	public String getTextHtml() {
		return textHtml;
	}
	public void setTextHtml(String textHtml) {
		this.textHtml = textHtml;
	}
	public int getRewatches() {
		return rewatches;
	}
	public void setRewatches(int rewatches) {
		this.rewatches = rewatches;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public Instant getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Anime getAnime() {
		return anime;
	}
	public void setAnime(Anime anime) {
		this.anime = anime;
	}
	public Object getManga() {
		return manga;
	}
	public void setManga(Object manga) {
		this.manga = manga;
	}
	
}
