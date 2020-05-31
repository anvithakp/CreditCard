import creditcard.CreditCard;
import creditcard.CreditCardFactory;
import models.CreditCardModel;
import models.CreditCardOutput;
import parser.Parser;
import parser.ParserFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Client {
    public static void main(String[] args) throws Exception {

        System.out.println("args = " + Arrays.deepToString(args));

        Parser parser = ParserFactory.getParser(args[0], args[1]);
        List<CreditCardModel> cards = parser.parse();


        List<CreditCardOutput> result = new ArrayList<>();


        cards.forEach(System.out::println);
        final CreditCard chain = CreditCardFactory.getChainOfCreditcards();


        cards.forEach( e -> {
            CreditCard creditInstance = chain.getInstance(e);
            System.out.println("Instance = " + creditInstance);
            CreditCardOutput creditCardOutput = new CreditCardOutput();
            if (creditInstance == null) {
                creditCardOutput.setError("InvalidCardNumber");
                creditCardOutput.setCardType("Invalid");
                try {
                    creditCardOutput.setCardNumber(new BigDecimal(e.getCardNumber()));
                } catch (Exception ex) {
                    creditCardOutput.setCardNumber(new BigDecimal(0));
                }
            } else {
                creditCardOutput.setError("None");
                creditCardOutput.setCardType(creditInstance.getNetworkName());
                creditCardOutput.setCardNumber(new BigDecimal(creditInstance.getPan()));
            }
            result.add(creditCardOutput);
        });

        parser.writeResult(result);



    }
}