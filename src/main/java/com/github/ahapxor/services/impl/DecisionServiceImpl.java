package com.github.ahapxor.services.impl;

import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.repository.PurchaseRepository;
import com.github.ahapxor.services.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecisionServiceImpl implements DecisionService {

    final private PurchaseRepository purchaseRepository;

    @Autowired public DecisionServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Decision makeDecision(Purchase purchase) {
        throw new UnsupportedOperationException();
    }
}
