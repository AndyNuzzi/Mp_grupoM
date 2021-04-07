package Client;

public class CheckValoration extends ClientOperation{
    public CheckValoration (Client client){
        super (client);
    }

    @Override
    public boolean doOperation() { // muestra la valoración media

        System.out.println("---------------  AVERAGE CLIENT VALORATION  ---------------");
        System.out.println(controller.getAverageValoration(client.getIdNumber()));

        return false;
    }
}
