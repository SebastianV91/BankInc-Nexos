package com.web.bankinc.service;

import com.web.bankinc.entity.Card;

public interface CardService {

    String generatedCardNumber(String productId);

    Card enrollCard(String cardId);

}
