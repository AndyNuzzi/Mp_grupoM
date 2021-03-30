package Client;

public class Director {
    public Director(){

    }
    public Starship makeSpaceStation(){
      SpaceStationBuilder starshipBuilder= new SpaceStationBuilder();

        return starshipBuilder.getResult();
    }
    public Starship makeDestroyer(){
        StarshipBuilder starshipBuilder= new DestroyerBuilder();
        return starshipBuilder.getResult();
    }
    public Starship makeFrieghter(){
        StarshipBuilder starshipBuilder= new FreighterBuilder();
        return starshipBuilder.getResult();
    }
    public Starship makeFighter(){
        StarshipBuilder starshipBuilder= new FighterBuilder();
        return starshipBuilder.getResult();
    }



}
