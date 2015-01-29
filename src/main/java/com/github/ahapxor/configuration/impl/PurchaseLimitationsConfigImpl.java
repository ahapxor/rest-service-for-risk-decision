package com.github.ahapxor.configuration.impl;

import com.github.ahapxor.configuration.PurchaseLimitationsConfig;
import org.springframework.stereotype.Component;

@Component
public class PurchaseLimitationsConfigImpl implements PurchaseLimitationsConfig {
    final Integer LOYAL_PURCHASE_LIMIT = 10;
    final Integer MAX_VALID_PURCHASE_AMOUNT = 1000;
    final Integer DEBT_LIMIT = 1000;

    @Override
    public int loyalPurchaseLimit() {
        return LOYAL_PURCHASE_LIMIT;
    }

    @Override
    public int maxValidPurchaseAmount() {
        return MAX_VALID_PURCHASE_AMOUNT;
    }

    @Override
    public int debtLimit() {
        return DEBT_LIMIT;
    }
}
