package com.web.bankinc.util;

import java.security.SecureRandom;

public class CardNumberGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generate(String productId){

        if(productId == null || productId.length() != 6){
            throw new IllegalArgumentException("productId debe tener 6 digitos");
        }

        StringBuilder sb = new StringBuilder(productId);

        while(sb.length() < 16){
            int digit = RANDOM.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();

    }

}
