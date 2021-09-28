package com.sainsburys.lightninglunchbackend.controllers;

import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.models.BasketRequest;
import com.sainsburys.lightninglunchbackend.services.BasketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("baskets")
@CrossOrigin(origins = "*")
public class BasketsController {

    private BasketsService basketsService;

    public BasketsController(BasketsService basketService) {
        this.basketsService = basketService;
    }

    // Create Basket
    @PostMapping
    public ResponseEntity<?> createBasket(@RequestBody BasketRequest basketRequest) throws ProductNotFoundException {
        return ResponseEntity.ok(basketsService.createBasket(basketRequest));
    }

    // Add to a basket
    @PutMapping("{basketId}")
    public ResponseEntity<?> addToBasket(@PathVariable("basketId") String basketId, @RequestBody BasketRequest basketRequest) throws ProductNotFoundException {

        return ResponseEntity.ok(basketsService.addToBasket(basketId, basketRequest));
    }

    // Get a basket
    @GetMapping("{basketId}")
    public ResponseEntity<?> getBasket(@PathVariable("basketId") String basketId){
        return ResponseEntity.ok(basketsService.getBasket(basketId));
    }

}
