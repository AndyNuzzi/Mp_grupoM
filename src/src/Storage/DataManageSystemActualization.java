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
        //Updates client data
        List l = loadClientsFile();
        Iterator<Client> it = l.iterator();
        boolean found = false;
        Client u = null;
        while (it.hasNext()&&!found){
            u = it.next();
            found = u.getIdNumber().equals(c.getIdNumber());
        }
        if (found) {
            l.remove(u);
            l.add(c);
            clientFile.write(clientFile.getDirectory(), l);
            return true;
        }
        return false;
    }


}
