package creditcard;

import models.CreditCardModel;

public abstract class CreditCard {

    protected String pan;
    protected String expiry;
    protected String name;
    protected final String networkName;


    public CreditCard getNextProcessor() {
        return nextProcessor;
    }

    public void setNextProcessor(CreditCard nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public CreditCard nextProcessor;

    protected CreditCard(String pan, String expiry, String name, String networkname) {
        this.pan = pan;
        this.expiry = expiry;
        this.name = name;
        this.networkName = networkname;
    }

    protected CreditCard(String networkname) {
        this.networkName = networkname;
    }


    public  String getPan() {
        return pan;
    }

    protected boolean isValidNumber(String pan){
        try {
            Long.parseLong(pan);
            return true;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return false;
    }

    public abstract String getNetworkName();

    @Override
    public String toString() {
        return "creditcard.CreditCard{" +
                "pan='" + pan + '\'' +
                ", expiry='" + expiry + '\'' +
                ", name='" + name + '\'' +
                ", networkname='" + networkName + '\'' +
                '}';
    }

    protected abstract boolean isValidCCType(CreditCardModel model);

    public abstract CreditCard getInstance(CreditCardModel model);
}
