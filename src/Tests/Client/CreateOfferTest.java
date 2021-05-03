package Client;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        int year = 2010;
        int month = 01;
        int day = 10;

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

        LocalDate date = LocalDate.of(year, month, day);
        offer.setDateEnd(date);

        offer.setCreator(client.getIdNumber());
        //    offer.setPrice(price);
        // añadir a unchecked offers
        // offer.addStarshipToOffer(starship);

        assertEquals(starship, starshipT);
        // assertEquals(offer.getType(), starship);
        assertEquals(starship, starshipT);

        assertEquals(offer.getCreator(), client.getIdNumber());
        assertTrue(addShip);

       // assertEquals(offer.getDateEnd(), date.toString());

    }

    private void assertTrue(boolean addShip) {
    }
}