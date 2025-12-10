package com.web.bankinc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @Column(name = "card_id", length = 16)
    private String cardId;

    @Column(name = "product_id", length = 6, nullable = false)
    private String productId;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "expiration", length = 7)
    private String expiration;

    @Column(name = "active")
    private boolean active = false;

    @Column(name = "blocked")
    private boolean blocked = false;

    @Column(name = "balance", precision = 12, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
