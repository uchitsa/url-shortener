package com.example.urlshortener.controller;

import com.example.urlshortener.dto.LongUrlRequest;
import com.example.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping(path = "/")
    public String convertToShortUrl(@RequestBody LongUrlRequest request) {
        return urlShortenerService.makeShortUrl(request);
    }

    @GetMapping(path = "/{urlShort}")
    public ResponseEntity<String> redirectToOriginal(@PathVariable("urlShort") String urlShort) {
        String originalUrl = urlShortenerService.getOriginalUrl(urlShort);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }

}
