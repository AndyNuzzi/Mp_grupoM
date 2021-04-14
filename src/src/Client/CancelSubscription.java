package Client;

import java.util.Scanner;

public class CancelSubscription extends ClientOperation{

    public CancelSubscription(Client client){
        super (client);
    }

    @Override
    public boolean doOperation() {
        /**
         * doOperation de la clase CancelSubscribe se desubscribe de un tipo de nave
         */

        boolean chooseShip = false;

        while (! chooseShip) {
            System.out.println("Which starship do you want to unsubscribe? (1-4)");
            System.out.println("*********** -1- space station ************");
            System.out.println("*********** -2- destroyer     ************");
            System.out.println("*********** -3- freighter     ************");
            System.out.println("*********** -4- fighter       ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "1": controller.deleteSubscription(client.getIdNumber(), "SpaceStation");
                    break;
                case "2": controller.deleteSubscription(client.getIdNumber(), "Destroyer");
                    break;
                case "3": controller.deleteSubscription(client.getIdNumber(), "Freighter");
                    break;
                case "4": controller.deleteSubscription(client.getIdNumber(), "Fighter");
                    break;
            }

            System.out.println("Do you want to continue unsusbcribing? y/n");
            chooseShip = scanner.nextLine().toLowerCase().equals("n");

        }
        return chooseShip;
    }
}
