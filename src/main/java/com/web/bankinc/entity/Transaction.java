package com.web.bankinc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id", length = 36)
    private String transactionId;

    @Column(name = "card_id", length = 36)
    private String cardId;

    @Column(name = "amount", length = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "anulated")
    private boolean anulated = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    public void ensureId() {
        if(transactionId == null){
            transactionId = UUID.randomUUID().toString();
        }
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isAnulated() {
        return anulated;
    }

    public void setAnulated(boolean anulated) {
        this.anulated = anulated;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
