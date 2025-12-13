package com.web.bankinc.controller;

import com.web.bankinc.dto.AddBalanceDTO;
import com.web.bankinc.dto.CardEnrollDTO;
import com.web.bankinc.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Generar número de tarjeta",
            description = "Genera un número de tarjeta de 16 dígitos basado en el productId (6 dígitos)"
    )
    @GetMapping("/{productId}/number")
    public ResponseEntity<String> generate(@PathVariable String productId){
        return ResponseEntity.ok(cardService.generatedCardNumber(productId));
    }

    @Operation(
            summary = "Activar tarjeta",
            description = "Activa una tarjeta con cardId y holderName"
    )
    @PostMapping("/enroll")
    public ResponseEntity<?> enroll(@RequestBody CardEnrollDTO cardEnrollDTO){
        return ResponseEntity.ok(cardService.enrollCard(cardEnrollDTO.getCardId(), cardEnrollDTO.getHolderName()));
    }

    @Operation(
            summary = "Bloquear tarjeta",
            description = "Bloquea una tarjeta existente"
    )
    @DeleteMapping("/{cardId}")
    public ResponseEntity<?> block(@PathVariable String cardId){

        cardService.blockCard(cardId);

        return ResponseEntity.noContent().build();

    }

    @Operation(
            summary = "Recargar saldo",
            description = "Recarga una tarjeta con un monto especificado"
    )
    @PostMapping("/balance")
    public ResponseEntity<BigDecimal> addBalance(@RequestBody AddBalanceDTO addBalanceDTO){
        return ResponseEntity.ok(cardService.addBalance(addBalanceDTO.getCardId(), addBalanceDTO.getBalance()));
    }

    @Operation(
            summary = "Consultar saldo",
            description = "Consultar el saldo que tiene una tarjeta"
    )
    @GetMapping("/balance/{cardId}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable String cardId){
        return ResponseEntity.ok(cardService.getBalance(cardId));
    }

}
