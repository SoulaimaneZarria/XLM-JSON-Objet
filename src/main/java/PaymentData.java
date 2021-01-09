import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="paymentData")
public class PaymentData {
    @JacksonXmlProperty(localName="paymentCard")
    PaymentCard paymentCard;

    @JacksonXmlProperty(localName="contactData")
    ContactData contactData;

    public PaymentData() {
    }

    public PaymentData(PaymentCard paymentCard, ContactData contactData) {
        this.paymentCard = paymentCard;
        this.contactData = contactData;
    }
    //end
}
