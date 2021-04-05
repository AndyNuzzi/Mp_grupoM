package Client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SearchOffer extends ClientOperation{
    public SearchOffer (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {

        System.out.println("Which starship do you want to see?");
        Scanner scanner = new Scanner(System.in);
        String shipElection = scanner.nextLine();

        List<Offer> offerList = controller.getOffer(shipElection);

        for (int i = 0; i < offerList.size(); i++){
            Offer info = offerList.get(i);
            System.out.println(info);
        }

        boolean buying = false;

        while (! buying){
            System.out.println("Do you want to buy any Offer? y/n");
            String buyingConfirm = scanner.nextLine();
            if (buyingConfirm == "y") {
                System.out.println("Introduce Offer id:");
                String idOffer = scanner.nextLine();

                boolean found = false;
                Offer offer = null;
                Iterator<Offer> iterator = offerList.iterator();
                while (iterator.hasNext() && ! found){
                    offer = iterator.next();
                    found = offer.getId().equals(idOffer);
                }
                if (found) {
                    buy(offer);
                }
            }
            System.out.println("Do you want to continue buying? y/n");
            buying = scanner.nextLine().equals("n");
        }
        return buying;
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
