package Client;

import java.util.Scanner;

public class SpaceStationBuilder extends StarshipBuilder {

    private SpaceStation spaceStation = new SpaceStation();


    public SpaceStationBuilder() {
        starship = spaceStation;
    }

    public void passengers() {
        System.out.println(" Introduce the number of passengers ");
        Scanner scanner = new Scanner(System.in);
        this.spaceStation.setPassengers(scanner.nextInt());
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
        spaceStation.addDefense(defense);
    }


    public void starship(Client owner) {
        Scanner sc = new Scanner(System.in);
        Starship starship = null;
        int selection;


        do {
            System.out.println("Select a Starship");
            System.out.println("1.Destroyer");
            System.out.println("2.Fighter");
            System.out.println("3.Freighter");
            System.out.println("4.Exit");
            selection = sc.nextInt();

            Director director = new Director();


            switch (selection) {
                case 1:
                    System.out.println("Introducing Destroyer");
                    spaceStation.addStarShip(director.makeDestroyer(owner));

                case 2:
                    System.out.println("Introducing Fighter");
                    spaceStation.addStarShip(director.makeFighter(owner));

                case 3:
                    System.out.println("Introducing Freighter");
                    spaceStation.addStarShip(director.makeFreighter(owner));
            }


        } while (selection != 4);
    }


    public void propulsion() {
        double speed=0;
        Propulsion prop = null;
        Scanner sc = new Scanner(System.in);
        int name = 0;
        do {
            System.out.println(" Select Propulsion");
            System.out.println("1.FTL Engine");
            System.out.println("2.Solar Sails");
            System.out.println("3.Ion Engine");
            System.out.println("4.Trace Compressor");
            System.out.println("5.Warp Engine");
            System.out.println("6.Exit Propulsion");
            name = sc.nextInt();
            if (name != 6) {
                System.out.println("Select Speed");

                speed = sc.nextDouble();
            }
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
        } while (name != 6);

        this.spaceStation.addPropulsion(prop);
    }


    @Override
    public Starship getResult(Client owner) {
        spaceStation.setRegisterNumber(super.registerNumber());
        spaceStation.setCrew(super.crew());
        spaceStation.setOwner(owner.getIdNumber());

        this.propulsion();

        this.passengers();
        this.starship(owner);
        this.defense();
        controller.createStarship((Starship) spaceStation);
        return spaceStation;
    }

}
