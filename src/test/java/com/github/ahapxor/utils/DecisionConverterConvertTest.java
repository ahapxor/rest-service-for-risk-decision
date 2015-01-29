package com.github.ahapxor.utils;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.dtos.PurchaseDto;
import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.utils.ConverterBuilder;
import org.jfairy.producer.person.Person;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DecisionConverterConvertTest extends BaseTestCase {
    @Mock PurchaseDto purchaseDtoMock;

    ConverterBuilder builder;
    ConverterBuilder.ConverterFactory<Purchase> factory;
    ConverterBuilder.EntityConverter<PurchaseDto, Purchase> converter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        builder = new ConverterBuilder();
        factory = builder.destination(Purchase.class);
        converter = factory.source(purchaseDtoMock);
    }

    @Test
    public void testConvert() throws Exception {
        final int amount = producer.randomInt(1000);
        Person person = getPerson();

        when(purchaseDtoMock.getAmount()).thenReturn(amount);
        when(purchaseDtoMock.getEmail()).thenReturn(person.email());
        when(purchaseDtoMock.getFirstName()).thenReturn(person.firstName());
        when(purchaseDtoMock.getLastName()).thenReturn(person.lastName());

        Purchase purchase = converter.convert();

        assertEquals(amount, purchase.getAmount());
        assertEquals(person.email(), purchase.getEmail());
        assertEquals(person.firstName(), purchase.getFirstName());
        assertEquals(person.lastName(), purchase.getLastName());
    }
}
