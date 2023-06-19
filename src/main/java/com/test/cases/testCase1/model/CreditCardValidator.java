package com.test.cases.testCase1.model;

import com.test.cases.testCase1.model.CreditCard;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CreditCardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CreditCard.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreditCard creditCard = (CreditCard) target;
        String cardNumber = creditCard.getCardNumber().replaceAll("\\s","");
        ValidationUtils.rejectIfEmpty(errors, "cardNumber", "field.required");
        if (!isValidCreditCard(cardNumber)) {
            errors.rejectValue("cardNumber", "creditCard.invalid");
        }
    }

    private boolean isValidCreditCard(String cardNumber) {
        int length = cardNumber.length();
        int total = 0;
        boolean isSecondDigit = false;

        for (int i = length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            if (isSecondDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            total += digit;
            isSecondDigit = !isSecondDigit;
        }

        return total % 10 == 0;
    }
}
