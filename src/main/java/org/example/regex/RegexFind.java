package org.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFind {
    public static void main(String[] args) {
        String input = "chat bat mat fat";
        String regex = "\\b[a-z]+at\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Found match: " + matcher.group());
        }
    }
}
