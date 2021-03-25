package Client;

import java.util.Scanner;

public abstract class LogIn{

    // Mirar si sobra el atributo session
    private boolean session;

    public boolean getSession (){
        return this.session;
    }

    // el do operation se encargara de:
    // primero le pedira el usuario
    // en ambos casos tendra ese usuario, que sera el que:
    // muestre el menu de los view en el que se elegira la siguiente operacion
    public abstract void doOperation();

    // se encargara de ver si ese usuario ya esta registrado
    protected abstract Boolean validate (String email, String password);

    // segun lo que devuelva validate: si no esta lo creara, en ambos casos seguira
    // con su normal funcionamiento
    // ha de ser abstracto ya que segun te registres como cliente o administrador creara uno u otro usuario
    public abstract User createUser ();

    // Este metodo pedira el nombre
    protected String askForName (){
        System.out.println("");
        System.out.println(" Introduce your name ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Este metodo pedira el planeta
    protected String askForPlanet (){
        System.out.println("");
        System.out.println(" Introduce your planet ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Este metodo pedira la especie
    protected String askForSpecies (){
        System.out.println("");
        System.out.println(" Introduce your species ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Este metodo pedira aisgnará un id
    protected String assignId (){
        // falta como implementar esto
        // opciones:
        // hacer nosotros el hash code
        // usar el hash de java
        // llevar la cuenta del numero de usuarios y asignar siempre 1 mayor
        return null;
    }

    // Este metodo pedira el nick
    protected String askForNick (){
        System.out.println("");
        System.out.println(" Introduce your nick ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Este metodo pedira la contraseña
    protected String askForPassword (){
        System.out.println("");
        System.out.println(" Introduce your password ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Este metodo pedira el email
    protected String askForEmail (){
        System.out.println("");
        System.out.println(" Introduce your email ");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
