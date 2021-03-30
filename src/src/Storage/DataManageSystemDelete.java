package Storage;

import Client.*;

import java.util.Iterator;
import java.util.List;

public class DataManageSystemDelete extends DataManageSystem{

    //Properties
    private static DataManageSystemDelete dataManageSystem;

    //Singleton
    private DataManageSystemDelete(){
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

    public static DataManageSystemDelete getInstance(){
        if (dataManageSystem == null)
            dataManageSystem = new DataManageSystemDelete();
        return dataManageSystem;
    }

    //Methods
    public boolean deleteOffer(Offer offer){
        List l = loadOffers();
        Iterator <Offer> it = l.iterator();
        boolean found = false;
        while (it.hasNext()&&!found){
            Offer o = it.next();
            if (o.getId().equals(offer.getId())){
                found = true;
                l.remove(o);
            }
        }
        offerFile.write(offerFile.getDirectory(), l);
        return true;
    }

    public boolean deletePirate(String id){
        List l = loadPirates();
        l.remove(id);
        piratesFile.write(piratesFile.getDirectory(), l);
        return true;
    }

    public boolean deleteSwindler(String id){
        List l = loadSwindler();
        l.remove(id);
        swindlerFile.write(swindlerFile.getDirectory(), l);
        return true;
    }

}
