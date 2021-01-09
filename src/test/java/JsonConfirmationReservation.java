import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class JsonConfirmationReservation extends TestCase {

    @Test
    public void testObjectToJson() throws Exception{
        String path ="src/main/data/soulaimane.json";
        String wrongPath = "src/main/data/soulaimanes.json";

        ConfirmationReservation confirmationReservation = ConfirmationReservation.jsonParser(path);

        // Test object exist and read file
        assertNotNull(confirmationReservation);

        // Test Holder
        Holder holder = confirmationReservation.holder;
        assertSame(Holder.class, holder.getClass());
        assertEquals("Ahmed", holder.name);
        assertEquals("Chetoui", holder.surname);

        // Test Rooms
        List<Room> rooms = confirmationReservation.rooms;
        assertSame(Room.class, rooms.get(0).getClass());
        assertEquals(1,rooms.size());
        assertEquals("dsjklqjdsqljdslqdjsqdsq", rooms.get(0).ratekey);

        // Test remark
        String remark = confirmationReservation.remark;
        assertEquals("booking remarks are to be written here.", remark);

        // Test paymentData
        PaymentData paymentData = confirmationReservation.paymentData;
        assertSame(PaymentData.class, paymentData.getClass());
        assertNotNull(paymentData.contactData);
        assertNotNull(paymentData.paymentCard);

        // Test paymentCard
        PaymentCard paymentCard = confirmationReservation.paymentData.paymentCard;
        assertSame(PaymentCard.class, paymentCard.getClass());
        assertEquals("Visa",paymentCard.cardType);
        assertEquals("404040404040",paymentCard.cardNumber);
        assertEquals("Holder Name",paymentCard.cardHolderName);
        assertEquals("0320",paymentCard.expiryDate);
        assertEquals("123",paymentCard.cardCVC);

        // Test contactData
        ContactData contactData = confirmationReservation.paymentData.contactData;
        assertSame(ContactData.class, contactData.getClass());
        assertEquals("a.nejoui@gmail.com",contactData.email);
        assertEquals("0662783933", contactData.phoneNumber);

    }
    //end
}
