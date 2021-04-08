package Client;

import java.util.Scanner;

public class Subscribe extends ClientOperation{

    public Subscribe (Client client){
        super (client);
    }

    @Override
    // FALTA POR IMPLEMENTAR:
        // - PODER DARSE DE BAJA EN LAS SUBSCRIPCIONES
        // - AL SUSBCRIBIRSE LANZAR LAS NOTIFICACIONES

    public boolean doOperation() { // subscripcion a un tipo de nave

        boolean chooseShip = false;

        while (! chooseShip) {
            System.out.println("Which starship do you want to subscribe? (1-4)");
            System.out.println("*********** -1- space station ************");
            System.out.println("*********** -2- destroyer     ************");
            System.out.println("*********** -3- freighter     ************");
            System.out.println("*********** -4- fighter       ************");

            Scanner scanner = new Scanner(System.in);
            String typeOfShip = scanner.nextLine();

            switch (typeOfShip) {
                case "1": controller.addSubscription(client.getIdNumber(), "SpaceStation");
                          break;
                case "2": controller.addSubscription(client.getIdNumber(), "Destroyer");
                          break;
                case "3": controller.addSubscription(client.getIdNumber(), "Freighter");
                          break;
                case "4": controller.addSubscription(client.getIdNumber(), "Fighter");
                          break;
            }

            System.out.println("Do you want to continue susbcribing? y/n");
            chooseShip = scanner.nextLine().toLowerCase().equals("n");

        }
        return chooseShip;
    }
}
