package Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.*;

// eliminar los controllers de las clases

public class CreateOffer extends ClientOperation {
    public CreateOffer(Client client) {
        super(client);
        // me traigo los datos del cliente
    }

    @Override
    // PEDIR EL PRECIO DE LA OFERTA!!!!!!!!

    public boolean doOperation() {
        // crea la oferta y se pide el tipo de nave que se quiere meter en la oferta

        // creo el objeto tipo oferta

        Offer offer = new Offer();

        Director director = new Director();
        // instanciar la clase director que es la que se encarga de introducir naves en las ofertas

        boolean addShip = false;
        Starship starship = null;

        while (!addShip) {
            System.out.println("Which starship do you want to include? 1-4");
            System.out.println("*********** -1- space station ************");
            System.out.println("*********** -2- destroyer     ************");
            System.out.println("*********** -3- freighter     ************");
            System.out.println("*********** -4- fighter       ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "1":
                    starship = (director.makeSpaceStation(super.client));
                    break;
                case "2":
                    starship = (director.makeDestroyer(super.client));
                    break;
                case "3":
                    starship = (director.makeFreighter(super.client));
                    break;
                case "4":
                    starship = (director.makeFighter(super.client));
                    break;
            }

            offer.addStarshipToOffer(starship);
            System.out.println("Do you want to continue adding starships? y/n");
            addShip = scanner.nextLine().toLowerCase().equals("n");
            controller.addToUncheckedOffers(offer.finish());


        }
        return true;
    }
}

