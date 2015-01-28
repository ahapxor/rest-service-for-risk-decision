package com.github.ahapxor.repository.impl;

import com.github.ahapxor.entities.Purchase;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class PurchaseRepositorySimpleMapImplFindByEmailTest extends BasePurchaseRepositorySimpleMapImplTest {

    @Test
    public void testFindByNullEmailShouldReturnEmptyCollection() throws Exception {
        final Collection<Purchase> purchases = repository.findByEmail(null);

        assertTrue(purchases.isEmpty());
    }

    @Test
    public void testFindByEmptyEmailShouldReturnEmptyCollection() throws Exception {
        final Collection<Purchase> purchases = repository.findByEmail("");

        assertTrue(purchases.isEmpty());
    }

    @Test
    public void testInCaseOfSearchingForNonExistingRecordEmptyCollectionShouldBeReturned() throws Exception {
        final Collection<Purchase> purchases = repository.findByEmail(person.email());

        assertTrue(purchases.isEmpty());
    }
}
