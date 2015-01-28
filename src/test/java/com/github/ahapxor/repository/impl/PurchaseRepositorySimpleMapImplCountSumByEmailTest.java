package com.github.ahapxor.repository.impl;

import com.github.ahapxor.entities.Purchase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseRepositorySimpleMapImplCountSumByEmailTest extends BasePurchaseRepositorySimpleMapImplTest {
    @Test
    public void testCountByExistingInStorageEmail() throws Exception {

        final Integer amount1 = 10;
        Purchase purchase1 = createAndSavePurchaseWithAmount(amount1);
        final Integer amount2 = 20;
        Purchase purchase2 = createAndSavePurchaseWithAmount(amount2);

        Integer sum1 = repository.countSumAmountByEmail(purchase1.getEmail());
        Integer sum2 = repository.countSumAmountByEmail(purchase2.getEmail());

        assertEquals(amount1, sum1);
        assertEquals(amount2, sum2);
    }
    @Test
    public void testCountSumOfFewPurchasesByExistingInStorageEmail() throws Exception {

        final Integer amount1 = 10;
        final Integer amount2 = 20;
        final String email = person.email();
        Purchase purchase1 = generatePurchaseWithAmountAndEmail(email, amount1);
        repository.save(purchase1);
        Purchase purchase2 = generatePurchaseWithAmountAndEmail(email, amount2);
        repository.save(purchase2);

        Integer sum = repository.countSumAmountByEmail(purchase1.getEmail());

        assertEquals(amount1 + amount2, sum.longValue());
    }

    @Test
    public void testCountWithNullEmailShouldReturn0() throws Exception {
        assertEquals(0, repository.countSumAmountByEmail(null));
    }

    @Test
    public void testCountWithEmptyEmailShouldReturn0() throws Exception {
        assertEquals(0, repository.countSumAmountByEmail(""));
    }

    private Purchase createAndSavePurchaseWithAmount(final Integer amount) {
        final Purchase purchase = generatePurchaseWithAmount(amount);
        return repository.save(purchase);
    }
}
