package com.github.ahapxor.services.impl;

import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

public class DecisionServiceImplMakeDecisionAmountMoreThan1000Test extends BaseDecisionServiceImplMakeDecisionTest {
    @Test
    public void testIfTheAmountIsMoreThan1000ItShouldBeRejectedWithAmountReason() throws Exception {
        final Purchase purchase = generatePurchaseWithAmount(1100);
        final Integer purchaseSum = 500;

        when(purchaseRepository.countSumAmountByEmail(eq(purchase.getEmail()))).thenReturn(purchaseSum);

        Decision decision = decisionService.makeDecision(purchase);

        assertEquals(Decision.AMOUNT, decision);
    }

    @Test
    public void testIfTheAmountIsMoreThan1000ItShouldBeRejectedWithAmountReasonEvenIfSumOverLimit() throws Exception {
        final Purchase purchase = generatePurchaseWithAmount(1100);
        final Integer purchaseSum = 1100;

        when(purchaseRepository.countSumAmountByEmail(eq(purchase.getEmail()))).thenReturn(purchaseSum);

        Decision decision = decisionService.makeDecision(purchase);

        assertEquals(Decision.AMOUNT, decision);
    }
}
