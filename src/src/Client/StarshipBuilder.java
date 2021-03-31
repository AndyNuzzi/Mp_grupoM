package Client;

import java.util.Scanner;

public abstract class StarshipBuilder {


    protected String registerNumber(){
        // le pedimos el registerNumber a la base de datos
        return null;
    }

    protected int crew(){
        System.out.println(" Introduce the crew ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public abstract Starship getResult (Client owner);


}
