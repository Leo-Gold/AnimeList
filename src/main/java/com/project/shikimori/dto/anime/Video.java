package com.project.shikimori.dto.anime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {
	int id;
    String url;
    @JsonProperty("image_url")
    String imageUrl;
    @JsonProperty("player_url")
    String playerUrl;
    String name;
    String kind;
    String hosting;
	public Video() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPlayerUrl() {
		return playerUrl;
	}
	public void setPlayerUrl(String playerUrl) {
		this.playerUrl = playerUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getHosting() {
		return hosting;
	}
	public void setHosting(String hosting) {
		this.hosting = hosting;
	}
	
}
