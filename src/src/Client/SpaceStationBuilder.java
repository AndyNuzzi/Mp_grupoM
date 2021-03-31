package Client;

import java.util.Scanner;

public class SpaceStationBuilder extends StarshipBuilder {

    private SpaceStation spaceStation = new SpaceStation();

    public void passengers() {
        System.out.println(" Introduce the number of passengers ");
        Scanner scanner = new Scanner(System.in);
        this.spaceStation.setPassengers(scanner.nextInt());
    }

    public void defense() {

    }

    public void starship() {

        // llamada recursiva al get result de starship builder, pidiendole antes que naves quiere añadir


    }

    public void propulsion() {

        // falta propulsion

    }


    @Override
    public Starship getResult(Client owner) {
        spaceStation.setRegisterNumber(super.registerNumber());
        spaceStation.setCrew(super.crew());
        spaceStation.setOwner(owner);

        this.propulsion();

        this.passengers();
        this.starship();
        this.defense();

        return spaceStation;
    }

}
