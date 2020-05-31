package parser;

import models.CreditCardModel;
import models.CreditCardOutput;

import java.util.List;

public interface Parser {

    List<CreditCardModel> parse();

    boolean writeResult(List<CreditCardOutput> result);

}
