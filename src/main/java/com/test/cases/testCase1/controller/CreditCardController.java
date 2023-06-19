package com.test.cases.testCase1.controller;

import com.test.cases.testCase1.model.CreditCardValidator;
import com.test.cases.testCase1.model.CreditCard;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreditCardController {

    @Resource
    private CreditCardValidator creditCardValidator;

    @PostMapping("/validateCreditCard")
    public ResponseEntity<String> validateCreditCard(@Valid @RequestBody CreditCard creditCard,
                                                     BindingResult bindingResult) {
        creditCardValidator.validate(creditCard, bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid credit card number.");
        }

        return ResponseEntity.ok("Valid credit card number.");
    }
}
