package com.web.bankinc.controller;

import com.web.bankinc.dto.PurchaseDTO;
import com.web.bankinc.entity.Transaction;
import com.web.bankinc.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
