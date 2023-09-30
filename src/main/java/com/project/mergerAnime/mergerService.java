package com.project.mergerAnime;

import java.util.HashMap;
import java.util.List;

import com.project.myAnimeList.MyAnimeListService;
import com.project.myAnimeList.dto.MAnime;
import com.project.shikimori.ShikimoriService;

public class mergerService {
	String nameShiki;
	String nameMAL;
	public mergerService(String nameShiki, String nameMAL) {
		this.nameShiki = nameShiki;
		this.nameMAL = nameMAL;
	}
	
	public void mergeAnime(){
		List<MAnime> shikiList = new ShikimoriService(nameShiki).getAnimeShikiUser();
		HashMap<Long, MAnime> malList = new MyAnimeListService(nameMAL).getAnimeList();
		for (MAnime shikiItem : shikiList) {
			MAnime mal = malList.get(shikiItem.getId());
			System.out.println(mal.getId() + " " + mal.getTitle() + " количество просмотренных эпизодов-" + mal.getCurrentEpisode() + " оценка-"+ mal.getScore());
			System.out.println(shikiItem.getId() + " " + shikiItem.getTitle() + " количество просмотренных эпизодов-" + shikiItem.getCurrentEpisode() + " оценка-"+ shikiItem.getScore());
		}
	}
}
