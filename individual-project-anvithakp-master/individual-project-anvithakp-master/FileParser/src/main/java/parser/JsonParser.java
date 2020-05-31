package parser;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.CreditCardModel;
import models.CreditCardOutput;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonParser implements Parser {

    private String filename;
    private String outPutFileName;


    public List<CreditCardModel> parse() {
        System.out.println("FileName is " + filename);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Arrays.asList(objectMapper.readValue(new File(filename), CreditCardModel[].class));
        } catch (IOException e) {
            System.out.println("parser.JsonParser exception " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean writeResult(List<CreditCardOutput> result) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(outPutFileName), result);
            return true;
        } catch (IOException e) {
            System.out.println("Json write exception " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public JsonParser(String filename, String outPutFileName) {
        this.filename = filename;
        this.outPutFileName = outPutFileName;
    }
}
