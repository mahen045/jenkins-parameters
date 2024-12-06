package org.example.regex;

public class RegexReplace {
    public static void main(String[] args) {
        String input = "cat123bat456mat";
        String regex = "\\d+";
        String result = input.replaceAll(regex, "#");
        System.out.println(result); // Output: cat#bat#mat
    }
}
