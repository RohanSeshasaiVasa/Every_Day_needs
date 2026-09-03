package com.example.programs;
import java.util.List;
public class ToolRegistry {
    public record ToolEntry(String key, String title, Runnable program) {}
    public static final List<ToolEntry> TOOLS = List.of(
        new ToolEntry("marks-calculator", "Marks Calculator", MarksProgram::run),
        new ToolEntry("seconds-converter", "Seconds Converter", SecondsConverter::run),
        new ToolEntry("pyramid-area", "Area of a Pyramid", PyramidAreaCalculator::run),
        new ToolEntry("fahrenheit-converter", "Convert fahrenheit to Celcius", FahrenheitConverter::run),
        new ToolEntry("trapezoid-area", "Area of a trapezoid", AreaOfTrapezoid::run)
    );
}
