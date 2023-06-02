package org.example.com;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    public static void display(String langTag) {
        Locale locale;
        if (langTag != null) {
            locale = Locale.forLanguageTag(langTag);
        } else {
            locale = Locale.getDefault();
        }

        try {
            Currency currency = Currency.getInstance(locale);
            DateFormatSymbols dfs = new DateFormatSymbols(locale);
            String[] weekdays = new String[7];
            System.arraycopy(dfs.getWeekdays(), 0, weekdays, 0, 7);
            String[] months = new String[12];
            System.arraycopy(dfs.getMonths(), 0, months, 0, 12);

            System.out.println("Country: " + locale.getDisplayCountry()
                    + " (" + locale.getDisplayName() + ")");
            System.out.println("Language: " + locale.getDisplayLanguage()
                    + " (" + locale.getDisplayLanguage(Locale.ENGLISH) + ")");
            System.out.println("Currency: " + currency.getCurrencyCode()
                    + " (" + currency.getDisplayName() + ")");
            System.out.print("Week Days: ");
            for (String weekday : weekdays) {
                System.out.println(weekday + ", ");
            }
            System.out.print("Months: ");
            for (String month : months) {
                System.out.println(month + ", ");
            }

            SimpleDateFormat df = new SimpleDateFormat("MMMM d, yyyy (d MMMM yyyy)", locale);
            System.out.println("Today: " + df.format(new Date()));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid locale");
        }
    }
}
