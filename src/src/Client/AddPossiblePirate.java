package Client;

import java.util.List;
import java.util.Scanner;
import Controller.*;

public class AddPossiblePirate extends AdministratorOperation{

    public AddPossiblePirate(Administrator admin){
        super(admin);
    }
    @Override
    public boolean doOperation() {
        // pasar la lista de clientes
        // llamar al controlador pasandole el id del posible pirate que se quiere añadir

        List<Client> client = controller.getClientList();

        for (int i = 0; i < client.size(); i++) {
            Client idInfo = client.get(i);
            System.out.println(idInfo.getIdNumber());
        }// imprimo la lista con los clientes

        boolean delete = false;
        while (! delete){
            System.out.println("Do you want to add any Pirate? y/n");
            Scanner scanner = new Scanner(System.in);
            String addConfirm = scanner.nextLine();
            if (addConfirm == "y") {
                System.out.println("Introduce Pirate id:");
                String idPirate= scanner.nextLine();
                controller.addPossiblePirate(idPirate);
                // llamar al controlador pasandole el id del pirata que se quiere añadir
            }
            System.out.println("Do you want to continue adding? y/n");
            String deleteContinue = scanner.nextLine();
            if (deleteContinue == "n") {
                delete = true;
            } else{
                delete = false;
            }
        }
        return delete;
    }
}
