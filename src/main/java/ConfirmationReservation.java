import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@JacksonXmlRootElement(localName="confirmationreservation")
public class ConfirmationReservation{
    public ConfirmationReservation() {
    }

    @JacksonXmlProperty(localName="holder")
    Holder holder;

    @JacksonXmlElementWrapper(localName="rooms")
    @JsonProperty("room")
    List<Room> rooms;

    @JacksonXmlProperty(localName="remark")
    String remark;

    @JacksonXmlProperty(localName="paymentData")
    PaymentData paymentData;

    public ConfirmationReservation(Holder holder, List<Room> rooms, String remark, PaymentData paymentData) {
        this.holder = holder;
        this.rooms = rooms;
        this.remark = remark;
        this.paymentData = paymentData;
    }

    // Convertir fichier json à un objet confirmationreservation
    public static ConfirmationReservation jsonParser(String path){
        try{
            Gson jsonReader = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            ConfirmationReservation confirmationReservation = jsonReader.fromJson(reader, ConfirmationReservation.class);
            reader.close();
            return confirmationReservation;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Convertir un objet confirmationreservation au fichier json
    // fichier generer dans le dossier data
    public static void objectToJson(ConfirmationReservation confirmationReservation, String path) throws IOException {
        //Gson jsonParser = new Gson();
        //jsonParser.toJson(confirmationReservation, new FileWriter(path));
        Gson jsonParser = new Gson();
        try (FileWriter writer = new FileWriter(path)) {
            jsonParser.toJson(confirmationReservation, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Convertir fichier xml à un objet confirmationreservation
    public static  ConfirmationReservation xmlToObject (String path){
        try {
            XmlMapper xmlMapper = new XmlMapper();
 //           ConfirmationReservation confirmationReservation =
            return xmlMapper.readValue(new File(path), ConfirmationReservation.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Convertir un objet confirmationreservation au fichier json
    // fichier generer dans le dossier data
    public static void objectToXML(ConfirmationReservation confirmationReservation, String path) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(path), confirmationReservation);
    }
    //end
}
