import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="room")
public class Room {

    @JacksonXmlProperty(localName="ratekey")
    String ratekey;

    public Room() {
    }

    @JacksonXmlElementWrapper(localName="details")
    @JsonProperty("detail")
    List<Detail> details;

    public Room(String ratekey, List<Detail> details) {
        this.ratekey = ratekey;
        this.details = details;
    }
    //end
}
