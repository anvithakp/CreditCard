package models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "root")
public class XmlOutPut {
    @JacksonXmlProperty(localName = "row")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CreditCardOutput> outputs;

    public List<CreditCardOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<CreditCardOutput> outputs) {
        this.outputs = outputs;
    }
}
