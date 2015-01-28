package com.github.ahapxor.services.impl;

import com.github.ahapxor.entities.Purchase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DecisionServiceImplMakeDecisionPurchaseValidationTest extends BaseDecisionServiceImplMakeDecisionTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void testValidatePurchaseNotNull() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("purchase could not be null");

        decisionService.makeDecision(null);
    }

    @Test
    public void testValidateAmountMoreThan0() throws Exception {
        final Integer amount = -5;

        Purchase purchase = generatePurchaseWithAmount(amount);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("purchase.amount should be more than 0, but was " + amount);

        decisionService.makeDecision(purchase);
    }

    @Test
    public void testValidateAmountEqual0() throws Exception {
        final Integer amount = 0;

        Purchase purchase = generatePurchaseWithAmount(0);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("purchase.amount should be more than 0, but was " + amount);

        decisionService.makeDecision(purchase);
    }

    @Test
    public void testValidateEmailIsEmpty() throws Exception {
        Purchase purchase = generatePurchaseWithAmountAndEmail("", 5);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("purchase.email should have value");

        decisionService.makeDecision(purchase);
    }

    @Test
    public void testValidateEmailIsNull() throws Exception {
        Purchase purchase = generatePurchaseWithAmountAndEmail(null, 5);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("purchase.email should have value");

        decisionService.makeDecision(purchase);
    }
}
