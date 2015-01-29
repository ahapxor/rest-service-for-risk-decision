package com.github.ahapxor.integrationTests;

import com.github.ahapxor.dtos.PurchaseDto;
import org.jfairy.producer.person.Person;
import org.junit.Test;

public class DecisionControllerMakeValidationIntegrationTest extends BaseIntegrationTest {
    @Test(expected = ApiErrorException.class)
    public void testPurchaseWithEmptyEmailShouldCauseException() throws Exception {
        Person person = getPerson();
        PurchaseDto purchaseDto = new PurchaseDto(null, person.firstName(), person.lastName(), producer.randomInt(500));

        callDecisionMakeApi(purchaseDto);
    }
    @Test(expected = ApiErrorException.class)
    public void testPurchaseWithZeroAmountShouldCauseException() throws Exception {
        Person person = getPerson();
        PurchaseDto purchaseDto = new PurchaseDto(person.email(), person.firstName(), person.lastName(), 0);

        callDecisionMakeApi(purchaseDto);
    }
    @Test(expected = ApiErrorException.class)
    public void testPurchaseWithNegativeAmountShouldCauseException() throws Exception {
        Person person = getPerson();
        PurchaseDto purchaseDto = new PurchaseDto(person.email(), person.firstName(), person.lastName(), -10);

        callDecisionMakeApi(purchaseDto);
    }
}
