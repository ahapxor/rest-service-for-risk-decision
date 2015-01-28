package com.github.ahapxor.controllers;

import com.github.ahapxor.dtos.DecisionDto;
import com.github.ahapxor.dtos.PurchaseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DecisionController {

    @RequestMapping(value = "/decision", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody public DecisionDto index(@RequestBody PurchaseDto purchase) {
        return new DecisionDto(true, "stub");
    }
}
