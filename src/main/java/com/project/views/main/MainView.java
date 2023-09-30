package com.project.views.main;

import com.project.mergerAnime.mergerService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("/")
public class MainView extends VerticalLayout{
	public MainView() {
		new mergerService("ahmpro", "ahmpro").mergeAnime();
	}
}
