package com.project.views.main;

import java.util.List;

import com.project.shikimori.ShikimoriService;
import com.project.shikimori.dto.user.History;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("")
public class MainView extends VerticalLayout{
	public MainView() {
	    Grid<History> grid = new Grid<>(History.class, false);
	    grid.addColumn(History::getId).setHeader("id");
	   

	    List<History> history = new ShikimoriService("ahmpro").getAnimeHistory();
	    grid.setItems(history);
	  }
}
