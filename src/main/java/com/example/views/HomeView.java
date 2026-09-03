package com.example.views;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.RouterLink;

import org.apache.catalina.startup.Tool;

import com.example.programs.ToolRegistry;
import com.example.programs.ToolRegistry.ToolEntry;

@Route("")
public class HomeView extends VerticalLayout {
    public HomeView() {
        add(new H1("My Toolkit"));
        
        for (ToolEntry tool : ToolRegistry.TOOLS) {
            add(new RouterLink(tool.title(), ConsoleView.class, tool.key()));
        }
    }
}