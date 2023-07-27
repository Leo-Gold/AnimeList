package com.project.shikimori.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shikimori.dto.image.Image;

public class Target {
	int id;
    String name;
    String russian;
    Image image;
    String url;
    String kind;
    String score;
    String status;
    int episodes;
    @JsonProperty("episodes_aired")
    int episodesAired;
    @JsonProperty("aired_on")
    Object airedOn;
    @JsonProperty("released_on")
    Object releasedOn;
	public Target() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRussian() {
		return russian;
	}
	public void setRussian(String russian) {
		this.russian = russian;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEpisodes() {
		return episodes;
	}
	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}
	public int getEpisodesAired() {
		return episodesAired;
	}
	public void setEpisodesAired(int episodesAired) {
		this.episodesAired = episodesAired;
	}
	public Object getAiredOn() {
		return airedOn;
	}
	public void setAiredOn(Object airedOn) {
		this.airedOn = airedOn;
	}
	public Object getReleasedOn() {
		return releasedOn;
	}
	public void setReleasedOn(Object releasedOn) {
		this.releasedOn = releasedOn;
	}
	
}
