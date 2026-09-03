package com.example.views;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class HomeView extends VerticalLayout {
    public HomeView() {
        add(new H1("My Toolkit"));
        add(new RouterLink("Marks Calculator", MarksCalculatorView.class));
    }
}