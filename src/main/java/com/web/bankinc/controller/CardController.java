package com.web.bankinc.controller;

import com.web.bankinc.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{productId}/number")
    public ResponseEntity<String> generate(@PathVariable String productId){
        return ResponseEntity.ok(cardService.generatedCardNumber(productId));
    }

}
