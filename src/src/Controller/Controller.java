package Controller;

import Client.*;
import Storage.*;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    //Properties
    private DataManageSystemAdders adders = DataManageSystemAdders.getInstance();
    private DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
    private DataManageSystemDelete delete = DataManageSystemDelete.getInstance();
    private DataManageSystemActualization actualization = DataManageSystemActualization.getInstance();
    private IdentificatorsFile idFile = IdentificatorsFile.getInstance();
    private SubscriptionFile subscriptionFile = SubscriptionFile.getInstance();

    //Methods
    public User validate(String nick, String password){
        //Returns a User with its information
        User u =queries.openSession(nick, password);
        if (u!=null&&u.getClass().getSimpleName().equals("Client")){
            Client c = (Client) u;
            if (c.getBanned()!= null &&c.getBanned().compareTo(LocalDate.now()) > 0){
                return null;
            }
            return c;
        }
        return u;
    }

    public String validateNick(String nick){
        //Checks if nick is unique. If it's unique, returns an identificator.
        //In other case it returns null.
        if (!queries.validateNick(nick)){
            Identificators id = idFile.readId(idFile.getDirectory());
            String output = id.getId(0);
            return output;
        }
        return null;
    }

    public void createUser(Client c){
        //Adds a new client in the system
        adders.addNewClient(c);
    }

    public void createStarship(Starship s){
        //Adds new starship to the system
        adders.addNewStarship(s);
    }

    public boolean validateRegisterNumber(String s){
        //Checks if the register number has been used before
        return queries.checkRegisterNumber(s);
    }

    public boolean addToUncheckedOffers(Offer offer){
        //Adds a new offer to the list to be checked.
        Identificators id = idFile.readId(idFile.getDirectory());
        offer.setId(id.getId(2));
        return adders.addNewUncheckedOffer(offer);
    }

    public boolean deleteFromUncheckedOffers(Offer offer){
        //Deletes from the list of unchecked offers
        return delete.deleteUncheckedOffer(offer);
    }

    public boolean addOffer(Offer offer){
        //Adds a new offer to valid offer's list.
        Subscription s = subscriptionFile.read();
        s.notifySubscribers(offer.getType());
        return adders.addNewOffer(offer);
    }

    public boolean storeSale(Sale sale){
        //Adds a new sale to the system.
        return adders.addNewSale(sale);
    }

    public List<Client> getClientList(){
        // Returns all clients
        return queries.loadClients();
    }

    public Client getClient(String id){
        //Returns one client and its information
        return queries.getClient(id);
    }

    public void addPossiblePirate(String id){
        //Adds a client in pirates' list
        adders.addNewPirate(id);
    }

    public void addPossibleSwindler(String id){
        //Adds a swindler to swindlers' list
        adders.addNewSwindler(id);
    }

    public List<String> getPirateList(){
        //Returns list with all possible pirates
        return queries.loadPirates();
    }

    public void deletePossiblePirate(String id){
        //Deletes an id from the list
        delete.deletePirate(id);
    }

    public List<String> getSwindlerList(){
        //Returns swindlers' list
        return queries.loadSwindlers();
    }

    public void deletePossibleSwindler(String id){
        //Deletes an id from the list
        delete.deleteSwindler(id);
    }

    public List<Comment> getCommentsList(String id){
        //Returns a comments' list of a client
        return queries.getComments(id);
    }

    public float getAverageValoration(String id){
        //Returns an average valoration of a client
        return queries.getValoration(id);
    }

    public List<Offer> getUncheckedOffersList(){
        //Returns a offers' list to be checked
        return queries.loadUncheckedOffers();
    }

    public boolean createNewAdministrator(Administrator admin){
        //Adds a new administrator to system
        return adders.addNewAdministrator(admin);
    }

    public String getIdAdmin(){
        Identificators id = idFile.readId(idFile.getDirectory());
        return id.getId(1);
    }

    public List<String> getNotificationsList() {
        System.out.println("Falta");
        return null;
    }

    public List<Offer> getOffer(String shipElection, String id) {
        return queries.searchOffers(shipElection, id);
    }

    public void deleteOffer(String id) {
        delete.deleteOffer(id);
    }

    public String getIdSale() {
        System.out.println("Falta");
        return null;
    }

    public List<Starship> getStarship(List<String> ids){
        return queries.getStarships(ids);
    }

    public void addSubscription(String id, String option){
        Subscription sub = subscriptionFile.read();
        sub.addSubscription(id,option);
    }

          //No terminadas
        /*
            public String getNotificationsList(){}
        */



}
