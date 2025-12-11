package com.web.bankinc.service;

import com.web.bankinc.entity.Card;
import java.math.BigDecimal;

public interface CardService {

    String generatedCardNumber(String productId);

    Card enrollCard(String cardId);

    void blockCard(String cardId);

    BigDecimal addBalance(String cardId, BigDecimal amount);

}
