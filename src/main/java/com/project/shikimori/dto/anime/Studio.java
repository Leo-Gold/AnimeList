package com.project.shikimori.dto.anime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Studio {
	int id;
    String name;
    @JsonProperty("filtered_name")
    String filteredName;
    boolean real;
    String image;

    public Studio() {
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
    public String getFilteredName() {
        return filteredName;
    }
    public void setFilteredName(String filteredName) {
        this.filteredName = filteredName;
    }
    public boolean isReal() {
        return real;
    }
    public void setReal(boolean real) {
        this.real = real;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
