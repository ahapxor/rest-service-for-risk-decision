package com.github.ahapxor.services.impl;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.configuration.PurchaseLimitationsConfig;
import com.github.ahapxor.repository.PurchaseRepository;
import com.github.ahapxor.services.DecisionService;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class BaseDecisionServiceImplMakeDecisionTest extends BaseTestCase {
    @Mock protected PurchaseRepository purchaseRepository;
    @Mock protected PurchaseLimitationsConfig limitationsConfig;

    protected DecisionService decisionService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        when(limitationsConfig.debtLimit()).thenReturn(1000);
        when(limitationsConfig.maxValidPurchaseAmount()).thenReturn(1000);
        when(limitationsConfig.loyalPurchaseLimit()).thenReturn(10);
        decisionService = new DecisionServiceImpl(purchaseRepository, limitationsConfig);
    }

}
