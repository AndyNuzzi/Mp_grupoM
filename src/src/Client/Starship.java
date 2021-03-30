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

    protected boolean checkRegisterNumber(String registerNumber){
            return this.registerNumber.equals(registerNumber);


    }
    protected void setOwner(Client owner){
        this.owner=owner;

            }

    public Client getOwner() {
        return owner;
    }

    public Propulsion[] getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion[] propulsion) {
        this.propulsion = propulsion;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }
}



