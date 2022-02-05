package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlShortener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UrlShortenerRepository extends JpaRepository<UrlShortener, Long> {

    UrlShortener getByUrlHash(String urlHash);

}
