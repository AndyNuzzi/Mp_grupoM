package Client;

import java.util.Scanner;

public class SpaceStationBuilder extends StarshipBuilder {

    private SpaceStation spaceStation = new SpaceStation();


    public SpaceStationBuilder() {
        starship= spaceStation;

    }

    public void passengers() {
        System.out.println(" Introduce the number of passengers ");
        Scanner scanner = new Scanner(System.in);
        this.spaceStation.setPassengers(scanner.nextInt());
    }

    public void defense() {

    }

    public void starship() {




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

        this.spaceStation.addPropulsion(prop);
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
