package Client;

public class SearchOffer extends ClientOperation{
    public SearchOffer (Client client){
        super ();
        // me traigo los datos del cliente
    }

    @Override
    public boolean doOperation() {
        // mostrar por pantalla que pueda elegir un tipo de nave
        // recoger la eleccion
        // llamar al controlador con el tipo de nave que se quiere buscar
        // guardar la lista que viene
        // mostrar la lista que viene del controller

        // preguntar si desea comprar --> BUY
            // mostrar el id de las ofertas
            // y si quiere comprar introducir el id por teclado
            // instanciar de la clase sale que guarda las compras --> SALE
            // settear las propiedades de SALE
            // almacenar la compra (controller)

        return true;
    }

    private boolean buy(){
        return false;
    }
}
