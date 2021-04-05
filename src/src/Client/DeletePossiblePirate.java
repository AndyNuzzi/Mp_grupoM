package Client;

import java.util.List;
import java.util.Scanner;
import Controller.*;

public class DeletePossiblePirate extends AdministratorOperation{

    public DeletePossiblePirate(Administrator admin){
        super(admin);
    }
    @Override
    public boolean doOperation() {
        // esta operacion se encarga de:
            // mostrar los id de los piratas
            // pide si desea eliminar, pide el id del pirata a eliminar y pregunta si desea continuar eliminando

        List<String> pirate = controller.getPirateList();

        for (int i = 0; i < pirate.size(); i++){
            String idInfo = pirate.get(i);
            System.out.println(idInfo);
        }
        // imprimo la lista con los piratas

        boolean delete = false;
        while (! delete){
            System.out.println("Do you want to delete any Pirate? y/n");
            Scanner scanner = new Scanner(System.in);
            String deleteConfirm = scanner.nextLine();
            if (deleteConfirm == "y") {
                System.out.println("Introduce Pirate id:");
                String idPirate = scanner.nextLine();
                controller.deletePossiblePirate(idPirate);
                // llamar al controlador pasandole el id del pirata que se quiere eliminar
            }
            System.out.println("Do you want to continue deleting? y/n");
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
