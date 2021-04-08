package Client;

import java.util.Scanner;


public class CreateOffer extends ClientOperation {
    public CreateOffer(Client client) {
        super(client);
    }

    @Override
    // FALTA POR IMPLEMENTAR:
            // - FECHA LIMITE DE VIGENCIA DE LA OFERTA
            // - PRECIO DE LA OFERTA

    public boolean doOperation() { //crea la oferta y se pide el tipo de nave que se quiere meter en la oferta

        Offer offer = new Offer();
        // instanciar la oferta

        Director director = new Director();
        // instanciar al director

        boolean addShip = false;
        Starship starship = null;

        System.out.println("--------------------  CREATE NEW OFFER  --------------------");

        while (!addShip) {
            System.out.println("Which starship do you want to include? (1-4)");
            System.out.println("*********** -1- space station ************");
            System.out.println("*********** -2- destroyer     ************");
            System.out.println("*********** -3- freighter     ************");
            System.out.println("*********** -4- fighter       ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "1":
                    starship = (director.makeSpaceStation(super.client));
                    offer.setType(0);
                    break;
                case "2":
                    starship = (director.makeDestroyer(super.client));
                    offer.setType(1);
                    break;
                case "3":
                    starship = (director.makeFreighter(super.client));
                    offer.setType(2);
                    break;
                case "4":
                    starship = (director.makeFighter(super.client));
                    offer.setType(3);
                    break;
            }

            offer.addStarshipToOffer(starship);
            System.out.println("Do you want to continue adding starships? y/n");
            addShip = scanner.nextLine().toLowerCase().equals("n");
            offer.setCreator(client.getIdNumber());
            controller.addToUncheckedOffers(offer.finish());

        }
        return true;
    }
}

