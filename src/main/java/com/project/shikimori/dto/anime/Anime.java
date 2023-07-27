package com.project.shikimori.dto.anime;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shikimori.dto.image.Image;

public class Anime {
	    int id;
	    String name, russian;
	    Image image;
	    String url, kind;
	    float score;
	    String status;
	    int episodes;
	    @JsonProperty("episodes_aired")
	    int episodesAired;
	    @JsonProperty("aired_on")
	    String airedOn;
	    @JsonProperty("released_on")
	    String releasedOn;

	    String rating;
	    String[] english;
	    String[] japanese;
	    String[] synonyms;
	    @JsonProperty("license_name_ru")
	    String licenseNameRu;
	    int duration;
	    String description;
	    @JsonProperty("description_html")
	    String descriptionHtml;
	    @JsonProperty("description_source")
	    String descriptionSource;
	    String franchise;
	    boolean favoured, anons, ongoing;
	    @JsonProperty("thread_id")
	    int threadId;
	    @JsonProperty("topic_id")
	    int topicId;
	    @JsonProperty("myanimelist_id")
	    long myanimelistId;
	    @JsonProperty("rates_scores_stats")
	    RatesScoresStats[] ratesScoresStats;
	    @JsonProperty("rates_statuses_stats")
	    RatesStatusesStats[] ratesStatusesStats;
	    @JsonProperty("updated_at")
	    Instant updatedAt;
	    @JsonProperty("next_episode_at")
	    String nextEpisodeAt;
	    String[] fansubbers;
	    String[] fandubbers;
	    String[] licensors; 
	    Genre[] genres;
	    Studio[] studios;
	    Video[] videos;
	    Screenshots[] screenshots;
	    @JsonProperty("user_rate")
	    String userRate;
		public Anime() {
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
		public float getScore() {
			return score;
		}
		public void setScore(float score) {
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
		public String getAiredOn() {
			return airedOn;
		}
		public void setAiredOn(String airedOn) {
			this.airedOn = airedOn;
		}
		public String getReleasedOn() {
			return releasedOn;
		}
		public void setReleasedOn(String releasedOn) {
			this.releasedOn = releasedOn;
		}
		public String getRating() {
			return rating;
		}
		public void setRating(String rating) {
			this.rating = rating;
		}
		public String[] getEnglish() {
			return english;
		}
		public void setEnglish(String[] english) {
			this.english = english;
		}
		public String[] getJapanese() {
			return japanese;
		}
		public void setJapanese(String[] japanese) {
			this.japanese = japanese;
		}
		public String[] getSynonyms() {
			return synonyms;
		}
		public void setSynonyms(String[] synonyms) {
			this.synonyms = synonyms;
		}
		public String getLicenseNameRu() {
			return licenseNameRu;
		}
		public void setLicenseNameRu(String licenseNameRu) {
			this.licenseNameRu = licenseNameRu;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDescriptionHtml() {
			return descriptionHtml;
		}
		public void setDescriptionHtml(String descriptionHtml) {
			this.descriptionHtml = descriptionHtml;
		}
		public String getDescriptionSource() {
			return descriptionSource;
		}
		public void setDescriptionSource(String descriptionSource) {
			this.descriptionSource = descriptionSource;
		}
		public String getFranchise() {
			return franchise;
		}
		public void setFranchise(String franchise) {
			this.franchise = franchise;
		}
		public boolean isFavoured() {
			return favoured;
		}
		public void setFavoured(boolean favoured) {
			this.favoured = favoured;
		}
		public boolean isAnons() {
			return anons;
		}
		public void setAnons(boolean anons) {
			this.anons = anons;
		}
		public boolean isOngoing() {
			return ongoing;
		}
		public void setOngoing(boolean ongoing) {
			this.ongoing = ongoing;
		}
		public int getThreadId() {
			return threadId;
		}
		public void setThreadId(int threadId) {
			this.threadId = threadId;
		}
		public int getTopicId() {
			return topicId;
		}
		public void setTopicId(int topicId) {
			this.topicId = topicId;
		}
		public long getMyanimelistId() {
			return myanimelistId;
		}
		public void setMyanimelistId(long myanimelistId) {
			this.myanimelistId = myanimelistId;
		}
		public RatesScoresStats[] getRatesScoresStats() {
			return ratesScoresStats;
		}
		public void setRatesScoresStats(RatesScoresStats[] ratesScoresStats) {
			this.ratesScoresStats = ratesScoresStats;
		}
		public RatesStatusesStats[] getRatesStatusesStats() {
			return ratesStatusesStats;
		}
		public void setRatesStatusesStats(RatesStatusesStats[] ratesStatusesStats) {
			this.ratesStatusesStats = ratesStatusesStats;
		}
		public Instant getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Instant updatedAt) {
			this.updatedAt = updatedAt;
		}
		public String getNextEpisodeAt() {
			return nextEpisodeAt;
		}
		public void setNextEpisodeAt(String nextEpisodeAt) {
			this.nextEpisodeAt = nextEpisodeAt;
		}
		public String[] getFansubbers() {
			return fansubbers;
		}
		public void setFansubbers(String[] fansubbers) {
			this.fansubbers = fansubbers;
		}
		public String[] getFandubbers() {
			return fandubbers;
		}
		public void setFandubbers(String[] fandubbers) {
			this.fandubbers = fandubbers;
		}
		public String[] getLicensors() {
			return licensors;
		}
		public void setLicensors(String[] licensors) {
			this.licensors = licensors;
		}
		public Genre[] getGenres() {
			return genres;
		}
		public void setGenres(Genre[] genres) {
			this.genres = genres;
		}
		public Studio[] getStudios() {
			return studios;
		}
		public void setStudios(Studio[] studios) {
			this.studios = studios;
		}
		public Video[] getVideos() {
			return videos;
		}
		public void setVideos(Video[] videos) {
			this.videos = videos;
		}
		public Screenshots[] getScreenshots() {
			return screenshots;
		}
		public void setScreenshots(Screenshots[] screenshots) {
			this.screenshots = screenshots;
		}
		public String getUserRate() {
			return userRate;
		}
		public void setUserRate(String userRate) {
			this.userRate = userRate;
		}
	    
}
