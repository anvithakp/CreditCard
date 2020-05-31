package parser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class PanFormatSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        MathContext mc = new MathContext(2);
        BigDecimal exponent = new BigDecimal(o.toString(),mc);
        jsonGenerator.writeObject(exponent.toString());
    }
}
