package com.github.ahapxor.repository.impl;

import com.github.ahapxor.entities.Purchase;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class PurchaseRepositorySimpleMapImplFindByEmailTest extends BasePurchaseRepositorySimpleMapImplTest {

    @DataProvider
    public static Object[][] getTestEmails() {
        return new Object[][]{
                {null},
                {""},
                {getPerson().email()}
        };
    }

    @Test
    @UseDataProvider("getTestEmails")
    public void testFindShouldReturnEmptyCollectionForEmail(String email) throws Exception {
        final Collection<Purchase> purchases = repository.findByEmail(email);

        assertTrue(purchases.isEmpty());
    }
}
