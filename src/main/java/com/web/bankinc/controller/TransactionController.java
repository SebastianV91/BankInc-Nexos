package com.web.bankinc.controller;

import com.web.bankinc.dto.PurchaseDTO;
import com.web.bankinc.entity.Transaction;
import com.web.bankinc.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Transaction> purchase(@RequestBody PurchaseDTO purchaseDTO){
        return ResponseEntity.ok(transactionService.purchase(purchaseDTO));
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> get(@PathVariable String transactionId){
        return ResponseEntity.ok(transactionService.getTransaction(transactionId));
    }

}
