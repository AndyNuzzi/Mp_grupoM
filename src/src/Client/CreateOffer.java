package Client;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;


public class CreateOffer extends ClientOperation implements Serializable {

    public CreateOffer(Client client) {
        super(client);
    }

    @Override
    public boolean doOperation() {
        /**
         * doOperation de la clase CreateOffer crea la oferta y se pide el tipo de nave
         * que se quiere meter en la oferta
         */
        Scanner scanner = new Scanner(System.in);
        Offer offer = new Offer();
        Director director = new Director();

        boolean addShip = false;
        Starship starship = null;

        System.out.println("--------------------  CREATE NEW OFFER  --------------------");

        while (!addShip) {
            System.out.println("Which starship do you want to include? (1-4)");
            System.out.println("*********** -1- space station ************");
            System.out.println("*********** -2- destroyer     ************");
            System.out.println("*********** -3- freighter     ************");
            System.out.println("*********** -4- fighter       ************");

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
        }
        offer.setDateEnd(askDate());
        offer.setCreator(client.getIdNumber());
        System.out.println("Price (in EUROS): ");
        offer.setPrice(scanner.nextLong());
        controller.addToUncheckedOffers(offer.finish());
        return true;
    }

    private LocalDate askDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce end year:");
        int year = scanner.nextInt();
        System.out.println("Introduce end month:");
        int month = scanner.nextInt();
        System.out.println("Introduce end day:");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println("End date: " + date.toString());
        return date;
    }
}

