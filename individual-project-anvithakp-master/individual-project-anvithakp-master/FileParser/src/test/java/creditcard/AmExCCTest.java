package creditcard;

import models.CreditCardModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static creditcard.AmExCC.NETWORK_AMEX;
import static creditcard.MasterCC.NETWORK_MASTER;
import static org.junit.jupiter.api.Assertions.*;

class AmExCCTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Check if first digit is acceptable for any digit other than 3
    @org.junit.jupiter.api.Test
    void isValidFirstDigit() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("3400000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        AmExCC amExCC = new AmExCC(creditCardModel);
        boolean isValid = amExCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if null value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNull() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        AmExCC amExCC = new AmExCC(creditCardModel);
        boolean isValid = amExCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if non-numeric value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNumeric() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("34000000000W000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        AmExCC amExCC = new AmExCC(creditCardModel);
        boolean isValid = amExCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if length of cardnumber acceptable is 15
    @org.junit.jupiter.api.Test
    void isLengthSixteen() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("341000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        AmExCC amExCC = new AmExCC(creditCardModel);
        boolean isValid = amExCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if 2nd digit is 4 or 7
    @org.junit.jupiter.api.Test
    void isSecondDigitValid() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("350000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        AmExCC amExCC = new AmExCC(creditCardModel);
        boolean isValid = amExCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if it returns correct card network type
    @org.junit.jupiter.api.Test
    void getNetworkName() {

        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("341000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        AmExCC amExCC = new AmExCC(creditCardModel);
        assertEquals(AmExCC.NETWORK_AMEX,amExCC.getNetworkName());

    }
}