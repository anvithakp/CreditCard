package parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import models.CreditCardModel;
import models.CreditCardOutput;
import models.XmlOutPut;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class XmlParser implements Parser {

    private String inputFileName;
    private String outPutFileName;

    public List<CreditCardModel> parse() {
        System.out.println("FileName is " + inputFileName);
        XMLInputFactory f = XMLInputFactory.newFactory();
        try {
            XMLStreamReader sr = f.createXMLStreamReader(new FileInputStream(inputFileName));
            XmlMapper mapper = new XmlMapper();
            List<CreditCardModel> cards = mapper.readValue(sr, new TypeReference<List<CreditCardModel>>() {});
            sr.close();
            return cards;

        } catch (IOException | XMLStreamException e) {
            System.out.println("parser.XmlParser exception " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean writeResult(List<CreditCardOutput> result) {
        XmlMapper objectMapper = new XmlMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(BigDecimal.class, new PanFormatSerializer());
        objectMapper.registerModule(module);
        objectMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);


        XmlOutPut xmlOutPut = new XmlOutPut();
        xmlOutPut.setOutputs(result);

        try {
            objectMapper.writeValue(new File(outPutFileName), xmlOutPut);
            return true;
        } catch (IOException e) {
            System.out.println("parser.XmlParser write exception " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public XmlParser(String filename, String outPutFileName) {
        this.inputFileName = filename;
        this.outPutFileName = outPutFileName;
    }

}
