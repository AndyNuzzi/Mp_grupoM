package Client;

import java.util.List;
import java.util.Scanner;

public class AddPossibleSwindler extends AdministratorOperation{
    @Override
    public boolean doOperation() {
        // esta operacion muestra la lista de clientes y permite añadir un timador nuevo a la lista de timadores

        List<Client> client = controller.getClientList();

        for (int i = 0; i < client.size(); i++){
            Client idInfo = client.get(i);
            client.add(idInfo);
        }
        // imprimo la lista con los clientes

        boolean delete = false;
        while (! delete){
            System.out.println("Do you want to add any Swindler? y/n");
            Scanner scanner = new Scanner(System.in);
            String addConfirm = scanner.nextLine();
            if (addConfirm == "y") {
                System.out.println("Introduce Swindler id:");
                String idSwindler = scanner.nextLine();
                controller.addPossbileSwindler(idSwindler);
                // llamar al controlador pasandole el id del swindler que se quiere añadir
            }
            System.out.println("Do you want to continue adding? y/n");
            String deleteContinue = scanner.nextLine();
            if (deleteContinue == "n") {
                delete = false;
            } else{
                delete = true;
            }
        }
        return delete;
    }
}
