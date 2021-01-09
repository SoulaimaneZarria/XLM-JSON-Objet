import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="paymentCard")
public class PaymentCard {
    @JacksonXmlProperty(localName="cardType")
    String cardType;

    @JacksonXmlProperty(localName="cardNumber")
    String cardNumber;

    @JacksonXmlProperty(localName="cardHolderName")
    String cardHolderName;

    public PaymentCard() {
    }

    @JacksonXmlProperty(localName="expiryDate")
    String expiryDate;

    @JacksonXmlProperty(localName="cardCVC")
    String cardCVC;

    public PaymentCard(String cardType, String cardNumber, String cardHolderName, String expiryDate, String cardCVC) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cardCVC = cardCVC;
    }
    //end
}
