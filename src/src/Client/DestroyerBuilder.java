package Client;

import java.util.Scanner;

public class DestroyerBuilder extends StarshipBuilder {

    private Destroyer destroyer = new Destroyer();

    public DestroyerBuilder() {
        starship = destroyer;

    }

    /**
     * Muestra el menu de seleccion de weapons
     */
    private void showWeapons() {
        System.out.println(" Select a Weapon ");
        System.out.println(" 1 PEM ");
        System.out.println(" 2 Laser Beam ");
        System.out.println(" 3 Thermonuclear Missiles ");
        System.out.println(" 4 Plasma Cannons ");
        System.out.println("");
    }

    /**
     * Gestiona la seleccion del arma
     *
     * @return
     */
    public void weapon() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        do {
            Weapon weapon = null;
            do {
                this.showWeapons();
                int option = scanner.nextInt();
                int power = 0;
                if (option > 0 && option < 5) {
                    System.out.println(" Introduce the power ");
                    power = scanner.nextInt();
                }
                switch (option) {
                    case 1:
                        weapon = new PEM(power);
                    case 2:
                        weapon = new LaserBeam(power);
                    case 3:
                        weapon = new ThermonuclearMissiles(power);
                        break;
                    case 4:
                        weapon = new PlasmaCannons(power);
                        break;
                    default:
                        System.out.println("Wrong option");
                        break;
                }
            } while (weapon == null);
            System.out.println("Introduce 1 for exit, other number for not to");
            exit = scanner.nextInt() == 1;
        } while (!exit);
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
        boolean exit = false;
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
                        System.out.println(" Introduce the weight ");
                        int weight = scanner.nextInt();
                        System.out.println(" Introduce the material ");
                        scanner = new Scanner(System.in);
                        String material = scanner.nextLine().toLowerCase();
                        defense = new Armor(resistance, material, weight);
                        break;
                    default:
                        System.out.println("Wrong option");
                        break;
                }
            } while (defense == null);
            defenseCanBeAdded = destroyer.addDefense(defense);
            if (defenseCanBeAdded) {
                System.out.println("Introduce 1 for exit, other number for not to");
                exit = scanner.nextInt() == 1;
            }
        } while (!exit && defenseCanBeAdded);
    }

    /**
     * Crea la nave y le envía la nave al controller
     *
     * @param owner
     * @return
     */
    @Override
    public Starship getResult(Client owner) {
        destroyer.setRegisterNumber(super.registerNumber());
        destroyer.setCrew(super.crew());
        destroyer.setOwner(owner.getIdNumber());
        super.propulsion();
        this.defense();
        this.weapon();
        controller.createStarship((Starship) destroyer);
        return destroyer;
    }

}
