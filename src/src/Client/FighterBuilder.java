package Client;

import java.util.Scanner;

public class FighterBuilder extends StarshipBuilder {

    Fighter fighter = new Fighter();

    public FighterBuilder() {
        starship = fighter;
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
    public Weapon weapon() {
        Scanner scanner = new Scanner(System.in);
        Weapon weapon = null;
        do {
            this.showWeapons();
            int weaponOption = scanner.nextInt();
            int power = 0;
            if (weaponOption > 0 && weaponOption < 5) {
                System.out.println(" Introduce the power of the weapon ");
                power = scanner.nextInt();
            }
            switch (weaponOption) {
                case 1:
                    weapon = new PEM(power);
                    break;
                case 2:
                    weapon = new LaserBeam(power);
                    break;
                case 3:
                    weapon = new ThermonuclearMissiles(power);
                    break;
                case 4:
                    weapon = new PlasmaCannons(power);
                    break;
                default:
                    System.out.println(" Wrong option ");
                    weapon = null;
                    break;
            }
        } while (weapon == null);
        return weapon;
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
     * Gestiona la seleccion de las defensas
     *
     * @return
     */
    public void defense() {
        Scanner scanner = new Scanner(System.in);
        Defense defense = null;
        do {
            this.showDefenses();
            int defenseOption = scanner.nextInt();
            switch (defenseOption) {
                case 1:
                    System.out.println(" Introduce the resistance of your Defense ");
                    int resistance = scanner.nextInt();
                    System.out.println(" Introduce the enegy amount of your Defense ");
                    double energyAmount = scanner.nextDouble();
                    defense = new Shield(resistance, energyAmount);
                    break;
                case 2:
                    System.out.println(" Introduce the resistance of your Defense ");
                    resistance = scanner.nextInt();
                    scanner = new Scanner(System.in);
                    System.out.println(" Introduce the material ");
                    String material = scanner.nextLine().toLowerCase();
                    System.out.println(" Introduce the weight of your Defense ");
                    int weight = scanner.nextInt();
                    defense = new Armor(resistance, material, weight);
                    break;
                default:
                    System.out.println(" Wrong option ");
                    defense = null;
                    break;
            }
        } while (defense == null);
        fighter.setDefense(defense);
    }

    /**
     * Pide la crew
     * @return
     */
    @Override
    protected int crew() {
        return 1;
    }

    /**
     * Crea la nave y le env??a la nave al controller
     *
     * @param owner
     * @return
     */
    @Override
    public Starship getResult(Client owner) {
        fighter.setRegisterNumber(super.registerNumber());
        fighter.setOwner(owner.getIdNumber());
        fighter.setCrew(this.crew());
        super.propulsion();
        this.defense();
        fighter.setWeapon1(this.weapon());
        fighter.setWeapon2(this.weapon());
        controller.createStarship((Starship) fighter);
        return fighter;
    }

}
