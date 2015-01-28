package com.github.ahapxor.controllers;

import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import com.github.ahapxor.services.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DecisionController {

    final private DecisionService decisionService;

    @Autowired public DecisionController( DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @RequestMapping(value = "/decisions", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody public DecisionDto make(@RequestBody PurchaseDto purchase) {
        return new DecisionDto(true, "stub");
    }
}
