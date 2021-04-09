package Client;

import java.util.List;
import java.util.Scanner;

public class AddPossiblePirate extends AdministratorOperation{

    public AddPossiblePirate(Administrator admin){
        super(admin);
    }

    @Override
    public boolean doOperation() { // añade un cliente a la lista de piratas

        List<Client> client = controller.getClientList();

        if (client!=null){
            System.out.println("--------------------  CLIENTS  --------------------");
            for (Client clientInfo: client) {
                System.out.println("--------------------------------------------------");
                System.out.println("Id: " + clientInfo.getIdNumber());
                System.out.println("--------------------------------------------------");
            }// lista con los clientes

            boolean add = false;
            while (! add){
                System.out.println("Do you want to add any Pirate? y/n");
                Scanner scanner = new Scanner(System.in);
                String addConfirm = scanner.nextLine();
                if (addConfirm.toLowerCase().equals("y")) {
                    System.out.println("Introduce Pirate id:");
                    String idPirate= scanner.nextLine();
                    controller.addPossiblePirate(idPirate);
                    // llamar al controlador pasandole el id del pirata que se quiere añadir
                }
                System.out.println("Do you want to continue adding? y/n");
                add = scanner.nextLine().toLowerCase().equals("n");
            }
        } else {
            System.out.println("There aren't clients available");
        }
        return true;
    }
}
