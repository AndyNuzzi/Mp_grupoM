package Client;

import java.util.Scanner;

public class Subscribe extends ClientOperation{
    public Subscribe (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    // 1-4
    // poner los break

    // HAY QUE REVISARLO
    public boolean doOperation() {
        // se encarga de pedir los tipos de naves que van a estar en la oferta

        boolean chooseShip = false;

        while (! chooseShip) {
            System.out.println("Which starship do you want to subscribe? 1-4");
            System.out.println("*********** space station ************");
            System.out.println("***********   destroyer   ************");
            System.out.println("***********   freighter   ************");
            System.out.println("***********    fighter   ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "space station": { controller.addSubscription(typeOfShip); }
                case "destroyer": { controller.addSubscription(typeOfShip); }
                case "freighter": { controller.addSubscription(typeOfShip); }
                case "fighter": { controller.addSubscription(typeOfShip); }
            }
            System.out.println("Do you want to continue susbcribing? y/n");
            String addContinue = scanner.nextLine();
            if (addContinue == "n") {
                chooseShip = false;
            } else{
                chooseShip = true;
            }
        }
        return chooseShip;
    }
}
