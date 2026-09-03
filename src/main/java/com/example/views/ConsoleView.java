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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import com.example.programs.ToolRegistry;
import com.example.programs.ToolRegistry.ToolEntry;

@Route("run")
public class ConsoleView extends VerticalLayout implements HasUrlParameter<String> {
    private final H1 title = new H1();
    private final TextArea output = new TextArea();
    private final TextField input = new TextField();
    private PipedOutputStream pipedOutputStream;
    private Runnable program;

    public ConsoleView() {
        output.setReadOnly(true);
        output.setWidthFull();
        output.setHeight("300px");
        input.setWidthFull();
        input.setPlaceholder("Type here and press enter");
        add(title, output, input);

        input.addKeyPressListener(Key.ENTER, e -> {
            String text = input.getValue();
            input.clear();
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
        } else {
            title.setText(tool.title());
            program = tool.program();
        }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   



