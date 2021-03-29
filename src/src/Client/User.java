package Client;

import java.io.Serializable;

public abstract class User implements Serializable {

    protected String name;
    protected String planet;
    protected String species;
    protected String idNumber;
    protected String nick;
    protected String password;
    protected String email;

    // mirar comparator
    // ya hecha serializable

    public User (String name, String planet, String species, String idNumber, String nick, String password, String email){
        this.name = name;
        this.planet = planet;
        this.species = species;
        this.idNumber = idNumber;
        this.nick = nick;
        this.password = password;
        this.email = email;
    }

    // OPCION 1:

    // CLASE PADRE OPERATION

    // TODAS LAS OPERACIONES DERIVAN DE AHI

    // ASI EL PEDIR OPERACION SERIA IGUAL EN TODAS

    public abstract void setOption ();

    public abstract void doOperation();

    // crear clase operation


}


