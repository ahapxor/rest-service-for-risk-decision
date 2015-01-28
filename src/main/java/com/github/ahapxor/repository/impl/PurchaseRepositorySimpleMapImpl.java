package com.github.ahapxor.repository.impl;

import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.repository.PurchaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class PurchaseRepositorySimpleMapImpl implements PurchaseRepository {
    @Override
    public Collection<Purchase> findByEmail(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int countSumAmountByEmail(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Purchase save(Purchase purchase) {
        throw new UnsupportedOperationException();
    }
}
