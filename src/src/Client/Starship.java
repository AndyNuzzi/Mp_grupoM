package Client;


import java.util.ArrayList;
import java.util.List;

public abstract class Starship {

    protected String registerNumber;
    protected Client owner;
    protected List<Propulsion> propulsion = new ArrayList<Propulsion>();
    protected int crew;


    protected String getRegisterNumber() {
        return this.registerNumber;
    }

    protected void setRegisterNumber(String registerNumber) {
        // se lo pedimos a la base de datos
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

    public void addPropulsion(Propulsion propulsion) {
        if (this.checkPropulsionNumber()){
            this.propulsion.add(propulsion);
        } else {
            System.out.println(" No more Propulsion can be added ");
        }
    }

    private boolean checkPropulsionNumber (){
        return this.propulsion.size() < 3;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

}



