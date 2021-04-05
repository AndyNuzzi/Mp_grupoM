package Client;

import java.util.Scanner;

public class Subscribe extends ClientOperation{

    public Subscribe (Client client){
        super (client);
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
            System.out.println("*********** -1- space station ************");
            System.out.println("*********** -2- destroyer     ************");
            System.out.println("*********** -3- freighter     ************");
            System.out.println("*********** -4- fighter       ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "1": controller.addSubscription(typeOfShip);
                          break;
                case "2": controller.addSubscription(typeOfShip);
                          break;
                case "3": controller.addSubscription(typeOfShip);
                          break;
                case "4": controller.addSubscription(typeOfShip);
                          break;
            }
            System.out.println("Do you want to continue susbcribing? y/n");
            String addContinue = scanner.nextLine();
            if (addContinue == "n") {
                chooseShip = true;
            } else{
                chooseShip = false;
            }
        }
        return chooseShip;
    }
}
