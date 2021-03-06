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
    protected void passengers() {
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
    public void defense() {
        Scanner scanner = new Scanner(System.in);
        boolean defenseCanBeAdded;
        String exit=null;
        do {
            Defense defense = null;
            do {
                this.showDefenses();
                int option = scanner.nextInt();
                int resistance = 0;
                if (option > 0 && option < 3) {
                    System.out.println(" Introduce the resistance ");
                    resistance = scanner.nextInt();
                }
                switch (option) {
                    case 1:
                        System.out.println(" Introduce the energy amount ");
                        double energyAmount = scanner.nextDouble();
                        defense = new Shield(resistance, energyAmount);
                        break;
                    case 2:
                        System.out.println(" Introduce the material ");
                        scanner = new Scanner(System.in);
                        String material = scanner.nextLine().toLowerCase();
                        System.out.println(" Introduce the weight ");
                        int weight = scanner.nextInt();
                        defense = new Armor(resistance, material, weight);
                        break;
                    default:
                        System.out.println("Wrong option");
                        break;
                }
            } while (defense == null);
            defenseCanBeAdded = spaceStation.addDefense(defense);
            if (defenseCanBeAdded) {
                System.out.println("Do you want to add other defense? y/n");
                Scanner sc= new Scanner(System.in);
                exit = sc.nextLine();
            }
        } while (exit.equals("y") && defenseCanBeAdded);
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
     * Pide al usuario si desea introducir m??s naves y las introduce
     *
     * @param owner
     */
    public void starship(Client owner) {
        Director director = new Director();
        Scanner scanner = new Scanner(System.in);
        Starship starship = null;
        int option;
        do {
            do {
                this.showStarship();
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        starship = director.makeDestroyer(owner);
                        break;
                    case 2:
                        starship = director.makeFighter(owner);
                        break;
                    case 3:
                        starship = director.makeFreighter(owner);
                        break;
                    case 4:
                        System.out.println(" Selected: no starships ");
                        break;
                    default:
                        System.out.println(" Wrong option ");
                        break;
                }
            } while (option < 1 && option > 4);
            if (option != 4) {
                spaceStation.addStarShip(starship);
            }
        } while (option != 4);
    }

    /**
     * Crea la nave y le env??a la nave al controller
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
