package com.example.urlshortener.controller;

import com.example.urlshortener.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UrlShortenerController {

    private final UrlShortenerRepository repository;

    @Autowired
    public UrlShortenerController(UrlShortenerRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/")
    public String create(String url){

        return null;
    }

    @GetMapping(path = "/{urlHash}")
    public ResponseEntity redirectToOriginal(@PathVariable("urlHash") String urlHash){

        return null;
    }

}
