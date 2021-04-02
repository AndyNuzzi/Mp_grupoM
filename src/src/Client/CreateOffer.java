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
        List<Starship> starshipList = new ArrayList<Starship>();

        while (! addShip) {
            System.out.println("Which starship do you want to include?");
            System.out.println("*********** space station ************");
            System.out.println("***********   destroyer   ************");
            System.out.println("***********   freighter   ************");
            System.out.println("***********    feighter   ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "space station": starshipList.add(director.makeSpaceStation());
                                      break;
                case "destroyer":     starshipList.add(director.makeDestroyer());
                                      break;
                case "freighter":     starshipList.add(director.makeFreighter());
                                      break;
                case "feighter":      starshipList.add(director.makeFeighter());
                                      break;
            }

            System.out.println("Do you want to continue adding starships? y/n");
            String addContinue = scanner.nextLine();
            if (addContinue == "n") {
                addShip = false;
            } else{
                addShip = true;
            }
        }

        Offer offer = new Offer();
        // creo el objeto tipo oferta

        offer.addStarshipToOffer(starshipList);
        controller.addToUncheckedOffers(offer.finish());

        return addShip;
    }
}
