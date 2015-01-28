package com.github.ahapxor.repository.impl;

import com.github.ahapxor.entities.Purchase;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class PurchaseRepositorySimpleMapImplSaveTest extends BasePurchaseRepositorySimpleMapImplTest {

    @Test
    public void testSavePurchase() throws Exception {
        final Purchase newPurchase = generatePurchase();

        repository.save(newPurchase);
        final Collection<Purchase> purchases = repository.findByEmail(newPurchase.getEmail());

        assertNotNull(purchases);
        assertFalse(purchases.isEmpty());
        assertEquals(1, purchases.size());
        assertTrue(purchases.contains(newPurchase));

    }

    @Test
    public void testSaveFewDifferentPurchases() throws Exception {
        final Purchase newPurchase1 = generatePurchase();
        final Purchase newPurchase2 = generatePurchase();

        repository.save(newPurchase1);
        repository.save(newPurchase2);
        final Collection<Purchase> purchases1 = repository.findByEmail(newPurchase1.getEmail());
        final Collection<Purchase> purchases2 = repository.findByEmail(newPurchase1.getEmail());

        assertFalse(purchases1.isEmpty());
        assertEquals(1, purchases1.size());
        assertTrue(purchases1.contains(newPurchase1));

        assertFalse(purchases2.isEmpty());
        assertEquals(1, purchases2.size());
        assertTrue(purchases2.contains(newPurchase1));
    }

    @Test
    public void testSaveFewPurchasesWithSameEmail() throws Exception {
        final Purchase newPurchase = generatePurchase();

        repository.save(newPurchase);
        repository.save(newPurchase);
        final Collection<Purchase> purchases = repository.findByEmail(newPurchase.getEmail());

        assertNotNull(purchases);
        assertFalse(purchases.isEmpty());
        assertEquals(2, purchases.size());
    }
}
