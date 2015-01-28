package com.github.ahapxor;

import org.jfairy.Fairy;
import org.jfairy.producer.BaseProducer;
import org.jfairy.producer.person.Person;
import org.junit.Before;

public class BaseTestCase {
    protected Fairy fairy;
    protected Person person;
    protected BaseProducer producer;

    @Before
    public void setUp() throws Exception {
        fairy = Fairy.create();
        person = fairy.person();
        producer = fairy.baseProducer();
    }

}
