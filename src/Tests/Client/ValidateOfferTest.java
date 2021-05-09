package Client;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidateOfferTest {
    @Test
    public void doOperation() {

        Client client = new Client("client1", "earth", "species", "C0001",
                "clien", "Client1", "client@client.com");

        Offer offer = new Offer();
        List<Offer> uncheckedOffers = new ArrayList<Offer>();

        LocalDate date = LocalDate.of(2020, 01, 02);

        offer.setCreator("client1");
        offer.setId("C0012");
        offer.setDateEnd(date);
        offer.setType(3);
        offer.setPrice(200000);
       // offer.setStarshipIdList();

        String creator = "client1";
        String id = "C0012";
        LocalDate dateT = LocalDate.of(2020, 01, 02);
        int type = 3;
        int price = 200000;

        String continueAdding = "n";

        if (uncheckedOffers != null && !uncheckedOffers.isEmpty()) {
            boolean validate = false;

            while (!validate) {
                String adding = "y";
                //   controller.deleteFromUncheckedOffers(info);
                if (adding == "y") {
                    //  controller.addOffer(info);
                    assertEquals(creator, offer.getCreator());
                    assertEquals(id, offer.getId());
                    assertEquals(dateT, offer.getDateEnd());
                    assertEquals(type, offer.getType());
                    assertEquals(price, offer.getPrice());
                } else {
                    //Client c = controller.getClient(info.getCreator());
                    if (client.isWarning()) {
                        client.setWarning(false);
                        client.setBanned(LocalDate.now().plusDays(5));
                    } else {
                        client.setWarning(true);
                        Notification not = new Notification("Your offer was not validated. Next time you will be banned for 5 days.");
                        client.addNotification(not);
                    }
                    // controller.actualizateClient(c);
                }

                // uncheckedOffers = controller.getUncheckedOffersList();
                if (!uncheckedOffers.isEmpty()) {
                    validate = (continueAdding == "n");
                } else {
                    validate = true;
                }
            }
            assertTrue(validate);
        }
    }
}