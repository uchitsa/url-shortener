package com.example.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UrlShortener {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "original_url")
    private String originalURL;

    @Column(name = "created_time", columnDefinition = "TIMESTAMP")
    private ZonedDateTime createdTime;
}
