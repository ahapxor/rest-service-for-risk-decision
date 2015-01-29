package com.github.ahapxor.controllers;

import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import com.github.ahapxor.entities.Decision;
import com.github.ahapxor.entities.Purchase;
import com.github.ahapxor.services.DecisionService;
import com.github.ahapxor.utils.ConverterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DecisionController {

    final private DecisionService decisionService;
    final private ConverterBuilder converterBuilder;

    @Autowired public DecisionController(final DecisionService decisionService,
                                         final ConverterBuilder converterBuilder) {
        this.decisionService = decisionService;
        this.converterBuilder = converterBuilder;
    }

    @RequestMapping(value = "/decisions", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody public DecisionDto make(@RequestBody final PurchaseDto purchaseDto) {
        Purchase purchase = converterBuilder.destination(Purchase.class).source(purchaseDto).convert();

        Decision decision = decisionService.makeDecision(purchase);

        return converterBuilder.destination(DecisionDto.class).source(decision).convert();
    }
}
