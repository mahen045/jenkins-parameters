package org.example.regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SimpleRegex {
    public static void main(String[] args) {
        String input = "@@#$%";
        String regex = "\\w+";
        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        // Match the pattern against the input
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("The input matches the pattern!");
        } else {
            System.out.println("No match found.");
        }
    }
}
