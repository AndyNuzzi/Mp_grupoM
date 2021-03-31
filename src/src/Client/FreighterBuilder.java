package Client;

import java.util.Scanner;

public class FreighterBuilder extends StarshipBuilder{

    Freighter freighter = new Freighter();

    public void capacity (){
        System.out.println(" Introduce the capacity of your freighter");
        Scanner scanner = new Scanner(System.in);
        freighter.setCapacity(scanner.nextInt());
    }

    public void defense (){
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
        freighter.setDefense(defense);
    }

    public void propulsion(){

        // falta propulsion

    }

    @Override
    public Starship getResult(Client owner) {
        freighter.setRegisterNumber(super.registerNumber());
        freighter.setCrew(super.crew());
        freighter.setOwner(owner);

        this.propulsion();

        this.capacity();
        this.defense();
        return freighter;
    }


}
