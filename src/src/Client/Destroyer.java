package Client;

public class Destroyer extends Starship{
    private Weapon[] weapon= new Weapon[1];
    private Defense[] defenses = new Defense[2];


    public Destroyer(Weapon[] weapon, Defense[] defenses){

    }
    public void addWeapon(){
    //añadir logicca de addWeapon
    }
    public void adddDefense(){
    //añadir logica de addDefense
    }
    public boolean checkDefenseNumber(){
        return this.defenses==defenses;
    }

    public Weapon[] getWeapon() {
        return weapon;
    }

    public Defense[] getDefenses() {
        return defenses;
    }
}
