package com.github.ahapxor.integrationTests;

import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import com.github.ahapxor.entities.Decision;
import org.jfairy.producer.person.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DecisionControllerMakeIntegrationTest extends BaseIntegrationTest {

    @Test
    public void testRegularPurchaseShouldReturnOk() throws Exception {
        Person person = getPerson();
        PurchaseDto purchaseDto =
                new PurchaseDto(person.email(), person.firstName(), person.lastName(), producer.randomInt(500));

        DecisionDto decisionDto = callDecisionMakeApi(purchaseDto);

        assertEquals(Decision.Reason.ok.name(), decisionDto.getReason());
        assertTrue(decisionDto.isAccepted());
    }
    @Test
    public void testPurchaseOverWithAmountOver1000ShouldAlwaysBeRejectedWithAmountReason() throws Exception {
        Person person = getPerson();
        PurchaseDto purchaseDto =
                new PurchaseDto(person.email(), person.firstName(), person.lastName(), producer.randomBetween(1000, 2000));

        DecisionDto decisionDto = callDecisionMakeApi(purchaseDto);

        assertEquals(Decision.Reason.amount.name(), decisionDto.getReason());
        assertFalse(decisionDto.isAccepted());
    }
    @Test
    public void testIfPurchaseSumWithCurrentAmountMoreThan1000CurrentPurchaseShouldBeRejectedWithReasonDebt()
            throws Exception {
        Person person = getPerson();
        PurchaseDto purchaseDtoRegular =
                new PurchaseDto(person.email(), person.firstName(), person.lastName(), producer.randomBetween(600, 700));
        PurchaseDto purchaseDtoOverLimit =
                new PurchaseDto(person.email(), person.firstName(), person.lastName(), producer.randomBetween(600, 700));

        callDecisionMakeApi(purchaseDtoRegular);
        DecisionDto decisionDtoDebt = callDecisionMakeApi(purchaseDtoOverLimit);

        assertEquals(Decision.Reason.debt.name(), decisionDtoDebt.getReason());
        assertFalse(decisionDtoDebt.isAccepted());
    }
    @Test
    public void testIfPurchaseWithAmountLessThan10ShouldAlwaysBeAccepted()
            throws Exception {
        Person person = getPerson();
        PurchaseDto purchaseDtoRegular =
                new PurchaseDto(person.email(), person.firstName(), person.lastName(), 999);
        PurchaseDto purchaseDtoWithAmount10 =
                new PurchaseDto(person.email(), person.firstName(), person.lastName(), producer.randomBetween(1, 9));

        callDecisionMakeApi(purchaseDtoRegular);
        DecisionDto decisionDtoOk = callDecisionMakeApi(purchaseDtoWithAmount10);

        assertEquals(Decision.Reason.ok.name(), decisionDtoOk.getReason());
        assertTrue(decisionDtoOk.isAccepted());
    }
}
