package com.github.ahapxor.services.impl;

import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

public class DecisionServiceImplMakeDecisionAmountLessThan10Test extends BaseDecisionServiceImplMakeDecisionTest {
    @Test
    public void testIfTheAmountIsLessThan10ItShouldBeAcceptedIfThereIsNoDebt() throws Exception {
        final Purchase purchase = generatePurchaseWithAmount(9);
        final Integer purchaseSum = 500;

        when(purchaseRepository.countSumAmountByEmail(eq(purchase.getEmail()))).thenReturn(purchaseSum);

        Decision decision = decisionService.makeDecision(purchase);

        assertEquals(Decision.OK, decision);
    }

    @Test
    public void testIfTheAmountIsLessThan10ItShouldBeAcceptedIfThereDespiteOfDebt() throws Exception {
        final Purchase purchase = generatePurchaseWithAmount(9);
        final Integer purchaseSum = 1100;

        when(purchaseRepository.countSumAmountByEmail(eq(purchase.getEmail()))).thenReturn(purchaseSum);

        Decision decision = decisionService.makeDecision(purchase);

        assertTrue(decision.isAccepted());
        assertEquals(Decision.OK, decision);
    }
}
