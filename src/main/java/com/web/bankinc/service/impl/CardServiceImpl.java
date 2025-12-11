package com.web.bankinc.service.impl;

import com.web.bankinc.entity.Card;
import com.web.bankinc.exception.BusinessException;
import com.web.bankinc.repository.CardRepository;
import com.web.bankinc.service.CardService;
import com.web.bankinc.util.CardNumberGenerator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.YearMonth;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public String generatedCardNumber(String productId) {

        String cardId = CardNumberGenerator.generate(productId);
        Card card = new Card();
        card.setCardId(cardId);
        card.setProductId(productId);
        card.setActive(false);
        card.setBlocked(false);
        card.setBalance(BigDecimal.ZERO);

        YearMonth expiration = YearMonth.now().plusYears(3);
        card.setExpiration(expiration.toString());

        cardRepository.save(card);

        return cardId;
    }

    @Override
    public Card enrollCard(String cardId) {

        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new BusinessException("Tarjeta no existe"));

        if(card.isActive())
            throw new BusinessException("La tarjeta ya está activa");

        card.setActive(true);

        return cardRepository.save(card);
    }

}
