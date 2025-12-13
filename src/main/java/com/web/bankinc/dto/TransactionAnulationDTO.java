package com.web.bankinc.dto;

import java.util.UUID;

public class TransactionAnulationDTO {

    private String cardId;
    private UUID transactionId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

}
