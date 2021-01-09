import com.google.gson.Gson;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertNotEquals;


public class ConfirmationReservationToJson extends TestCase {
    @Test
    public void testJsonParser() throws Exception{

        String path = "src/main/data/jsontestfile.json";

        // elements of confirmation resercvation
            // holder
        Holder holder = new Holder("Ahmed","Chetoui");

            // rooms = list of room objects, 1 room is ratekey and list of detail
        Detail detail1 = new Detail(1, "AD", "First Adult Name", "Surname");
        Detail detail2 = new Detail(1, "AD", "Second Adult Name", "Surname");
        List<Detail> details = new ArrayList<Detail>(Arrays.asList(detail1, detail2));
        Room room = new Room("dsjklqjdsqljdslqdjsqdsq", details);
        List<Room> rooms = new ArrayList<Room>(Arrays.asList(room));

            // payment data is paymencard and contact data objects
        PaymentCard paymentCard = new PaymentCard("Visa", "404040404040", "Holder Name", "0320", "123");
        ContactData contactData = new ContactData("a.nejoui@gmail.com", "0662783933");
        PaymentData paymentData = new PaymentData(paymentCard, contactData);

        String remark = "booking remarks are to be written here.";

            // final object
        ConfirmationReservation confirmationReservation = new ConfirmationReservation(holder, rooms,remark, paymentData);
        ConfirmationReservation.objectToJson(confirmationReservation, path);
        File file = new File(path);
        assertNotNull(file);
        assertNotEquals(0, file.length());

    }
    //end
}
