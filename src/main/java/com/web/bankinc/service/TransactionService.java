package com.web.bankinc.service;

import com.web.bankinc.dto.PurchaseDTO;
import com.web.bankinc.entity.Transaction;

public interface TransactionService {

    Transaction purchase(PurchaseDTO purchaseDTO);

    Transaction getTransaction(String transactionId);

}
