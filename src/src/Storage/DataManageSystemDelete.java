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
    public boolean deleteOffer(String id){
        //Deletes an offer from offers' file
        List l = loadOffersFile();
        Iterator <Offer> it = l.iterator();
        boolean found = false;
        while (it.hasNext()&&!found){
            Offer o = it.next();
            if (o.getId().equals(id)){
                found = true;
                l.remove(o);
            }
        }
        if (found) {
            offerFile.write(offerFile.getDirectory(), l);
            return true;
        }
        return false;
    }

    public boolean deleteUncheckedOffer(Offer offer){
        //Deletes an offer from unchecked offers' file
        List l= loadUncheckedOfferFile();
        Iterator<Offer> it = l.iterator();
        boolean found = false;
        while (it.hasNext()&&!found){
            Offer o = it.next();
            if (o.getId().equals(offer.getId())){
                found = true;
                l.remove(o);
            }
        }
        if (found){
            uncheckedOffersFile.write((uncheckedOffersFile.getDirectory()),l);
            return true;
        }
        return false;
    }

    public boolean deletePirate(String id){
        //Deletes a pirate from pirates' file
        List l = loadPiratesFile();
        l.remove(id);
        piratesFile.write(piratesFile.getDirectory(), l);
        return true;
    }

    public boolean deleteSwindler(String id){
        //Deletes a  swindler from swindlers' file
        List l = loadSwindlerFile();
        l.remove(id);
        swindlerFile.write(swindlerFile.getDirectory(), l);
        return true;
    }

}
