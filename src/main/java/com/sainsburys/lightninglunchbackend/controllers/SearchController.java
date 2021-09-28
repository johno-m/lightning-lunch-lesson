package com.sainsburys.lightninglunchbackend.controllers;

import com.sainsburys.lightninglunchbackend.models.Product;
import com.sainsburys.lightninglunchbackend.models.SearchResponse;
import com.sainsburys.lightninglunchbackend.services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
@CrossOrigin(origins = "*")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("{searchTerm}")
    public ResponseEntity<?> search(@PathVariable("searchTerm") String searchTerm){

        List<Product> results = searchService.search(searchTerm);
        SearchResponse.Meta meta = new SearchResponse.Meta();
        meta.setCurrentPage(1);
        meta.setPageSize(24);
        meta.setTotalData(results.size());
        meta.setTotalPages(1);

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setMeta(meta);
        searchResponse.setData(results);

        return ResponseEntity.ok(searchResponse);
    }

}
