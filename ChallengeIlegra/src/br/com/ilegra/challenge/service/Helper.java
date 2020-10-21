package br.com.ilegra.challenge.service;

import java.util.Collection;

public class Helper {

    public static boolean isNullOrEmpty( final Collection< ? > c ) {
        return c == null || c.isEmpty();
    }

}
