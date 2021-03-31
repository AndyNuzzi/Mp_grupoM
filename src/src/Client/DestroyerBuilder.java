package Client;

public class DestroyerBuilder extends StarshipBuilder{

    private Destroyer destroyer= new Destroyer();

    public void weapon(){

        // falta

    }

    public void defense(){

        // falta

    }

    public void propulsion(){

        // falta propulsion

    }

    @Override
    public Starship getResult(Client owner){
        destroyer.setRegisterNumber(super.registerNumber());
        destroyer.setCrew(super.crew());
        destroyer.setOwner(owner);

        this.propulsion();

        this.defense();
        this.weapon();

        return destroyer;
    }




}
