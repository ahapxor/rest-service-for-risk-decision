package com.github.ahapxor.controllers;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.services.DecisionService;
import com.github.ahapxor.utils.ConverterBuilder;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DecisionControllerMakeTest extends BaseTestCase {
    @Mock DecisionService decisionServiceMock;
    @Mock ConverterBuilder converterBuilderMock;
    @Mock ConverterBuilder.ConverterFactory concreteConverterFactoryMock;
    @Mock ConverterBuilder.EntityConverter purchaseConverterMock;
    @Mock ConverterBuilder.EntityConverter decisionConverterMock;
    @Mock PurchaseDto purchaseDtoMock;
    @Mock DecisionDto decisionDtoMock;
    @Mock Purchase purchaseMock;
    @Mock Decision decisionMock;

    DecisionController decisionController;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        decisionController = new DecisionController(decisionServiceMock, converterBuilderMock);
    }

    @Test
    public void testMake() throws Exception {
        when(converterBuilderMock.destination(any(Class.class))).thenReturn(concreteConverterFactoryMock);
        when(concreteConverterFactoryMock.source(eq(purchaseDtoMock))).thenReturn(purchaseConverterMock);
        when(concreteConverterFactoryMock.source(eq(decisionMock))).thenReturn(decisionConverterMock);
        when(purchaseConverterMock.convert()).thenReturn(purchaseMock);
        when(decisionConverterMock.convert()).thenReturn(decisionDtoMock);
        when(decisionServiceMock.makeDecision(purchaseMock)).thenReturn(decisionMock);

        DecisionDto decision = decisionController.make(purchaseDtoMock);

        assertEquals(decisionDtoMock, decision);
        verify(converterBuilderMock).destination(eq(Purchase.class));
        verify(concreteConverterFactoryMock).source(eq(purchaseDtoMock));
        verify(purchaseConverterMock).convert();
        verify(decisionServiceMock).makeDecision(eq(purchaseMock));
        verify(converterBuilderMock).destination(eq(DecisionDto.class));
        verify(concreteConverterFactoryMock).source(eq(decisionMock));
        verify(decisionConverterMock).convert();
    }
}
