package Storage;

public class DataManageSystem {

    //Properties
    private DataManageSystem dataManageSystem;
    private ClientFile clientFile;
    private OfferFile offerFile;
    private SaleFile saleFile;
    private AdministratorFile administratorFile;
    private StarshipFile starshipFile;
    private CommentFile commentFile;
    private PiratesFile piratesFile;
    private SwindlerFile swindlerFile;
    private UncheckedOffersFile uncheckedOffersFile;

    //Methods
    private DataManageSystem(){
        clientFile = new ClientFile();
        offerFile = new OfferFile();
        saleFile = new SaleFile();
        administratorFile = new AdministratorFile();
        starshipFile = new StarshipFile();
        commentFile = new CommentFile();
        piratesFile = new PiratesFile();
        swindlerFile = new SwindlerFile();
        uncheckedOffersFile = new UncheckedOffersFile();
    }

    public DataManageSystem getInstance(){
        if (dataManageSystem == null)
            dataManageSystem = new DataManageSystem();
        return dataManageSystem;
    }


}
