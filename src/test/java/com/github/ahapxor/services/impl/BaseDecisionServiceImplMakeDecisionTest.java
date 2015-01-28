package com.github.ahapxor.services.impl;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.repository.PurchaseRepository;
import com.github.ahapxor.services.DecisionService;
import org.mockito.Mock;

public class BaseDecisionServiceImplMakeDecisionTest extends BaseTestCase {
    @Mock protected PurchaseRepository purchaseRepository;

    protected DecisionService decisionService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        decisionService = new DecisionServiceImpl(purchaseRepository);
    }

}
