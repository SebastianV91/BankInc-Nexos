package com.web.bankinc.controller;

import com.web.bankinc.dto.CardEnrollDTO;
import com.web.bankinc.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/enroll")
    public ResponseEntity<?> enroll(@RequestBody CardEnrollDTO cardEnrollDTO){
        return ResponseEntity.ok(cardService.enrollCard(cardEnrollDTO.getCardId()));
    }

}
