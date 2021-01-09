import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


public class Holder {
    public Holder() {
    }

    @JacksonXmlProperty(localName="name")
    String name;

    @JacksonXmlProperty(localName="surname")
    String surname;

    public Holder(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    //end
}
