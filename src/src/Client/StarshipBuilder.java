package Client;

import java.util.Scanner;
import Controller.*;

public abstract class StarshipBuilder {
    protected Starship starship;
    protected Controller controller = new Controller();


    protected String registerNumber() {
        Scanner sc = new Scanner(System.in);
        boolean validate = false;
        boolean format = false;
        int range = 8;
        String number = null;
        String pattern = "[A-Z]{1}[0-9]{4}[A-Z]{3}";

        while (!validate && !format) {
            System.out.println("Insert register Number");
            number = sc.next();

            if (range != number.length()) {
                System.out.println("Length doesn't match");
                format = false;

            } else if (number.matches(pattern)) {
                if (controller.validateRegisterNumber(number)) {
                    format = true;
                    validate = true;
                    System.out.println("Validating Number");
                }

            } else if (!number.matches(pattern)) {
                format = false;
                validate = false;
                System.out.println("Format Error");
            }


        }
        return number;
    }

    protected int crew() {
        System.out.println(" Introduce the crew ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void propulsion() {
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
        } while (name != 6);

        this.starship.addPropulsion(prop);
    }


    public abstract Starship getResult(Client owner);


}
