package com.example.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.notification.Notification;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import com.example.programs.ToolRegistry;
import com.example.programs.ToolRegistry.ToolEntry;

@Route("run")
public class ConsoleView extends VerticalLayout implements HasUrlParameter<String> {
    private final H1 title = new H1();
    private final TextArea output = new TextArea();
    private final TextField input = new TextField();
    private PipedOutputStream pipedOutputStream;
    private Runnable program;
    private String toolKey;
    private List<String> prefilledInputs = new ArrayList<>();
    private final List<String> enteredInputs = new ArrayList<>();

    public ConsoleView() {
        addClassName("console-view");
        Button backButton = new Button(VaadinIcon.ARROW_LEFT.create());
        Button refreshButton = new Button(VaadinIcon.REFRESH.create());
        Button shareButton = new Button(VaadinIcon.SHARE.create());
        backButton.addClickListener(e -> UI.getCurrent().navigate(HomeView.class));
        refreshButton.addClickListener(e -> {
            output.clear();
            startProgram(UI.getCurrent());
        });
        shareButton.addClickListener(e -> shareLink());
        HorizontalLayout toolbar = new HorizontalLayout(backButton, title, refreshButton, shareButton);
        toolbar.setAlignItems(Alignment.CENTER);
        output.setReadOnly(true);
        output.setWidthFull();
        output.setHeight("300px");
        input.setWidthFull();
        input.setPlaceholder("Type here and press enter");
        title.addClassName("console-title");
        output.addClassName("console-output");
        input.addClassName("console-input");
        add(toolbar, output, input);

        input.addKeyPressListener(Key.ENTER, e -> {
            String text = input.getValue();
            input.clear();
            enteredInputs.add(text);
            try {
                pipedOutputStream.write((text + "\n").getBytes());
                pipedOutputStream.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        addAttachListener(event ->{
            UI ui = event.getUI();
            startProgram(ui);
        });
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        ToolEntry tool = ToolRegistry.TOOLS.stream()
                .filter(t -> t.key().equals(parameter))
                .findFirst()
                .orElse(null);
        if (tool == null) {
            title.setText("Unknown tool: " + parameter);
            program = null;
            toolKey = null;
        } else {
            title.setText(tool.title());
            program = tool.program();
            toolKey = tool.key();
        }
        List<String> inputsFromUrl = event.getLocation().getQueryParameters().getParameters().get("inputs");
        prefilledInputs = inputsFromUrl != null ? inputsFromUrl : new ArrayList<>();
    }

    private void shareLink() {
        if (toolKey == null) {
            return;
        }
        StringBuilder query = new StringBuilder();
        for (String value : enteredInputs) {
            if (query.length() > 0) {
                query.append("&");
            }
            query.append("inputs=").append(URLEncoder.encode(value, StandardCharsets.UTF_8));
        }
        String path = "/run/" + toolKey + (query.length() > 0 ? "?" + query : "");

        UI.getCurrent().getPage().executeJs("navigator.clipboard.writeText(window.location.origin + $0)", path);
        Notification.show("Link copied to clipboard!", 3000, Notification.Position.BOTTOM_CENTER);

    }

    private void startProgram(UI ui) {
        if (program == null) {
            return;
        }
        try {
            PipedInputStream pipedInputStream = new PipedInputStream();
            pipedOutputStream = new PipedOutputStream(pipedInputStream);

            OutputStream uiOutputStream = new OutputStream() {
                @Override
                public void write(int b) {
                    write(new byte[] {(byte) b} ,0, 1);
                }
                @Override
                public void write(byte[] b, int off, int len) {
                    String text = new String(b, off, len);
                    ui.access(() -> output.setValue(output.getValue()+ text));
                }
            };

            System.setIn(pipedInputStream);
            System.setOut(new PrintStream(uiOutputStream, true));

            Thread thread = new Thread(program);
            thread.setDaemon(true);
            thread.start();

            enteredInputs.clear();
            if(prefilledInputs != null && !prefilledInputs.isEmpty()) {
                for (String value : prefilledInputs) {
                    pipedOutputStream.write((value + "\n").getBytes());
                    enteredInputs.add(value);
                }
                pipedOutputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   



