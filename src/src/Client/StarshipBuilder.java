package Client;

import java.util.Scanner;

import Controller.*;

public abstract class StarshipBuilder {
    protected Starship starship;
    protected Controller controller = new Controller();

    /**
     * Gestiona el pedir el register number y comprobar que es correcto
     *
     * @return
     */
    protected String registerNumber() {
        Scanner scanner = new Scanner(System.in);
        String registerNumber = null;
        String pattern = "[A-Z]{1}[0-9]{4}[A-Z]{3}";
        do {
            System.out.println(" Introduce the register number of your starship ");
            registerNumber = scanner.nextLine();
            if (registerNumber.matches(pattern) || registerNumber.length() != 8) {
                System.out.println(" Format does not match ");
                registerNumber = null;
            } else if (!controller.validateRegisterNumber(registerNumber)) {
                System.out.println(" Wrong register number ");
                registerNumber = null;
            } else {
                System.out.println(" Register number accepted ");
            }
        } while (registerNumber == null);
        return registerNumber;
    }

    protected int crew() {
        System.out.println(" Introduce the crew ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Muestra el menú para elegir una propulsion
     */
    private void showPropulsion() {
        System.out.println(" Select a propulsion");
        System.out.println("1.FTL Engine");
        System.out.println("2.Solar Sails");
        System.out.println("3.Ion Engine");
        System.out.println("4.Trace Compressor");
        System.out.println("5.Warp Engine");
    }

    /**
     * Gestiona el pedir la propulsion y el comprobar que es correcto
     */
    public void propulsion() {
        Scanner scanner = new Scanner(System.in);
        boolean propulsionCanBeAdded;
        boolean exit = false;
        do {
            Propulsion propulsion = null;
            do {
                this.showPropulsion();
                int option = scanner.nextInt();
                double speed = 0;
                if (option > 0 && option < 6){
                    System.out.println(" Introduce the speed ");
                    speed = scanner.nextDouble();
                }
                switch (option){
                    case 1:
                        propulsion = new FTLEngine(speed);
                        break;
                    case 2:
                        propulsion = new SolarSails(speed);
                        break;
                    case 3:
                        propulsion = new IonEngine(speed);
                        break;
                    case 4:
                        propulsion = new TraceCompressor(speed);
                        break;
                    case 5:
                        propulsion = new WarpEngine(speed);
                        break;
                    default:
                        System.out.println(" Wrong option ");
                        break;
                }
            } while (propulsion == null);
            propulsionCanBeAdded = starship.addPropulsion(propulsion);
            if (propulsionCanBeAdded) {
                System.out.println(" Introduce y for exit, otherwise press any button");
                exit = scanner.nextLine().toLowerCase().equals("y");
            }
        } while (!exit  && propulsionCanBeAdded);
    }

    public abstract Starship getResult(Client owner);

}
