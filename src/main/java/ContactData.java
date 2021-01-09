import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="contactData")
public class ContactData {
    @JacksonXmlProperty(localName="email")
    String email;

    @JacksonXmlProperty(localName="phoneNumber")
    String phoneNumber;

    public ContactData() {
    }

    public ContactData(String email, String phoneNumber){
        this.email=email;
        this.phoneNumber = phoneNumber;
    }
    //end
}
