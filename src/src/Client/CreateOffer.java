package Client;

import java.util.Scanner;
// eliminar los controllers de las clases

public class CreateOffer extends ClientOperation{
    public CreateOffer (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {
        // crea la oferta y se pide el tipo de nave que se quiere meter en la oferta

        Offer offer = new Offer();
        // creo el objeto tipo oferta
        Director director = new Director();
        // instanciar la clase director que es la que se encarga de introducir naves en las ofertas

        boolean addShip = false;
        while (! addShip) {
            System.out.println("Which starship do you want to include?");
            System.out.println("*********** space station ************");
            System.out.println("***********   destroyer   ************");
            System.out.println("***********   freighter   ************");
            System.out.println("***********    feighter   ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "space station": { director.makeSpaceStation(); }
                case "destroyer": { director.makeDestroyer(); }
                case "freighter": { director.makeFreighter(); }
                case "feighter": { director.makeFeighter(); }
            }
            System.out.println("Do you want to continue adding starships? y/n");
            String addContinue = scanner.nextLine();
            if (addContinue == "n") {
                addShip = false;
            } else{
                addShip = true;
            }
        }
        return addShip;
    }
}
