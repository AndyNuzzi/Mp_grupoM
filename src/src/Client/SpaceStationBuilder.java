package Client;

import java.io.InputStream;
import java.util.Scanner;

public class SpaceStationBuilder extends StarshipBuilder {
    private SpaceStation spaceStation = new SpaceStation(getResult().getPassengers(), getResult().getStarships(),getResult().getDefenses());
    private Scanner sc= new Scanner(I);
   public void passengers(){
    //logica añadir pasajeros
    //pedir por pantalla
    //set

   }
   public void defense(){

   }
   public void addStarship(){

    }
    @Override
    public SpaceStation getResult(){
       return spaceStation;
    }

    public SpaceStationBuilder(){

        }

}
