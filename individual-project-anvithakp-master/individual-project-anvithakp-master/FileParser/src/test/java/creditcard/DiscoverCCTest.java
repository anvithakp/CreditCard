package creditcard;

import models.CreditCardModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DiscoverCCTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    //Check if first four digits is acceptable for any digits
    @org.junit.jupiter.api.Test
    void isValidFirstFourDigits() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("60100000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        DiscoverCC discoverCC = new DiscoverCC(creditCardModel);
        boolean isValid = discoverCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if null value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNull() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        DiscoverCC discoverCC = new DiscoverCC(creditCardModel);
        boolean isValid = discoverCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if non-numeric value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNumeric() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("601100000000W000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");

        DiscoverCC discoverCC = new DiscoverCC(creditCardModel);
        boolean isValid = discoverCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if length of cardnumber acceptable is 16
    @org.junit.jupiter.api.Test
    void isLengthSixteen() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("6011000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");

        DiscoverCC discoverCC = new DiscoverCC(creditCardModel);
        boolean isValid = discoverCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if it returns correct card network type
    @org.junit.jupiter.api.Test
    void getNetworkName() {

        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("6011000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        DiscoverCC discoverCC = new DiscoverCC(creditCardModel);
        assertEquals(DiscoverCC.NETWORK_DISCOVER, discoverCC.getNetworkName());

    }
}