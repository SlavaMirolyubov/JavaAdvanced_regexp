package com.mirolyubov;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formater {

    public static String formatNumbers(String string) {
        String badNumberStroke = string;
        Pattern pattern = Pattern.compile("\\+\\d\\(\\d{3}\\)\\s\\d{3}\\s\\d{2}\\s\\d{2}");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String number = matcher.group();
            String addPrefix = String.valueOf(Integer.valueOf(number.substring(1,2)) + 1);
            String finalNumber = number.replaceAll("\\+\\d", addPrefix)
                    .replaceAll("\\W", "");
            badNumberStroke = badNumberStroke.replace(number, finalNumber);
        }

        return badNumberStroke;
    }
}
