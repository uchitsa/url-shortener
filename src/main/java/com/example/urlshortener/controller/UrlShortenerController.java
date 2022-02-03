package com.example.urlshortener.controller;

import com.example.urlshortener.model.UrlShortener;
import com.example.urlshortener.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping
public class UrlShortenerController {

    private final UrlShortenerRepository repository;

    @Autowired
    public UrlShortenerController(UrlShortenerRepository repository) {
        this.repository = repository;
    }

    @PostMapping(path = "/")
    public String create(String url) {

        return null;
    }

    @GetMapping(path = "/{urlHash}")
    public ResponseEntity<String> redirectToOriginal(@PathVariable("urlHash") String urlHash) {
        UrlShortener urlShortener = repository.getByUrlHash(urlHash);
        if (Objects.nonNull(urlShortener)) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", urlShortener.getOriginalURL());
            return new ResponseEntity<String>(httpHeaders, HttpStatus.FOUND);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

}
