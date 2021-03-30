package Client;

public class FreighterBuilder extends StarshipBuilder{
    private Feighter freighter = new Feighter(getResult().getCapacity(), getResult().getDefense());

    public FreighterBuilder(){

    }
    public void addWeapon(){
    }
    public void defense(){
    }
    public Feighter getResult() {
            return freighter;
    }


}
