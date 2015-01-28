package com.github.ahapxor.repository.impl;

import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.repository.PurchaseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PurchaseRepositorySimpleMapImpl implements PurchaseRepository {
    static List<Purchase> storage = new LinkedList<>();

    @Override
    public Collection<Purchase> findByEmail(String email) {
        Collection<Purchase> result = new LinkedList<>();

        if(StringUtils.isEmpty(email)) {
            return result;
        }

        for(Purchase purchase : storage) {
            if(email.equals(purchase.getEmail())) {
                result.add(purchase);
            }
        }

        return result;
    }

    @Override
    public int countSumAmountByEmail(String email) {
        int result = 0;

        if(StringUtils.isEmpty(email)) {
            return result;
        }

        for(Purchase purchase : storage) {
            if(email.equals(purchase.getEmail())) {
                result += purchase.getAmount();
            }
        }

        return result;
    }

    @Override
    public Purchase save(Purchase purchase) {
        storage.add(purchase);

        return purchase;
    }
}
