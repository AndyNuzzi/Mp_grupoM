package Client;

public class SearchOffer extends ClientOperation{
    public SearchOffer (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {
        Sale sale = new Sale ();
        // instanciar de la clase sale que guarda las compras

        return true;
    }
}
