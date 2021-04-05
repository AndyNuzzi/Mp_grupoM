package Client;

import java.util.Locale;
import java.util.Scanner;

public class FreighterBuilder extends StarshipBuilder{

    Freighter freighter = new Freighter();

    public void capacity (){
        System.out.println(" Introduce the capacity of your freighter");
        Scanner scanner = new Scanner(System.in);
        freighter.setCapacity(scanner.nextInt());
    }

    public FreighterBuilder() {
        starship= freighter;

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
    public  void propulsion(){
        Propulsion prop = null;
        Scanner sc = new Scanner(System.in);
        int name=0;
        do {
            System.out.println(" Select Propulsion");
            System.out.println("1.FTL Engine");
            System.out.println("2.Solar Sails");
            System.out.println("3.Ion Engine");
            System.out.println("4.Trace Compressor");
            System.out.println("5.Warp Engine");
            System.out.println("6.Exit Propulsion");
            name = sc.nextInt();
            System.out.println("Select Speed");
            double speed = sc.nextDouble();
            switch (name) {
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
        }while (name!=6);

        freighter.addPropulsion(prop);
    }


    @Override
    public Starship getResult(Client owner) {
        freighter.setRegisterNumber(super.registerNumber());
        freighter.setCrew(super.crew());
        freighter.setOwner(owner);

        freighter.getPropulsion();

        this.capacity();
        this.defense();
        controller.createStarship((Starship) freighter);
        return freighter;
    }


}
