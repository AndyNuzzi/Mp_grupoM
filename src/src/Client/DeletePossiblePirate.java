package Client;

import java.util.List;
import java.util.Scanner;

public class DeletePossiblePirate extends AdministratorOperation{

    public DeletePossiblePirate(Administrator admin){
        super(admin);
    }

    @Override

    public boolean doOperation() {
        /**
         * doOperation de la clase DeletePossiblePirate elimina piratas de la lista de piratas
         */

        List<String> pirate = controller.getPirateList();

        if (pirate != null) {
            System.out.println("--------------------  PIRATES  --------------------");
            for (String pirateInfo : pirate) {
                System.out.println("--------------------------------------------------");
                System.out.println(" Pirate id: " + pirateInfo);
                System.out.println("--------------------------------------------------");
            }
            /**
             * imprimo la lista con los piratas
             */

            boolean delete = false;
            while (!delete) {
                System.out.println("Do you want to delete any Pirate? y/n");
                Scanner scanner = new Scanner(System.in);
                String deleteConfirm = scanner.nextLine();
                if (deleteConfirm.toLowerCase().equals("y")) {
                    System.out.println("Introduce Pirate id:");
                    String idPirate = scanner.nextLine();
                    controller.deletePossiblePirate(idPirate);
                    /**
                     * llamar al controlador pasandole el id del pirata que se quiere eliminar
                     */
                }
                System.out.println("Do you want to continue deleting? y/n");
                delete = scanner.nextLine().toLowerCase().equals("n");
            }
        } else{
            System.out.println("There aren't pirates");
        }
        return true;
    }
}
