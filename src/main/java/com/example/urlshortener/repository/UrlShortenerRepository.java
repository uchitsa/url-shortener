package com.example.urlshortener.repository;

import com.example.urlshortener.model.UrlShortener;
import org.springframework.data.repository.CrudRepository;

public interface UrlShortenerRepository extends CrudRepository<UrlShortener, Long> {
}
