package com.web.bankinc.controller;

import com.web.bankinc.dto.AddBalanceDTO;
import com.web.bankinc.dto.CardEnrollDTO;
import com.web.bankinc.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
        return ResponseEntity.ok(cardService.enrollCard(cardEnrollDTO.getCardId(), cardEnrollDTO.getHolderName()));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<?> block(@PathVariable String cardId){

        cardService.blockCard(cardId);

        return ResponseEntity.noContent().build();

    }

    @PostMapping("/balance")
    public ResponseEntity<BigDecimal> addBalance(@RequestBody AddBalanceDTO addBalanceDTO){
        return ResponseEntity.ok(cardService.addBalance(addBalanceDTO.getCardId(), addBalanceDTO.getBalance()));
    }

    @GetMapping("/balance/{cardId}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable String cardId){
        return ResponseEntity.ok(cardService.getBalance(cardId));
    }

}
