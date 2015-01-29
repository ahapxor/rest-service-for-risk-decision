package com.github.ahapxor.configuration;

import org.springframework.stereotype.Component;


public interface PurchaseLimitationsConfig {
    int loyalPurchaseLimit();
    int maxValidPurchaseAmount();
    int debtLimit();
}
