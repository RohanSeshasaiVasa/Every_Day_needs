package com.example.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

import com.example.programs.ToolRegistry;
import com.example.programs.ToolRegistry.ToolEntry;

@Route("")
public class HomeView extends VerticalLayout {
    public HomeView() {
        addClassName("home-view");
        Div header = new Div(
            new H1("My Toolkit"),
            new Paragraph("A growing collection of handy everyday calculators and converters")
        );
        header.addClassName("home-header");
        Button darkModeToggle = new Button(VaadinIcon.MOON.create());
        darkModeToggle.addClickListener(e ->
            UI.getCurrent().getPage().executeJs("document.documentElement.classList.toggle('dark-mode')")
        );
        header.add(darkModeToggle);
        Div grid = new Div();
        grid.addClassName("tool-grid");
        for (ToolEntry tool : ToolRegistry.TOOLS) {
            grid.add(createCard(tool));
        }
        add(header, grid);
    }
    private Component createCard(ToolEntry tool) {
        Div badge = new Div();
        badge.setText(tool.title().substring(0,1).toUpperCase());
        badge.addClassName("tool-badge");
        Span label = new Span(tool.title());
        label.addClassName("tool-label");
        Div card = new Div(badge, label);
        card.addClassName("tool-card");
        card.addClickListener(e -> UI.getCurrent().navigate(ConsoleView.class, tool.key()));
        return card;
    }
}