package com.github.ahapxor.utils;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.utils.ConverterBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class ConverterFactorySourceTest extends BaseTestCase {
    @Mock Decision decisionMock;
    @Mock PurchaseDto purchaseDto;

    @Rule public ExpectedException exception = ExpectedException.none();

    ConverterBuilder builder;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        builder = new ConverterBuilder();
    }

    @Test
    public void testDestinationShouldReturnDecisionConverterForDecisionDto() throws Exception {
        ConverterBuilder.ConverterFactory<DecisionDto> factory = builder.destination(DecisionDto.class);
        ConverterBuilder.EntityConverter<Decision, DecisionDto> converter = factory.source(decisionMock);

        assertTrue(converter instanceof ConverterBuilder.DecisionConverter);
    }

    @Test
    public void testDestinationShouldReturnPurchaseConverterForPurchase() throws Exception {
        ConverterBuilder.ConverterFactory<Purchase> factory = builder.destination(Purchase.class);
        ConverterBuilder.EntityConverter<PurchaseDto, Purchase> converter = factory.source(purchaseDto);

        assertTrue(converter instanceof ConverterBuilder.PurchaseDtoConverter);
    }

    @Test
    public void testDestinationShouldThrowIllegalArgumentIfSourceObjectIsNull() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Source object can't be null");

        builder.destination(Purchase.class).source(null);
    }

    @Test
    public void testDestinationShouldThrowNoSuchElementInCaseMappingNotFound() throws Exception {
        exception.expect(NoSuchElementException.class);
        exception.expectMessage("Converter for " + decisionMock + " is missing");

        builder.destination(Purchase.class).source(decisionMock);
    }
}
