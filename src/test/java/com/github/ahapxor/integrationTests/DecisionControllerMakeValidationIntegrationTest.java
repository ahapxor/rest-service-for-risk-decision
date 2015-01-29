package com.github.ahapxor.integrationTests;

import com.github.ahapxor.dtos.PurchaseDto;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class DecisionControllerMakeValidationIntegrationTest extends BaseIntegrationTest {

    @DataProvider
    public static Object[][] getTestPurchases() {
        return new Object[][]{
                {createPurchaseWithEmptyEmail()},
                {createPurchaseWithZeroAmount()},
                {createPurchaseWithNegativeAmount()}
        };
    }

    @Test(expected = ApiErrorException.class)
    @UseDataProvider("getTestPurchases")
    public void testPurchaseFieldsValidation(PurchaseDto purchaseDto) throws Exception {
        callDecisionMakeApi(purchaseDto);
    }

    private static PurchaseDto createPurchaseWithEmptyEmail() {
        return createPurchase(null, producer.randomInt(500));
    }
    private static PurchaseDto createPurchaseWithZeroAmount() {
        return createPurchase(producer.randomInt(0));
    }
    private static PurchaseDto createPurchaseWithNegativeAmount() {
        return createPurchase(producer.randomInt(-10));
    }
}
