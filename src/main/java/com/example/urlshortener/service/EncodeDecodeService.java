package com.example.urlshortener.service;

import org.springframework.stereotype.Service;

@Service
public class EncodeDecodeService {

    private static final String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final char[] allowedChars = alphanumeric.toCharArray();
    private final int base = allowedChars.length;

    public String encode(long n) {
        StringBuilder encoded = new StringBuilder();

        if (n == 0) {
            return String.valueOf(allowedChars[0]);
        }

        while (n > 0) {
            encoded.append(allowedChars[(int) (n % base)]);
            n = n / base;
        }

        return encoded.reverse().toString();
    }

    public long decode(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        long decoded = 0;

        int cnt = 1;
        for (char c : chars) {
            decoded += alphanumeric.indexOf(c) * Math.pow(base, length - cnt);
            cnt++;
        }
        return decoded;
    }
}

