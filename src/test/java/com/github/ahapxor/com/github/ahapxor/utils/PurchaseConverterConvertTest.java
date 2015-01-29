package com.github.ahapxor.com.github.ahapxor.utils;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.utils.ConverterBuilder;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class PurchaseConverterConvertTest extends BaseTestCase {
    @Mock
    Decision decisionMock;

    ConverterBuilder builder;
    ConverterBuilder.ConverterFactory<DecisionDto> factory;
    ConverterBuilder.EntityConverter<Decision, DecisionDto> converter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        builder = new ConverterBuilder();
        factory = builder.destination(DecisionDto.class);
        converter = factory.source(decisionMock);
    }

    @Test
    public void testConvert() throws Exception {
        when(decisionMock.getReason()).thenReturn(Decision.Reason.ok);
        when(decisionMock.isAccepted()).thenReturn(true);

        DecisionDto decisionDto = converter.convert();

        assertEquals(Decision.Reason.ok.name(), decisionDto.getReason());
        assertTrue(decisionDto.isAccepted());
    }
}
