package Client;

public abstract class Starship {

    protected String registerNumber;
    protected Client owner;
    protected Propulsion[] propulsion = new Propulsion [2];
    protected int crew;


    protected String getRegisterNumber(){
        return this.registerNumber;
    }

    protected void setRegisterNumber(String registerNumber){
        this.registerNumber = registerNumber;
    }


    // Falta seguir con esta clase


}
