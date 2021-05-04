package Client;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateOfferTest {


    @Test
    public void doOperation(){

        Client client = new Client("client1", "earth", "species", "C0001",
                        "clien", "Client1", "client@client.com");

        Offer offer = new Offer();
        boolean addShip = false;

        String typeOfShip = "2";
        String starship = "Destroyer";
        String continueAdding = "n";
        int price = 200000;

        String starshipT = null;

        while (!addShip) {
            switch (typeOfShip) {
                case "1":
                    starshipT = "Space Station";
                    offer.setType(0);
                    break;
                case "2":
                    starshipT = "Destroyer";
                    offer.setType(1);
                    break;
                case "3":
                    starshipT = "Freighter";
                    offer.setType(2);
                    break;
                case "4":
                    starshipT = "Fighter";
                    offer.setType(3);
                    break;
            }
            addShip = (continueAdding == "n");

        }
        starship.getClass().getSimpleName();

        offer.setCreator(client.getIdNumber());
        offer.setPrice(price);

        assertEquals(price, offer.getPrice());
        assertEquals(starship, starshipT);
        assertEquals(offer.getCreator(), client.getIdNumber());
        assertTrue(addShip);

    }

    @Test
    public void askDate() {

        int year = 2010;
        int month = 01;
        int day = 10;

        LocalDate date = LocalDate.of(year, month, day);
        assertEquals(year, date.getYear());
        assertEquals(month, date.getMonthValue());
        assertEquals(day, date.getDayOfMonth());

    }
}