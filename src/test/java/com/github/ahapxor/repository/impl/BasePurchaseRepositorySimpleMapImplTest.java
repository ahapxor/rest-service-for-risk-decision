package com.github.ahapxor.repository.impl;

import com.github.ahapxor.BaseTestCase;

public class BasePurchaseRepositorySimpleMapImplTest extends BaseTestCase{
    protected PurchaseRepositorySimpleMapImpl repository;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        repository = new PurchaseRepositorySimpleMapImpl();
    }
}
