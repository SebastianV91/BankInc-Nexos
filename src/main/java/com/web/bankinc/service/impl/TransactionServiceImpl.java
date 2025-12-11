package com.web.bankinc.service.impl;

import com.web.bankinc.dto.PurchaseDTO;
import com.web.bankinc.entity.Card;
import com.web.bankinc.entity.Transaction;
import com.web.bankinc.exception.BusinessException;
import com.web.bankinc.repository.CardRepository;
import com.web.bankinc.repository.TransactionRepository;
import com.web.bankinc.service.TransactionService;
import org.springframework.stereotype.Service;

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

}
