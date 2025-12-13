package com.web.bankinc.service;

import com.web.bankinc.entity.Card;
import java.math.BigDecimal;

public interface CardService {

    String generatedCardNumber(String productId);

    Card enrollCard(String cardId, String holderName);

    void blockCard(String cardId);

    BigDecimal addBalance(String cardId, BigDecimal amount);

    BigDecimal getBalance(String cardId);

}
