package com.github.ahapxor.services.impl;

import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.DecisionDebt;
import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.repository.PurchaseRepository;
import com.github.ahapxor.services.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DecisionServiceImpl implements DecisionService {

    final private PurchaseRepository purchaseRepository;

    @Autowired public DecisionServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    final Integer minValidPurchaseAmount = 10;
    final Integer maxValidPurchaseAmount = 1000;
    final Integer debtLimit = 1000;

    @Override
    public Decision makeDecision(Purchase purchase) {
        if(purchase == null) {
            throw new IllegalArgumentException("purchase could not be null");
        }
        if(purchase.getAmount() <= 0) {
            throw new IllegalArgumentException("purchase.amount should be more than 0, but was " + purchase.getAmount());
        }
        if(StringUtils.isEmpty(purchase.getEmail())) {
            throw new IllegalArgumentException("purchase.email should have value");
        }
        if(purchase.getAmount() < minValidPurchaseAmount) {
            return DecisionDebt.OK;
        }
        if(purchase.getAmount() > maxValidPurchaseAmount) {
            return DecisionDebt.AMOUNT;
        }
        Integer accountSum = purchaseRepository.countSumAmountByEmail(purchase.getEmail());
        if(purchase.getAmount() + accountSum > debtLimit) {
            return DecisionDebt.DEBT;
        }

        return Decision.OK;
    }
}
