package Client;

import java.util.Scanner;

public class LoginManage {

    // he cambiado el doOperation, ahora devuelve boolean
    // solo salir desde el menu de login al salir

    private void showLoginMenu() {
        System.out.println("");
        System.out.println(" Welcome ");
        System.out.println("");
        System.out.println(" Select an option");
        System.out.println(" 1. Log in, for created accounts");
        System.out.println(" 2. Register as client, for first time users");
        System.out.println(" 3. Exit ");
        System.out.println("");
    }

    public void doOperation() {
        //Mostrará el menu y permitirá elegir entre registrarse o entrar con una cuenta ya creadaç
        int loginOption;
        Access access;
        // Para salir:
        // En el menu incial de login se sale si le da a salir
        // una vez dentro de pedir los datos, se sale si le da a salir
        // cuando se sale se debe iniciar de nuevo la ejecucion
        boolean exit = true;
        do {
            showLoginMenu();
            Scanner scanner = new Scanner(System.in);
            loginOption = scanner.nextInt();
            switch (loginOption) {
                case 1:
                    access = new LogIn();
                    exit = access.doOperation();
                    break;
                case 2:
                    access = new RegisterAsClient();
                    exit = access.doOperation();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("This isn't a valid option");
                    break;
            }
        }
        while (loginOption != 3 && exit == false);
        System.out.println(" See you soon ");

    }
}
