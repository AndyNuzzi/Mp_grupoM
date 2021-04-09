package Client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SearchOffer extends ClientOperation{
    public SearchOffer (Client client){
        super (client);
    }

    @Override
    // FALTA POR IMPLEMENTAR:
        // AL MOSTRAR LAS OFERTAS AL MENOS TIENEN QUE TENER UNA DE LAS NAVES DE LAS PEDIDAS
        // PEDIR LA FECHA

    public boolean doOperation() { // busca las ofertas según un tipo de nave y podrá comprar una oferta

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

        if (offerList != null) {
            presentOffers(offerList);

            boolean buying = false;

            while (!buying) {
                System.out.println("Do you want to buy any Offer? y/n");
                String buyingConfirm = scanner.nextLine();
                if (buyingConfirm.toLowerCase().equals("y")) {
                    System.out.println("Introduce Offer id:");
                    String idOffer = scanner.nextLine();

                    if (client.getPirate()){
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
                        if (found && l.size() == 1 && l.get(0).equals("Freighter")) {
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
                        if (found) {
                            buy(offer);
                        }
                    }
                }
                System.out.println("Do you want to continue buying? y/n");
                buying = scanner.nextLine().toLowerCase().equals("n");
            }
        } else{
            System.out.println("There aren't offers available right now.");
        }
        return true;
    }

    private void presentOffers(List<Offer> offerList) {
        System.out.println("--------------------  OFFERS  --------------------");
        for (Offer info: offerList){
            System.out.println("--------------------------------------------------");
            System.out.println(info.getId());
            System.out.println(info.getStarshipIdList());
            printStarships(controller.getStarship(info.getStarshipIdList()));
            System.out.println(info.getDateEnd());
            System.out.println(info.getPrice());
            System.out.println(info.getCreator());
            System.out.println("--------------------------------------------------");
        } // lista con las ofertas
    }

    private void printStarships(List<Starship> starship) {
        for (Starship s: starship){
            switch (s.getClass().getSimpleName()){
                case "SpaceStation": SpaceStation sp = (SpaceStation) s;
                    //sp.print();
                    break;
                case "Destroyer": Destroyer destroyer = (Destroyer) s;
                    //destroyer.print();
                    break;
                case "Freighter": Freighter freighter = (Freighter) s;
                    //freighter.print();
                    break;
                case "fighter": Fighter fighter = (Fighter) s;
                    //fighter.print();
                    break;
            }
        }
    }

    private boolean buy(Offer offer){
        Sale sale = new Sale();
        controller.deleteOffer(offer.getId());
        sale.setId(controller.getIdSale());
        sale.setBuyer(client.getIdNumber());
        sale.setCost(offer.getPrice());
        sale.setSeller(offer.getCreator());

        // logica de pedir la fecha

        controller.storeSale(sale.buy());
        return false;
    }
}
