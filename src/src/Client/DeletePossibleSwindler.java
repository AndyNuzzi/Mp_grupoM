package Client;

import java.util.List;
import java.util.Scanner;

public class DeletePossibleSwindler extends AdministratorOperation{

    public DeletePossibleSwindler(Administrator admin){
        super(admin);
    }

    @Override

    public boolean doOperation() { // elimina timadores de la lista de piratas

        List<String> swindler = controller.getSwindlerList();

        System.out.println("--------------------  SWINDLER  --------------------");
        for (String swindlerInfo: swindler){
            System.out.println("--------------------------------------------------");
            System.out.println(" Pirate id: " + swindlerInfo);
            System.out.println("--------------------------------------------------");
        } // imprimo la lista con los timadores

        boolean delete = false;
        while (! delete){
            System.out.println("Do you want to delete any Swindler? y/n");
            Scanner scanner = new Scanner(System.in);
            String deleteConfirm = scanner.nextLine();
            if (deleteConfirm.toLowerCase().equals("y")) {
                System.out.println("Introduce Swindler id:");
                String idSwindler = scanner.nextLine();
                controller.deletePossibleSwindler(idSwindler);
                // llamar al controlador pasandole el id del swindler que se quiere eliminar
            }
            System.out.println("Do you want to continue deleting? y/n");
            String deleteContinue = scanner.nextLine();
            delete = scanner.nextLine().toLowerCase().equals("n");
        }
        return delete;
    }
}