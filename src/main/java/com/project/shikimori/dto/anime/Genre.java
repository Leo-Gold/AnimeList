package com.project.shikimori.dto.anime;

public class Genre {
	int id;
    String name;
    String russian;
    String kind;
	public Genre() {
		super();
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
    
}
