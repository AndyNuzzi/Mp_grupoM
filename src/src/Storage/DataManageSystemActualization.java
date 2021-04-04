package Storage;

import Client.*;

import java.util.Iterator;
import java.util.List;

public class DataManageSystemActualization extends DataManageSystem{

    //Properties
    private static DataManageSystemActualization dataManageSystem;


    //Singleton
    private DataManageSystemActualization(){
        clientFile = ClientFile.getInstance();
        offerFile = OfferFile.getInstance();
        saleFile = SaleFile.getInstance();
        administratorFile = AdministratorFile.getInstance();
        starshipFile = StarshipFile.getInstance();
        commentFile = CommentFile.getInstance();
        piratesFile = PiratesFile.getInstance();
        swindlerFile = SwindlerFile.getInstance();
        uncheckedOffersFile = UncheckedOffersFile.getInstance();
    }

    public static DataManageSystemActualization getInstance(){
        if (dataManageSystem == null)
            dataManageSystem = new DataManageSystemActualization();
        return dataManageSystem;
    }


    //Methods
    public boolean clientActualization(Client c){
        //Actualiza los datos del cliente. Devuelve true si se ha actualizado.
        //Devuelve false si no se ha podido realizar la operacion
        List l = loadClientsFile();
        Iterator<Client> it = l.iterator();
        boolean found = false;
        while (it.hasNext()&&!found){
            Client u = it.next();
            if (u.getIdNumber().equals(c.getIdNumber())){
                l.remove(u);
                l.add(c);
            }
        }
        if (found) {
            clientFile.write(clientFile.getDirectory(), l);
            return true;
        }
        return false;
    }


}
