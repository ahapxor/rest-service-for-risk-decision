package com.github.ahapxor.repository.impl;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.entities.Purchase;

public class BasePurchaseRepositorySimpleMapImplTest extends BaseTestCase{
    protected PurchaseRepositorySimpleMapImpl repository;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repository = new PurchaseRepositorySimpleMapImpl();
    }

    protected Purchase generatePurchase() {
        return generatePurchaseWithAmount(producer.randomBetween(1, 999));
    }

    protected Purchase generatePurchaseWithAmount(Integer amount) {
        return generatePurchaseWithAmountAndEmail(person.email(), amount);
    }

    protected Purchase generatePurchaseWithAmountAndEmail(String email, Integer amount) {
        return new Purchase(
                email,
                person.firstName(),
                person.lastName(),
                amount
        );
    }
}
