package com.project.shikimori.dto.user;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shikimori.dto.image.Image;

public class User {

	int id;
    String nickname;
    String avatar;
    Image image;
    @JsonProperty("last_online_at")
    Instant lastOnlineAt;
    String url;
    String name;
    String sex;
    String website;
    String location;
    Boolean banned;
    String about;
    @JsonProperty("about_html")
    String aboutHtml;
    @JsonProperty("common_info")
    String[] commonInfo;
    @JsonProperty("show_comments")
    Boolean showComments;
    @JsonProperty("birth_on")
    String birthOn;
    @JsonProperty("full_years")
    Integer fullYears;
    @JsonProperty("last_online")
    String lastOnline;
    @JsonProperty("in_friends")
    String inFriends;
    @JsonProperty("is_ignored")
    Boolean isIgnored;
    String locale;
	public User() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Instant getLastOnlineAt() {
		return lastOnlineAt;
	}
	public void setLastOnlineAt(Instant lastOnlineAt) {
		this.lastOnlineAt = lastOnlineAt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getBanned() {
		return banned;
	}
	public void setBanned(Boolean banned) {
		this.banned = banned;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getAboutHtml() {
		return aboutHtml;
	}
	public void setAboutHtml(String aboutHtml) {
		this.aboutHtml = aboutHtml;
	}
	public String[] getCommonInfo() {
		return commonInfo;
	}
	public void setCommonInfo(String[] commonInfo) {
		this.commonInfo = commonInfo;
	}
	public Boolean getShowComments() {
		return showComments;
	}
	public void setShowComments(Boolean showComments) {
		this.showComments = showComments;
	}
	public String getBirthOn() {
		return birthOn;
	}
	public void setBirthOn(String birthOn) {
		this.birthOn = birthOn;
	}
	public Integer getFullYears() {
		return fullYears;
	}
	public void setFullYears(Integer fullYears) {
		this.fullYears = fullYears;
	}
	public String getLastOnline() {
		return lastOnline;
	}
	public void setLastOnline(String lastOnline) {
		this.lastOnline = lastOnline;
	}
	public String getInFriends() {
		return inFriends;
	}
	public void setInFriends(String inFriends) {
		this.inFriends = inFriends;
	}
	public Boolean getIsIgnored() {
		return isIgnored;
	}
	public void setIsIgnored(Boolean isIgnored) {
		this.isIgnored = isIgnored;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
}
