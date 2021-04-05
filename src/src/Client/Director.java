package Client;

public class Director {

    public Starship makeSpaceStation(Client owner) {
        SpaceStationBuilder starshipBuilder = new SpaceStationBuilder();
        return starshipBuilder.getResult(owner);
    }

    public Starship makeDestroyer(Client owner) {
        StarshipBuilder starshipBuilder = new DestroyerBuilder();
        return starshipBuilder.getResult(owner);
    }

    public Starship makeFrieghter(Client owner) {
        StarshipBuilder starshipBuilder = new FreighterBuilder();
        return starshipBuilder.getResult(owner);
    }

    public Starship makeFighter(Client owner) {
        StarshipBuilder starshipBuilder = new FighterBuilder();
        return starshipBuilder.getResult(owner);
    }
}
