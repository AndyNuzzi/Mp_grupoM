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

        System.out.println("Which starship do you want to see?");
        Scanner scanner = new Scanner(System.in);
        String shipElection = scanner.nextLine();

        List<Offer> offerList = controller.getOffer(shipElection);

        System.out.println("--------------------  OFFERS  --------------------");
        for (Offer info: offerList){
            System.out.println("--------------------------------------------------");
            System.out.println(info.getId());
            System.out.println(info.getStarshipIdList());
            System.out.println(info.getDateEnd());
            System.out.println(info.getPrice());
            System.out.println(info.getCreator());
            System.out.println("--------------------------------------------------");
        } // lista con las ofertas

        boolean buying = false;

        while (! buying){
            System.out.println("Do you want to buy any Offer? y/n");
            String buyingConfirm = scanner.nextLine();
            if (buyingConfirm.toLowerCase().equals("y")) {
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
            buying = scanner.nextLine().toLowerCase().equals("n");
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
