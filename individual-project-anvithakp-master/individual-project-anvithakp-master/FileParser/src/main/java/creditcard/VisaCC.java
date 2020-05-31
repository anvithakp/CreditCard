package creditcard;

import models.CreditCardModel;

public class VisaCC extends CreditCard{

    public static final String NETWORK_VISA = "Visa";

    public VisaCC(CreditCardModel model) {
        super(model.getCardNumber(), model.getExpirationDate(), model.getNameOfCardholder(), NETWORK_VISA);

    }

    public VisaCC(){
        super(NETWORK_VISA);
    }

    @Override
    protected  boolean isValidCCType(CreditCardModel model)
    {

        if(model == null || model.getCardNumber() == null || !isValidNumber(model.getCardNumber()) || model.getCardNumber().length() < 1) {
            return false;
        }

        return model.getCardNumber().charAt(0) == '4' && (model.getCardNumber().length() == 13 || model.getCardNumber().length() == 16);
    }

    @Override
    public String getNetworkName() {
        return NETWORK_VISA;
    }

    @Override
    public CreditCard getInstance(CreditCardModel model) {
        if (model == null)
            return null;
        if (isValidCCType(model)) {
            return new VisaCC(model);
        } else if (nextProcessor != null) {
            return nextProcessor.getInstance(model);
        }
        return null;
    }
}
