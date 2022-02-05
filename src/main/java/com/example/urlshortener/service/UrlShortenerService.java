package com.example.urlshortener.service;

import com.example.urlshortener.dto.LongUrlRequest;
import com.example.urlshortener.model.UrlShortener;
import com.example.urlshortener.repository.UrlShortenerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UrlShortenerService {

    private final UrlShortenerRepository urlShortenerRepository;
    private final EncodeDecodeService encodeDecodeService;

    public UrlShortenerService(UrlShortenerRepository urlShortenerRepository, EncodeDecodeService encodeDecodeService) {
        this.urlShortenerRepository = urlShortenerRepository;
        this.encodeDecodeService = encodeDecodeService;
    }

    public String makeShortUrl(LongUrlRequest request) {
        UrlShortener urlShortener = new UrlShortener();
        urlShortener.setOriginalURL(request.getLongUrl());
        UrlShortener entity = urlShortenerRepository.save(urlShortener);

        return encodeDecodeService.encode(entity.getId());
    }

    public String getOriginalUrl(String urlShort) {
        long id = encodeDecodeService.decode(urlShort);
        UrlShortener entity = urlShortenerRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException("Not found entity with short URL: " + urlShort));

        return entity.getOriginalURL();
    }
}
