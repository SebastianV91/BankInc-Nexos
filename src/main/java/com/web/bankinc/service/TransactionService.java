package com.web.bankinc.service;

import com.web.bankinc.dto.PurchaseDTO;
import com.web.bankinc.dto.TransactionAnulationDTO;
import com.web.bankinc.entity.Transaction;

import java.util.UUID;

public interface TransactionService {

    Transaction purchase(PurchaseDTO purchaseDTO);

    Transaction getTransaction(UUID transactionId);

    void anulate(TransactionAnulationDTO transactionAnulationDTO);

}
