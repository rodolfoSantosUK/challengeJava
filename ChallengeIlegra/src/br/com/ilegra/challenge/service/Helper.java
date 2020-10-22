package br.com.ilegra.challenge.service;

import java.util.Collection;

public class Helper {

    public static boolean isNullOrEmpty( final Collection< ? > c ) {
        return c == null || c.isEmpty();
    }


    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }

    public static String removeFirstChars(String str ) {
        return str.substring(1);
    }

}
