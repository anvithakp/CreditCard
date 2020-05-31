package creditcard;

import models.CreditCardModel;

public class CreditCardFactory {

    public static CreditCard getCreditInstance(CreditCardModel model) {
        if (model == null)
            return null;
//
//        if (MasterCC.isValidCCType(model)) {
//            System.out.println("Mastercard match Found");
//            return new MasterCC(model);
//        } else if (VisaCC.isValidCCType(model)) {
//            System.out.println("Visa match Found");
//            return new VisaCC(model);
//        } else if (AmExCC.isValidCCType(model)) {
//            System.out.println("Amex match Found");
//            return new AmExCC(model);
//        } else if (DiscoverCC.isValidCCType(model)) {
//            System.out.println("Discover match Found");
//            return new DiscoverCC(model);
//        }
//
//        System.out.println("No  match Found");
        return null;

    }

    public static CreditCard getChainOfCreditcards(){

        MasterCC masterCC = new MasterCC();
        VisaCC visaCC = new VisaCC();
        AmExCC amExCC = new AmExCC();
        DiscoverCC discoverCC = new DiscoverCC();

        masterCC.setNextProcessor(visaCC); // start of chain
        visaCC.setNextProcessor(amExCC);
        amExCC.setNextProcessor(discoverCC);
        discoverCC.setNextProcessor(null); // end of chain

        return masterCC;
    }
}
