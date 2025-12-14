package com.web.bankinc.controller;

import com.web.bankinc.dto.PurchaseDTO;
import com.web.bankinc.dto.TransactionAnulationDTO;
import com.web.bankinc.entity.Transaction;
import com.web.bankinc.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(
            summary = "Realizar compra",
            description = "Realiza una compra debitando el saldo de la tarjeta"
    )
    @PostMapping("/purchase")
    public ResponseEntity<Transaction> purchase(@RequestBody PurchaseDTO purchaseDTO){
        return ResponseEntity.ok(transactionService.purchase(purchaseDTO));
    }

    @Operation(
            summary = "Consultar transacción",
            description = "Obtiene una transacción por id"
    )
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> get(@PathVariable UUID transactionId){
        return ResponseEntity.ok(transactionService.getTransaction(transactionId));
    }

    @Operation(
            summary = "Anular transacción",
            description = "Anula una transacción por id"
    )
    @PostMapping("/anulation")
    public ResponseEntity<?> anulate(@RequestBody TransactionAnulationDTO dto) {
        transactionService.anulate(dto);
        return ResponseEntity.ok().body("Transacción anulada correctamente");
    }

}
