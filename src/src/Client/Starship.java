package Client;

import java.io.Serializable;

public abstract class Starship implements Serializable {

    protected String registerNumber;
    protected String owner;
    protected Propulsion[] propulsion = new Propulsion [2];
    protected int crew;


    public String getRegisterNumber(){
        return this.registerNumber;
    }

    protected void setRegisterNumber(String registerNumber){
        this.registerNumber = registerNumber;
    }

    public Starship(String registerNumber, String owner, Propulsion[] propulsion, int crew) {
        this.registerNumber = registerNumber;
        this.owner = owner;
        this.propulsion = propulsion;
        this.crew = crew;
    }
// Falta seguir con esta clase


}
