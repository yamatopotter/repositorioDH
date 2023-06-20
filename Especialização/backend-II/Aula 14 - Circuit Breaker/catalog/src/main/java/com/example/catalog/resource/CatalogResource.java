package com.example.catalog.resource;

import com.example.catalog.service.CatalogService;
import com.example.catalog.service.dto.CatalogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private CatalogService service;

    @GetMapping("/{genre}")
    public ResponseEntity<CatalogDTO> getCatalogByGenre(@PathVariable String genre){
        return ResponseEntity.ok(service.getCatalogByGenre(genre));
    }
}