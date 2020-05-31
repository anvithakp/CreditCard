package creditcard;

import models.CreditCardModel;

public class MasterCC extends CreditCard {

    public static final String NETWORK_MASTER = "Mastercard";

    public MasterCC() {
        super(NETWORK_MASTER);
    }

    public MasterCC(CreditCardModel model) {
        super(model.getCardNumber(), model.getExpirationDate(), model.getNameOfCardholder(), NETWORK_MASTER);
    }

    @Override
    protected boolean isValidCCType(CreditCardModel model) {

        if(model == null || model.getCardNumber() == null || !isValidNumber(model.getCardNumber()) || model.getCardNumber().length()!= 16) {
            return false;
        }

        String pan = model.getCardNumber();

        int firstDigit = Character.getNumericValue(pan.charAt(0));
        int secondDigit = Character.getNumericValue(pan.charAt(1));

        return firstDigit == 5 && ( secondDigit >=1 && secondDigit < 6);
    }


    @Override
    public String getNetworkName() {
        return NETWORK_MASTER;
    }

    @Override
    public CreditCard getInstance(CreditCardModel model) {
        if (model == null)
            return null;
        if (isValidCCType(model)) {
            return new MasterCC(model);
        } else if (nextProcessor != null) {
            return nextProcessor.getInstance(model);
        }
        return null;
    }
}

