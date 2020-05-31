package creditcard;

import models.CreditCardModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static creditcard.VisaCC.NETWORK_VISA;
import static org.junit.jupiter.api.Assertions.*;

class VisaCCTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    //Check if first digit is acceptable for any digit other than 4
    @org.junit.jupiter.api.Test
    void isValidFirstDigit() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("1400000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        VisaCC visaCC = new VisaCC();
        boolean isValid = visaCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if null value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNull() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        VisaCC visaCC = new VisaCC();
        boolean isValid = visaCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if non-numeric value is acceptable
    @org.junit.jupiter.api.Test
    void isNotNumeric() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("54000000000W0000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        VisaCC visaCC = new VisaCC();
        boolean isValid = visaCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if length of cardnumber acceptable is 16 or 13
    @org.junit.jupiter.api.Test
    void isLengthSixteen() {
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("4410000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        VisaCC visaCC = new VisaCC();
        boolean isValid = visaCC.isValidCCType(creditCardModel);
        assertFalse(isValid);
    }

    //Check if it returns correct card network type
    @org.junit.jupiter.api.Test
    void getNetworkName() {

        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCardNumber("5410000000000000");
        creditCardModel.setExpirationDate("3/20/2030");
        creditCardModel.setNameOfCardholder("Alice");
        VisaCC visaCC = new VisaCC(creditCardModel);
        assertEquals(VisaCC.NETWORK_VISA,visaCC.getNetworkName());

    }
}