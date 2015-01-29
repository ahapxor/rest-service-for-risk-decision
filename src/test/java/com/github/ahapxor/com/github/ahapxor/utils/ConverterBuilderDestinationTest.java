package com.github.ahapxor.com.github.ahapxor.utils;

import com.github.ahapxor.BaseTestCase;
import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.utils.ConverterBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNotNull;

public class ConverterBuilderDestinationTest extends BaseTestCase {
    ConverterBuilder builder;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Override
    public void setUp() throws Exception {
        super.setUp();
        builder = new ConverterBuilder();
    }

    @Test
    public void testDestinationShouldReturnConverterFactoryIfDestClassSpecified() throws Exception {
        ConverterBuilder.ConverterFactory<Decision> factory = builder.destination(Decision.class);

        assertNotNull(factory);
    }

    @Test
    public void testIllegalArgumentExceptionShouldBeThrownIfDestClassNotSpecified() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Destination class can't be null");

        builder.destination(null);
    }
}
