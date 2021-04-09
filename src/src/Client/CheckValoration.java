package Client;

public class CheckValoration extends ClientOperation{
    public CheckValoration (Client client){
        super (client);
    }

    @Override
    public boolean doOperation() { // muestra la valoración media
        /**
         * doOperation de la clase CheckValoration añade un cliente a la lista de piratas
         */

        float val = controller.getAverageValoration(client.getIdNumber());
        if (val != 0) {
            System.out.println("---------------  AVERAGE VALORATION  ---------------");
            System.out.println(val);
        }
        else {
            System.out.println("You haven't been valued");
        }
        return false;
    }
}
