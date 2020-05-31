package creditcard;

import models.CreditCardModel;

public class DiscoverCC extends CreditCard {

    public static final String NETWORK_DISCOVER = "Discover";
    private static final String PREFIX = "6011";

    public DiscoverCC(CreditCardModel model) {
        super(model.getCardNumber(), model.getExpirationDate(), model.getExpirationDate(), NETWORK_DISCOVER);
    }

    public DiscoverCC(){
        super(NETWORK_DISCOVER);
    }

    @Override
    public boolean isValidCCType(CreditCardModel model)
    {

        if(model == null || model.getCardNumber() == null || !isValidNumber(model.getCardNumber()) || model.getCardNumber().length()!= 16) {
            return false;
        }
        String pan = model.getCardNumber();
        return pan.startsWith(PREFIX);
    }


    @Override
    public String getNetworkName() {
        return NETWORK_DISCOVER;
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
