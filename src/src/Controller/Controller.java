package Controller;

import Client.*;
import Storage.*;

import java.util.List;

public class Controller {

    //Properties
    private DataManageSystemAdders adders = DataManageSystemAdders.getInstance();
    private DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
    private DataManageSystemDelete delete = DataManageSystemDelete.getInstance();
    private DataManageSystemActualization actualization = DataManageSystemActualization.getInstance();
    private Identificators identificators = new Identificators();

    //Methods
    public User validate(String nick, String password){
        return queries.openSession(nick, password);
    }

    public String validateNick(String nick){
        if (!queries.validateNick(nick)){
            String output = identificators.getId(0);
            return output;
        }
        return null;
    }

    public void createUser(Client c){
        adders.addNewClient(c);
    }

    public void createStarship(Starship s){
        adders.addNewStarship(s);
    }

    public boolean validateRegisterNumber(String s){
        return queries.checkRegisterNumber(s);
    }

    public boolean addToUncheckedOffers(Offer offer){
        return adders.addNewUncheckedOffer(offer);
    }

    public boolean deleteFromUncheckedOffers(Offer offer){
        return delete.deleteUncheckedOffer(offer);
    }

    public boolean addOffer(Offer offer){
        return adders.addNewOffer(offer);
    }

    public boolean storeSale(Sale sale){
        return adders.addNewSale(sale);
    }

    public List<Client> getClientList(){
        return queries.loadClients();
    }

    public Client getClient(String id){
        return queries.getClient(id);
    }

    public void addPossiblePirate(String id){
        adders.addNewPirate(id);
    }

    public void addPossibleSwindler(String id){
        adders.addNewSwindler(id);
    }

    public List<String> getPirateList(){
        return queries.loadPirates();
    }

    public void deletePossiblePirate(String id){
        delete.deletePirate(id);
    }

    public List<String> getSwindlerList(){
        return queries.loadSwindlers();
    }

    public void deletePossibleSwindler(String id){
        delete.deleteSwindler(id);
    }

    public List<Comment> getCommentsList(String id){
        return queries.getComments(id);
    }

    public float getAverageValoration(String id){
        return queries.getValoration(id);
    }

    public List<Offer> getUncheckedOffersList(){
        return queries.loadUncheckedOffers();
    }

    public boolean createNewAdministrator(Administrator admin){
        return adders.addNewAdministrator(admin);
    }
        //No terminadas
        /*    public void addSubscription(String s){
                actualization.clientActualization(c);
            }
            public String getNotificationsList(){}*/



}
