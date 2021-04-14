package Client;

import java.util.List;
import java.util.Scanner;

public class AddPossibleSwindler extends AdministratorOperation{

    public AddPossibleSwindler(Administrator admin){
        super(admin);
    }

    @Override
    /**
     * doOperation de la clase AddPossibleSwindler añade un cliente a la lista de timadores
     */
    public boolean doOperation() {

        List<Client> client = controller.getClientList();

        if (client!=null) {
            System.out.println("--------------------  CLIENTS  --------------------");
            for (Client clientInfo : client) {
                System.out.println("--------------------------------------------------");
                System.out.println("Id: " + clientInfo.getIdNumber());
                System.out.println("--------------------------------------------------");
            }
            /**
             * lista con los clientes
             */

            boolean add = false;
            while (!add) {
                System.out.println("Do you want to add any Swindler? y/n");
                Scanner scanner = new Scanner(System.in);
                String addConfirm = scanner.nextLine();
                if (addConfirm.toLowerCase().equals("y")) {
                    System.out.println("Introduce Swindler id:");
                    String idSwindler = scanner.nextLine();
                    controller.addPossibleSwindler(idSwindler);
                    /**
                     * llamar al controlador pasandole el id del timador que se quiere añadir
                     */
                }

                System.out.println("Do you want to continue adding? y/n");
                add = scanner.nextLine().toLowerCase().equals("n");
            }
        } else{
            System.out.println("There aren't clients available");
        }
        return true;
    }
}
