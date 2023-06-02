package org.example.com;

import java.util.Locale;

public class DisplayLocales {
    public static void display() {
        Locale[] available = Locale.getAvailableLocales();
        for (Locale locale : available) {
            System.out.println(locale.getDisplayCountry()
                    + "-"
                    + locale.getCountry()
                    + " "
                    + locale.getDisplayLanguage()
                    + "-"
                    + locale.getLanguage());
        }
    }
}
