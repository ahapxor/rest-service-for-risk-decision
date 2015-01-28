package com.github.ahapxor;

import org.jfairy.Fairy;
import org.jfairy.producer.BaseProducer;
import org.jfairy.producer.person.Person;
import org.junit.Before;

public class BaseTestCase {
    protected Fairy fairy;
    protected BaseProducer producer;

    protected Person getPerson() {
        return fairy.person();
    }

    @Before
    public void setUp() throws Exception {
        fairy = Fairy.create();
        producer = fairy.baseProducer();
    }

}
