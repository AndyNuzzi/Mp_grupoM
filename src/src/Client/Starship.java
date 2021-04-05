package Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public abstract class Starship implements Serializable{

    protected String registerNumber;
    protected String owner;
    protected List<Propulsion> propulsion = new ArrayList<Propulsion>();
    protected int crew;

    public String getRegisterNumber() {
        return this.registerNumber;
    }

    protected void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    protected boolean checkRegisterNumber(String registerNumber) {
        return this.registerNumber.equals(registerNumber);
    }

    protected void setOwner(String ownerId) {
        this.owner = ownerId;
    }

    public String getOwner() {
        return owner;
    }

    public List<Propulsion> getPropulsion() {
        return propulsion;
    }

    public boolean addPropulsion(Propulsion propulsion) {
        if (this.checkPropulsionNumber()){
            this.propulsion.add(propulsion);
            return true;
        } else {
            System.out.println(" No more Propulsion can be added ");
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
