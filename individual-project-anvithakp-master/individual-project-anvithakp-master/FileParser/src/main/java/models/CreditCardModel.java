package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import parser.PanFormatDeserializer;

@JsonPropertyOrder(value = {"CardNumber", "ExpirationDate", "NameOfCardholder"})
public class CreditCardModel {

    @JsonProperty("CardNumber")
    @JacksonXmlProperty(localName = "CardNumber")
    @JsonDeserialize(using = PanFormatDeserializer.class)
    private String CardNumber;


    @JsonProperty("ExpirationDate")
    @JacksonXmlProperty(localName = "ExpirationDate")
    private String ExpirationDate;



    @JsonProperty("NameOfCardholder")
    @JacksonXmlProperty(localName = "NameOfCardholder")

    private String NameOfCardholder;


    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }

    public String getNameOfCardholder() {
        return NameOfCardholder;
    }

    public void setNameOfCardholder(String nameOfCardholder) {
        NameOfCardholder = nameOfCardholder;
    }

    @Override
    public String toString() {
        return "Card{" +
                "CardNumber=" + CardNumber +
                ", ExpirationDate='" + ExpirationDate + '\'' +
                ", NameOfCardholder='" + NameOfCardholder + '\'' +
                '}';
    }
}


