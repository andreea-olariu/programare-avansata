package org.example.app;

import org.example.com.DisplayLocales;
import org.example.com.SetLocale;
import org.example.com.Info;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void explore() {
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages");
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            System.out.print(messages.getString("prompt"));
            command = scanner.nextLine().trim().toLowerCase();
            switch (command) {
                case "locales" -> {
                    System.out.println(messages.getString("locales"));
                    DisplayLocales.display();
                }
                case "set" -> {
                    System.out.println("Input locale tag: ");
                    String langTag = scanner.nextLine().trim();
                    SetLocale.set(langTag);

                    messages = ResourceBundle.getBundle("res.Messages", Locale.getDefault());
                    String localeSetMessage = messages.getString("locale.set");
                    System.out.println(MessageFormat.format(localeSetMessage, langTag));
                }
                case "info" -> {
                    System.out.println("Input locale tag (or leave empty for default): ");
                    String infoLocale = scanner.nextLine().trim();
                    Info.display(infoLocale);
                    String infoMessage = messages.getString("info");
                    System.out.println(MessageFormat.format(infoMessage, infoLocale));
                }
                case "exit" -> {
                    break;
                }
                default -> System.out.println(messages.getString("invalid"));
            }
        }
    }
}