package Client;

import java.util.Scanner;

public class SpaceStationBuilder extends StarshipBuilder {

    private SpaceStation spaceStation = new SpaceStation();


    public SpaceStationBuilder() {
        starship = spaceStation;
    }

    /**
     * Pide u guarda el numero de pasajeros
     */
    public void passengers() {
        System.out.println(" Introduce the number of passengers ");
        Scanner scanner = new Scanner(System.in);
        this.spaceStation.setPassengers(scanner.nextInt());
    }

    /**
     * Muestra el menu de seleccion de defensas
     */
    private void showDefenses() {
        System.out.println(" Select a Defense ");
        System.out.println(" 1 Shield ");
        System.out.println(" 2 Armor ");
        System.out.println("");
    }

    /**
     * Pide al usuario si desea introducir defensas y las introduce
     */

    // FALTA

    public void defense() {

    }

    /**
     * Muestra la seleccion de naves
     */
    private void showStarship() {
        System.out.println("Select a Starship");
        System.out.println("1. Destroyer");
        System.out.println("2. Fighter");
        System.out.println("3. Freighter");
        System.out.println("4. Exit");
    }

    /**
     * Pide al usuario si desea introducir más naves y las introduce
     *
     * @param owner
     */
    public void starship(Client owner) {
        Scanner sc = new Scanner(System.in);
        Starship starship = null;
        int selection;
        do {
            this.showStarship();
            selection = sc.nextInt();
            Director director = new Director();
            switch (selection) {
                case 1:
                    System.out.println("Introducing Destroyer");
                    spaceStation.addStarShip(director.makeDestroyer(owner));
                    break;
                case 2:
                    System.out.println("Introducing Fighter");
                    spaceStation.addStarShip(director.makeFighter(owner));
                    break;
                case 3:
                    System.out.println("Introducing Freighter");
                    spaceStation.addStarShip(director.makeFreighter(owner));
                    break;
                case 4:
                    System.out.println(" starships created ");
                    break;
                default:
                    System.out.println(" Wrong option ");
                    break;
            }
        } while (selection != 4);
    }

    /**
     * Crea la nave y le envía la nave al controller
     *
     * @param owner
     * @return
     */
    @Override
    public Starship getResult(Client owner) {
        spaceStation.setRegisterNumber(super.registerNumber());
        spaceStation.setCrew(super.crew());
        spaceStation.setOwner(owner.getIdNumber());
        super.propulsion();
        this.passengers();
        this.starship(owner);
        this.defense();
        controller.createStarship((Starship) spaceStation);
        return spaceStation;
    }

}
