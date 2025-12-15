package com.web.bankinc.service.impl;

import com.web.bankinc.dto.PurchaseDTO;
import com.web.bankinc.dto.TransactionAnulationDTO;
import com.web.bankinc.entity.Card;
import com.web.bankinc.entity.Transaction;
import com.web.bankinc.exception.BusinessException;
import com.web.bankinc.repository.CardRepository;
import com.web.bankinc.repository.TransactionRepository;
import com.web.bankinc.service.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(CardRepository cardRepository, TransactionRepository transactionRepository) {
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Transaction purchase(PurchaseDTO purchaseDTO) {

        Card card = cardRepository.findById(purchaseDTO.getCardId())
                .orElseThrow(() -> new BusinessException("Tarjeta no existe"));

        if(!card.isActive())
            throw new BusinessException("Tarjeta no activa");

        if(card.isBlocked())
            throw new BusinessException("Tarjeta bloqueada");

        // Descontar dinero
        card.setBalance(card.getBalance().subtract(purchaseDTO.getPrice()));
        cardRepository.save(card);

        // Registrar transacción
        Transaction tx = new Transaction();
        tx.setCardId(card.getCardId());
        tx.setAmount(purchaseDTO.getPrice());

        return transactionRepository.save(tx);
    }

    @Override
    public Transaction getTransaction(UUID transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new BusinessException("Transacción no existe."));
    }

    @Override
    public void anulate(TransactionAnulationDTO transactionAnulationDTO) {

        Transaction transaction = transactionRepository.findById(transactionAnulationDTO.getTransactionId())
                .orElseThrow(() -> new BusinessException("Transacción no existe."));

        if(!transaction.getCardId().equals(transactionAnulationDTO.getCardId())) {
            throw new BusinessException("El cardId no coincide con la transacción");
        }

        if(transaction.isAnulated()) {
            throw new BusinessException("La transacción ya está anulada");
        }

        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(transaction.getCreatedAt(), now);

        if(diff.toHours() > 24){
            throw new BusinessException("La transacción supera las 24 horas y no puede ser anulada");
        }

        Card card = cardRepository.findById(transactionAnulationDTO.getCardId())
                .orElseThrow(() -> new BusinessException("Tarjeta no existe."));

        if(!card.isActive())
            throw new BusinessException("Tarjeta no activa");

        if(card.isBlocked())
            throw new BusinessException("Tarjeta bloqueada");

        YearMonth expiration = YearMonth.parse(card.getExpiration());
        if(expiration.isBefore(YearMonth.now()))
            throw new BusinessException("Tarjeta vencida");

        BigDecimal newBalance = card.getBalance().add(transaction.getAmount());
        card.setBalance(newBalance);
        cardRepository.save(card);

        transaction.setAnulated(true);
        transactionRepository.save(transaction);

    }

}
