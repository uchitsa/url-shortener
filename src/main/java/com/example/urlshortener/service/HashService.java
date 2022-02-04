package com.example.urlshortener.service;

import org.apache.commons.text.RandomStringGenerator;

public class HashService {

    private final RandomStringGenerator randomStringGenerator;

    public HashService() {
        this.randomStringGenerator = new RandomStringGenerator
                .Builder()
                .filteredBy(HashService::isAlphaNumeric)
                .build();
    }

    private static boolean isAlphaNumeric(int c) {
        return isAlpha(c) || isNumeric(c);
    }

    private static boolean isNumeric(int c) {
        return '0' <= c && c <= '9';
    }

    private static boolean isAlpha(int c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public String generateHash(int length) {
        return randomStringGenerator.generate(length);
    }
}

