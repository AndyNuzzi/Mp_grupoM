package Client;

import javax.xml.namespace.QName;
import java.util.Locale;
import java.util.Scanner;

public class FighterBuilder extends StarshipBuilder {
    Fighter fighter = new Fighter();

    public FighterBuilder() {
        starship = fighter;

    }


    public Weapon weapon() {
        System.out.println(" Select a Weapon ");
        System.out.println(" 1 PEM ");
        System.out.println(" 2 Laser Beam ");
        System.out.println(" 3 Thermonuclear Missiles ");
        System.out.println(" 4 Plasma Cannons ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        int weaponOption = scanner.nextInt();
        System.out.println(" Introduce the power of the weapon ");
        int power = scanner.nextInt();
        Weapon weapon = null;
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
        }
        return weapon;
    }

    public void defense() {
        System.out.println(" Select a Defense ");
        System.out.println(" 1 Shield ");
        System.out.println(" 2 Armor ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        int defenseOption = scanner.nextInt();
        Defense defense = null;
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
                System.out.println(" Introduce the material ");
                String material = scanner.nextLine().toLowerCase();
                System.out.println(" Introduce the weight of your Defense ");
                int weight = scanner.nextInt();
                defense = new Armor(resistance, material, weight);
                break;
        }
        fighter.setDefense(defense);
    }

    public void propulsion() {
        double speed = 0;
        Propulsion prop = null;
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean moreCanBeAdded = false;
        boolean addMore =false;

        do {
            System.out.println(" Select Propulsion");
            System.out.println("1.FTL Engine");
            System.out.println("2.Solar Sails");
            System.out.println("3.Ion Engine");
            System.out.println("4.Trace Compressor");
            System.out.println("5.Warp Engine");
            option = sc.nextInt();
            do {
                if (option >= 1 && option <= 6) {
                    System.out.println("Select Speed");
                    speed = sc.nextDouble();

                    switch (option) {
                        case 1:
                            prop = new FTLEngine(speed);
                            break;
                        case 2:
                            prop = new SolarSails(speed);
                            break;
                        case 3:
                            prop = new IonEngine(speed);
                            break;
                        case 4:
                            prop = new TraceCompressor(speed);
                            break;
                        case 5:
                            prop = new WarpEngine(speed);
                            break;
                    }
                } else {
                    System.out.println(" Select a correct option1 ");
                }
            } while (!(option >= 1 && option < 6));
            moreCanBeAdded = fighter.addPropulsion(prop);
            System.out.println("Do you want to select other propulsion?y/n");
            addMore= sc.nextLine().toLowerCase().equals("n");
        } while (addMore && moreCanBeAdded);
    }

    @Override
    public Starship getResult(Client owner) {
        fighter.setRegisterNumber(super.registerNumber());
        fighter.setCrew(super.crew());
        fighter.setOwner(owner.getIdNumber());

        this.propulsion();

        this.defense();
        fighter.setWeapon1(this.weapon());
        fighter.setWeapon2(this.weapon());
        controller.createStarship((Starship) fighter);
        return   fighter;
    }


}
