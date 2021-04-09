package Client;

import java.util.Scanner;

public class CreateNewAdministrator extends AdministratorOperation{

    public CreateNewAdministrator(Administrator admin){
        super(admin);
    }

    @Override
    public boolean doOperation() {

        Administrator admin = new Administrator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------  NEW ADMINISTRATOR  ---------------");

        System.out.println("Your name is:");
        admin.setName(scanner.nextLine());
        System.out.println("You live in: (planet)");
        admin.setPlanet(scanner.nextLine().toLowerCase());
        System.out.println("You are: (specie)");
        admin.setSpecies(scanner.nextLine().toLowerCase());
        admin.setIdNumber(controller.getIdAdmin());
        System.out.println("Your nick is:");
        admin.setNick(scanner.nextLine());

        String password = "null";
        String confirmPassword = " ";

        while (!password.equals(confirmPassword)) {
            System.out.println("Your password is:");
            password = scanner.nextLine();
            System.out.println("Confirm your password: ");
            confirmPassword = scanner.nextLine();
        }
        admin.setPassword(password);
        System.out.println("Your email is:");
        admin.setEmail(scanner.nextLine());

        return controller.createNewAdministrator(admin);

    }
}
