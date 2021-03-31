package Client;

import java.util.Scanner;

public class FighterBuilder extends StarshipBuilder {
    Fighter fighter = new Fighter();


    public Weapon weapon(){
        System.out.println(" Select a Weapon ");
        System.out.println(" 1 PEM ");
        System.out.println(" 2 Laser Beam ");
        System.out.println(" 1 Thermonuclear Missiles ");
        System.out.println(" 2 Plasma Cannons ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        int weaponOption = scanner.nextInt();
        System.out.println(" Introduce the power of the weapon ");
        int power = scanner.nextInt();
        Weapon weapon = null;
        switch (weaponOption){
            case 1:
                weapon = new PEM (power);
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

    public void defense(){
        System.out.println(" Select a Defense ");
        System.out.println(" 1 Shield ");
        System.out.println(" 2 Armor ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        int defenseOption = scanner.nextInt();
        Defense defense = null;
        switch (defenseOption){
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
                defense = new Armor (resistance, material, weight);
                break;
        }
        fighter.setDefense(defense);
    }


    public void propulsion(){

        // falta propulsion

    }

    @Override
    public Starship getResult(Client owner) {
        fighter.setRegisterNumber(super.registerNumber());
        fighter.setCrew(super.crew());
        fighter.setOwner(owner);

        this.propulsion();

        this.defense();
        fighter.setWeapon1(this.weapon());
        fighter.setWeapon2(this.weapon());
        return fighter;
    }


}
