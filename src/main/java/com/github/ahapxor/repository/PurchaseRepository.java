package com.github.ahapxor.repository;

import com.github.ahapxor.entities.Purchase;

import java.util.Collection;

public interface PurchaseRepository {
    Collection<Purchase> findByEmail(String email);
    int countSumAmountByEmail(String email);
    Purchase save(Purchase purchase);
}
