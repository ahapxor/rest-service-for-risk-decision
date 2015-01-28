package com.github.ahapxor.services;

import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;

public interface DecisionService {
    Decision makeDecision(Purchase purchase);
}
