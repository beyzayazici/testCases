package com.test.cases;

import com.test.cases.testCase1.model.CreditCard;
import com.test.cases.testCase1.model.CreditCardValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTestCases {
    private CreditCardValidator validator;
    private Errors errors;
    private CreditCard creditCard = new CreditCard();

    @BeforeEach
    public void setup() {
        validator = new CreditCardValidator();
        errors = new BeanPropertyBindingResult(creditCard, "creditCard");
    }

    @Test
    public void testValidCreditCard() {
        creditCard.setCardNumber("4556 73758 6899 855");

        validator.validate(creditCard, errors);

        assertFalse(errors.hasErrors());
    }

    @Test
    public void testInvalidCreditCard() {
        creditCard.setCardNumber("4024007109022143");

        validator.validate(creditCard, errors);

        assertTrue(errors.hasErrors());
        assertEquals(1, errors.getErrorCount());
        assertNotNull(errors.getFieldError("cardNumber"));
        assertEquals("creditCard.invalid", errors.getFieldError("cardNumber").getCode());
    }

    @Test
    public void testEmptyCreditCard() {
        creditCard.setCardNumber("");

        validator.validate(creditCard, errors);

        assertTrue(errors.hasErrors());
        assertEquals(1, errors.getErrorCount());
        assertNotNull(errors.getFieldError("cardNumber"));
        assertEquals("field.required", errors.getFieldError("cardNumber").getCode());
    }

}
