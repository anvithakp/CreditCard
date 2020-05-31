package creditcard;

import models.CreditCardModel;
import static creditcard.MasterCC.NETWORK_MASTER;
import static org.junit.jupiter.api.Assertions.*;

class MasterCCTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    //Check if first digit is acceptable for any digit other than 5
    @org.junit.jupiter.api.Test
    void isValidFirstDigit() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("1400000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        MasterCC masterCC = new MasterCC(creditCardModel);
        boolean isValid = masterCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if null value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNull() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        MasterCC masterCC = new MasterCC(creditCardModel);
        boolean isValid = masterCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if non-numeric value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNumeric() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("54000000000Q0070");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        MasterCC masterCC = new MasterCC(creditCardModel);
        boolean isValid = masterCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if length of cardnumber acceptable is 16
    @org.junit.jupiter.api.Test
    void isLengthSixteen() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("5410000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        MasterCC masterCC = new MasterCC(creditCardModel);
        boolean isValid = masterCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if 2nd digit is [1-5]
    @org.junit.jupiter.api.Test
    void isSecondDigitValid() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("5710000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        MasterCC masterCC = new MasterCC(creditCardModel);
        boolean isValid = masterCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if it returns correct card network type
    @org.junit.jupiter.api.Test
    void getNetworkName() {

        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("5410000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        MasterCC masterCC = new MasterCC(creditCardModel);
        assertEquals(MasterCC.NETWORK_MASTER,masterCC.getNetworkName());

    }
}