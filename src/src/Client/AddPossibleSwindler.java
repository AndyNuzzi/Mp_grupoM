package Client;

import java.util.List;
import java.util.Scanner;

public class AddPossibleSwindler extends AdministratorOperation{

    public AddPossibleSwindler(Administrator admin){
        super(admin);
    }

    @Override
    public boolean doOperation() { // añade un cliente a la lista de timadores

        List<Client> client = controller.getClientList();

        System.out.println("--------------------  CLIENTS  --------------------");
        for (Client clientInfo: client) {
            System.out.println("--------------------------------------------------");
            System.out.println("Id: " + clientInfo.getIdNumber());
            System.out.println("--------------------------------------------------");
        }// lista con los clientes

        boolean add = false;
        while (! add){
            System.out.println("Do you want to add any Swindler? y/n");
            Scanner scanner = new Scanner(System.in);
            String addConfirm = scanner.nextLine();
            if (addConfirm.toLowerCase().equals("y")){
                System.out.println("Introduce Swindler id:");
                String idSwindler = scanner.nextLine();
                controller.addPossibleSwindler(idSwindler);
                // llamar al controlador pasandole el id del swindler que se quiere añadir
            }
            System.out.println("Do you want to continue adding? y/n");
            add = scanner.nextLine().toLowerCase().equals("n");
        }
        return add;
    }
}
