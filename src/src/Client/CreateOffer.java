package Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Controller.*;

// eliminar los controllers de las clases

public class CreateOffer extends ClientOperation{
    public CreateOffer (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    // PEDIR EL PRECIO DE LA OFERTA!!!!!!!!

    public boolean doOperation() {
        // crea la oferta y se pide el tipo de nave que se quiere meter en la oferta

        Director director = new Director();
        // instanciar la clase director que es la que se encarga de introducir naves en las ofertas

        boolean addShip = false;
        List<Starship> starshipList = new ArrayList<>();

        while (! addShip) {
            System.out.println("Which starship do you want to include? 1-4");
            System.out.println("*********** -1- space station ************");
            System.out.println("*********** -2- destroyer     ************");
            System.out.println("*********** -3- freighter     ************");
            System.out.println("*********** -4- fighter       ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "1": starshipList.add(director.makeSpaceStation());
                          break;
                case "2": starshipList.add(director.makeDestroyer());
                          break;
                case "3": starshipList.add(director.makeFreighter());
                          break;
                case "4": starshipList.add(director.makeFeighter());
                          break;
            }

            System.out.println("Do you want to continue adding starships? y/n");
            String addContinue = scanner.nextLine();
            if (addContinue == "n") {
                addShip = true;
            } else{
                addShip = false;
            }
        }

        Offer offer = new Offer();
        // creo el objeto tipo oferta

        offer.addStarshipToOffer(starshipList);
        controller.addToUncheckedOffers(offer.finish());

        return addShip;
    }
}
