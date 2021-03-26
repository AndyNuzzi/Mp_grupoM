package Client;

import java.io.IOException;
import java.util.Scanner;

public class LoginManage {

    private void showLoginMenu() {
        System.out.println("");
        System.out.println(" Welcome ");
        System.out.println("");
        System.out.println(" Select an option");
        System.out.println(" 1. Log in");
        System.out.println(" 2. Register as client");
        System.out.println("");
    }

    public void doOperation() {
        //Mostrará el menu y permitirá elegir entre registrarse o entrar con una cuenta ya creada
        showLoginMenu();
        Scanner scanner = new Scanner(System.in);
        int loginOption = scanner.nextInt();
        switch (loginOption) {
            /*case 1: LogIn logIn = new LogIn();
                break;*/
            case 2: RegisterAsClient signIn = new RegisterAsClient();
                break;
            default:
                System.out.println("This isn't a valid option");
                //Añadir bucle para volver a pedir opcion?
                break;
        }
        /*
        He cambiado esto por lo de arriba

        if (loginOption == 1) {
            LogIn login = new RegisterAsAdministrator();
            login.doOperation();
        } else if (loginOption == 2) {
            LogIn login = new RegisterAsClient();
            login.doOperation();
        } else {
            System.out.println(" See you soon ");
            System.out.println("");
        }
        */


    }
}
