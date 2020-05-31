package creditcard;

import models.CreditCardModel;

public class AmExCC extends CreditCard{

    public static final String NETWORK_AMEX = "AMEX";
    public AmExCC(CreditCardModel model ) {
        super(model.getCardNumber(), model.getExpirationDate(), model.getNameOfCardholder(), NETWORK_AMEX);
    }

    public AmExCC() {
        super(NETWORK_AMEX);
    }

    @Override
    protected boolean isValidCCType(CreditCardModel model)
    {
        if(model == null || model.getCardNumber() == null ||  !isValidNumber(model.getCardNumber()) || model.getCardNumber().length()!= 15) {
            return false;
        }
        String pan = model.getCardNumber();
        return pan.charAt(0) == '3' && (pan.charAt(1) == '4' || pan.charAt(1) == '7');
    }


    @Override
    public String getNetworkName() {
        return networkName;
    }

    @Override
    public CreditCard getInstance(CreditCardModel model) {
        if (model == null)
            return null;
        if (isValidCCType(model)) {
            return new AmExCC(model);
        } else if (nextProcessor != null) {
            return nextProcessor.getInstance(model);
        }
        return null;
    }
}
