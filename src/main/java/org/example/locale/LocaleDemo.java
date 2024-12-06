package org.example.locale;
import java.text.NumberFormat;
import java.util.Locale;
public class LocaleDemo {
    public static void main(String[] args) {
        Locale locale = Locale.FRANCE;
        // Number formatting
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println(currencyFormatter.format(12345.67));
        // Display name
        System.out.println(locale.getDisplayName()); // "French (France)"
    }
}
