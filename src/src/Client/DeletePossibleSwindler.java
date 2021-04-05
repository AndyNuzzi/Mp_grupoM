package Client;

import java.util.List;
import java.util.Scanner;
import Controller.*;

public class DeletePossibleSwindler extends AdministratorOperation{
    @Override
    public boolean doOperation() {
        // esta operacion se encarga de:
            // mostrar los id de los timadores
            // pide si desea eliminar, pide el id del timador a eliminar y pregunta si desea continuar eliminando

        List<String> swindler = controller.getSwindlerList();
        //lista que va a almacenar el id de los timadores

        for (int i = 0; i < swindler.size(); i++){
          String idInfo = swindler.get(i);
          System.out.println(idInfo);
        }
        // imprimo la lista con los timadores

        boolean delete = false;
        while (! delete){
            System.out.println("Do you want to delete any Swindler? y/n");
            Scanner scanner = new Scanner(System.in);
            String deleteConfirm = scanner.nextLine();
            if (deleteConfirm == "y") {
                System.out.println("Introduce Swindler id:");
                String idSwindler = scanner.nextLine();
                controller.deletePossbileSwindler(idSwindler);
                // llamar al controlador pasandole el id del swindler que se quiere eliminar
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