import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="detail")
public class Detail {
    @JacksonXmlProperty(localName="roomId")
    int roomId;

    @JacksonXmlProperty(localName="type")
    String type;

    @JacksonXmlProperty(localName="name")
    String name;

    public Detail() {
    }

    @JacksonXmlProperty(localName="surname")
    String surname;

    public Detail(int roomId, String type, String name, String surname) {
        this.roomId = roomId;
        this.type = type;
        this.name = name;
        this.surname = surname;
    }
    //end
}
