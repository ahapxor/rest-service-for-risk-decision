package com.github.ahapxor;

import com.github.ahapxor.entities.Purchase;
import org.jfairy.Fairy;
import org.jfairy.producer.BaseProducer;
import org.jfairy.producer.person.Person;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class BaseTestCase {
    protected Fairy fairy;
    protected BaseProducer producer;

    protected Person getPerson() {
        return fairy.person();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        fairy = Fairy.create();
        producer = fairy.baseProducer();
    }

    protected Purchase generatePurchase() {
        return generatePurchaseWithAmount(producer.randomBetween(1, 999));
    }

    protected Purchase generatePurchaseWithAmount(Integer amount) {
        return generatePurchaseWithAmountAndEmail(getPerson().email(), amount);
    }

    protected Purchase generatePurchaseWithAmountAndEmail(String email, Integer amount) {
        return new Purchase(
                email,
                getPerson().firstName(),
                getPerson().lastName(),
                amount
        );
    }

}
