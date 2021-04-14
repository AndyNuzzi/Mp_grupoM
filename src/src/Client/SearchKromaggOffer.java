package Client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SearchKromaggOffer extends SearchOffer {

    public SearchKromaggOffer(Client client) {
        super(client);
    }

    private boolean isOnlyFreighter(List<String> l) {
        for (String s : l) {
            if (s != "Freighter")
                return false;
        }
        return true;
    }

    private void presentOffers(List<Offer> offerList) {
        System.out.println("--------------------  OFFERS  --------------------");
        for (Offer info : offerList) {
            System.out.println("--------------------------------------------------");
            List<String> l = info.getStarshipIdList();
            List<String> lcopy = clone(l);
            List<Starship> starships = controller.getStarship(lcopy);
            for (Starship s : starships) {
                System.out.println("Starship: " + s.getName());
                s.print();
                System.out.println("--------------------------------------------------");
            }
            System.out.println("Offer Id: " + info.getId());
            System.out.println("Date end: " + info.getDateEnd());
            System.out.println("Price: " + info.getPrice());
            System.out.println("Creator: " + info.getCreator());
            System.out.println("--------------------------------------------------");
        }
        /**
         * lista con las ofertas
         */
    }

    @Override
    /**
     * doOperation de la clase SearchOffer busca las ofertas según un tipo de nave y podrá comprar una oferta
     */
    public boolean doOperation() {
        Scanner scanner = new Scanner(System.in);
        boolean askAgain = true;
        String type = "";

        while (askAgain) {
            askAgain = false;
            System.out.println("Which starship do you want to see?");
            System.out.println("1. Space station");
            System.out.println("2. Destroyer");
            System.out.println("3. Freighter");
            System.out.println("4. Fighter");
            String shipElection = scanner.nextLine();

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

        List<Offer> offerList = controller.getOffer(type, client.getIdNumber());

        if (offerList != null && offerList.size() > 0) {
            boolean buying = false;
            presentOffers(offerList);

            while (!buying) {
                System.out.println("Do you want to buy any Offer? y/n");
                buying = scanner.nextLine().toLowerCase().equals("n");
                if (!buying) {
                    System.out.println("Introduce Offer id:");
                    String idOffer = scanner.nextLine();

                    if (client.getPirate()) {
                        System.out.println("You are considered a pirate. Contact an administrator.");
                        System.out.println("You can only buy freighter");
                        boolean found = false;
                        Offer offer = null;
                        Iterator<Offer> iterator = offerList.iterator();
                        while (iterator.hasNext() && !found) {
                            offer = iterator.next();
                            found = offer.getId().equals(idOffer);
                        }
                        List<String> l = offer.getType();
                        if (found && l.size() == 1 && isOnlyFreighter(l)) {
                            buy(offer);
                        }
                    } else {
                        boolean found = false;
                        Offer offer = null;
                        Iterator<Offer> iterator = offerList.iterator();
                        while (iterator.hasNext() && !found) {
                            offer = iterator.next();
                            found = offer.getId().equals(idOffer);
                        }
                        Kromagg k = (Kromagg) super.client;
                        if (found && k.requestLicense()) {
                            buy(offer);
                        } else {
                            System.out.println (" You have no license ");
                        }
                    }
                }

            }
        } else {
            System.out.println("There aren't offers available right now.");
        }
        return true;
    }

}
