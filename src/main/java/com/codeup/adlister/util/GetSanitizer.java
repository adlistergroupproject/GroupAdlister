package com.codeup.adlister.util;

public class GetSanitizer {

    public static String sanitize(String query){
        if(!query.contains("query=")){
            return null; // TODO: add exceptions
        }

        int begin = query.indexOf('=') + 1;
        String sanitized = query.substring(begin, query.length());
        sanitized = sanitized.replaceAll("[+]", ", ");
        return sanitized;
    }
}
