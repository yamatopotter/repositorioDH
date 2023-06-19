package com.example.catalog.service;

import com.example.catalog.service.dto.CatalogDTO;

public interface CatalogService {
    CatalogDTO getCatalogByGenre(String genre);
}
