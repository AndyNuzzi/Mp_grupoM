package Client;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Starship {

    protected String registerNumber;
    protected Client owner;
    protected List<Propulsion> propulsion = new ArrayList<Propulsion>();
    protected int crew;


    protected String getRegisterNumber() {
        return this.registerNumber;
    }

    protected void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    protected boolean checkRegisterNumber(String registerNumber) {
        return this.registerNumber.equals(registerNumber);
    }

    protected void setOwner(Client owner) {
        this.owner = owner;
    }

    public Client getOwner() {
        return owner;
    }

    public List<Propulsion> getPropulsion() {
        return propulsion;
    }

    public boolean addPropulsion(Propulsion propulsion) {
        if (this.checkPropulsionNumber()) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Select Propulsion");
            System.out.println("FTL Engine");
            System.out.println("Solar Sails");
            System.out.println("Ion Engine");
            System.out.println("Trace Compressor");
            System.out.println("Warp Engine");
            String name = sc.nextLine().toLowerCase();
            switch (name) {
                case "ftl engine":
                    double power = sc.nextDouble();
                    propulsion = new FTLEngine(power);
                    break;

                case " solar sails":
                    power = sc.nextDouble();
                    propulsion = new SolarSails(power);
                    break;

                case "ion engine":
                    power = sc.nextDouble();
                    propulsion = new IonEngine(power);
                    break;
                case " trace compressor":
                    power = sc.nextDouble();
                    propulsion = new TraceCompressor(power);
                    break;
                case " warp engine":
                    power = sc.nextDouble();
                    propulsion = new WarpEngine(power);
                    break;

            }
            this.addPropulsion(propulsion);

            return true;
        } else {
            System.out.println("No more Propulsions can be added");
            return false;
        }

    }


        private boolean checkPropulsionNumber () {
            return this.propulsion.size() < 3;
        }

        public int getCrew () {
            return crew;
        }

        public void setCrew ( int crew){
            this.crew = crew;
        }

    }



