package parser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import models.CreditCardModel;
import models.CreditCardOutput;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CsvParser implements Parser {

    private String filename;
    private String outPutFileName;

    @Override
    public List<CreditCardModel> parse() {

        System.out.println("FileName is " + filename);
        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        try {
            MappingIterator<CreditCardModel> iterator = mapper
                    .readerFor(CreditCardModel.class)
                    .with(schema)
                    .readValues(new File(filename));

            return iterator
                    .readAll();


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean writeResult(List<CreditCardOutput> result) {
        CsvMapper mapper = new CsvMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(BigDecimal.class, new PanFormatSerializer());
        mapper.registerModule(module);
        CsvSchema schema = mapper.schemaFor(CreditCardOutput.class).withUseHeader(true);
        ObjectWriter myObjectWriter = mapper.writer(schema);
        try {
            myObjectWriter.writeValue(new File(outPutFileName), result);
            return true;
        } catch (IOException e) {
            System.out.println("CSV write exception " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }



    public CsvParser(String filename, String outPutFileName) {
        this.filename = filename;
        this.outPutFileName = outPutFileName;
    }
}
