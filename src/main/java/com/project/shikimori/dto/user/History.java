package com.project.shikimori.dto.user;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class History {
	int id;
	@JsonProperty("created_at")
	Instant createdAt;
	String description;
	Target target;
	public History() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	
}
