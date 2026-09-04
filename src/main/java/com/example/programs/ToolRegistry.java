package com.example.programs;
import java.util.List;
public class ToolRegistry {
    public record ToolEntry(String key, String title, Runnable program) {}
    public static final List<ToolEntry> TOOLS = List.of(
        new ToolEntry("marks-calculator", "Marks Calculator", MarksProgram::run),
        new ToolEntry("seconds-converter", "Seconds Converter", SecondsConverter::run),
        new ToolEntry("pyramid-area", "Area of a Pyramid", PyramidAreaCalculator::run),
        new ToolEntry("fahrenheit-converter", "Convert fahrenheit to Celcius", FahrenheitConverter::run),
        new ToolEntry("trapezoid-area", "Area of a trapezoid", AreaOfTrapezoid::run),
        new ToolEntry("loan-calculator", "Loan Calculator", InterestCalculator::run),
        new ToolEntry("kilometerpersecond-converter", "Convert Kilometer per hour to meter per second", KmphToMs::run),
        new ToolEntry("perimeterarea-calculator", "Perimeter and area of a circle", PerimeterOfCirecleCalculator::run),
        new ToolEntry("age-calculator", "Age Calculator", AgeCalculator::run),
        new ToolEntry("bmi-calculator", "BMI Calculator", BMICalculator::run),
        new ToolEntry("discount-calculator", "Discount Calculator", DiscountCalculator::run),
        new ToolEntry("prime-checker", "Prime Checker", PrimeChecker::run),
        new ToolEntry("bill-splitter", "Bill Splitter", BillSplitter::run),
        new ToolEntry("bmr-calculator", "BMR Calculator", BMRCalculator::run)
    );
}