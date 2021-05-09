package Client;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SearchOfferTest {

    @Test
    public void doOperation(){

        Client client = new Client("client1", "earth", "species", "C0001",
                "clien", "Client1", "client@client.com");

        boolean askAgain = true;
        String type = "";
        String shipElection = "3";

        Offer offer = new Offer();
        offer.setId("OC0001");
        offer.setCreator("client1");
        offer.setPrice(20500);

        String typeT = "freighter";

        while (askAgain) {
            askAgain = false;

            switch (shipElection) {
                case "1":
                    type = "spacestation";
                    break;
                case "2":
                    type = "destroyer";
                    break;
                case "3":
                    type = "freighter";
                    break;
                case "4":
                    type = "fighter";
                    break;
                default:
                    askAgain = true;
            }
        }
        assertFalse(askAgain);
        assertEquals(typeT, type);

        List<Offer> offerList = new ArrayList<Offer>();

        if (offerList != null && offerList.size()>0) {
            boolean buying = false;
            boolean found = false;

            String continueBuying = "n";

            while (!buying) {
                buying =(continueBuying == "n");
                if (!buying) {
                    if (client.getPirate()){
                        offer = null;
                        Iterator<Offer> iterator = offerList.iterator();

                        while (iterator.hasNext() && !found) {
                            offer = iterator.next();
                            found = offer.getId().equals(offer.getId());
                        }
                        List<String> l = offer.getType();
                        if (found && l.size() == 1 && isOnlyFreighter(l)) {
                            buy(offer);
                        }
                    } else {
                        offer = null;
                        Iterator<Offer> iterator = offerList.iterator();
                        while (iterator.hasNext() && !found) {
                            offer = iterator.next();
                            found = offer.getId().equals(offer.getId());
                        }
                        if (found) {
                            buy(offer);
                        }
                    }
                }

            }
            assertTrue(buying);
            assertTrue(found);
        }
    }

    public boolean isOnlyFreighter(List<String> l) {
        for (String s: l){
            if (s != "Freighter")
                return false;
        }
        return true;
    }


    public void buy(Offer offer){
        Sale sale = new Sale();
        String idSale = "S0001";
        String buyer = "C0001";
        LocalDate date = LocalDate.now();

        sale.setId(idSale);
        sale.setBuyer(buyer);
        sale.setSeller(offer.getCreator());
        sale.setDate(date);
        sale.setCost(offer.getPrice());

        String addComment = "y";
        if (addComment.toLowerCase().equals("y")){
            Comment comment = new Comment();
            comment.setIdSale(sale.getId());
            comment.setIdSeller(offer.getCreator());
            comment.setIdClient(sale.getBuyer());
            String newComment = "Buena compra";
            comment.setComment(newComment);
            System.out.println("Introduce a valoration: 1-5");
            int i = 5;
            comment.setValoration(i);
        }
        assertEquals(idSale, sale.getId());
        assertEquals(buyer, sale.getBuyer());
        assertEquals(offer.getCreator(), sale.getSeller());
        assertEquals(date, sale.getDate());
        assertEquals(offer.getPrice(), sale.getCost());
    }

}