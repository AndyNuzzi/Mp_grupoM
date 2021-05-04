package Storage;

import Client.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DataManageSystemQueriesTest {

    @BeforeEach
    private void generateFiles(){
        List <String> dirList = new ArrayList<>();
        String dir = "Tests/Files/";
        dirList.add(dir + "AdministratorFile");
        dirList.add(dir + "ClientFile");
        dirList.add(dir + "CommentFile");
        dirList.add(dir + "IdentificatorsFile");
        dirList.add(dir + "OfferFile");
        dirList.add(dir + "PiratesFile");
        dirList.add(dir + "SaleFile");
        dirList.add(dir + "StarshipFile");
        dirList.add(dir + "SwindlerFile");
        dirList.add(dir + "UncheckedOFfersFile");
        for (String s: dirList){
            File f = new File(s);
            f.delete();
        }
        AdministratorFile af = AdministratorFile.getInstance();
        ClientFile cf = ClientFile.getInstance();
        CommentFile cmf = CommentFile.getInstance();
        IdentificatorsFile iF = IdentificatorsFile.getInstance();
        OfferFile of = OfferFile.getInstance();
        PiratesFile pf = PiratesFile.getInstance();
        SaleFile sf = SaleFile.getInstance();
        StarshipFile stf = StarshipFile.getInstance();
        SwindlerFile swF = SwindlerFile.getInstance();
        UncheckedOffersFile uF = UncheckedOffersFile.getInstance();
        List<FileOperations> opList = new ArrayList<>();
        opList.add(af);
        opList.add(cf);
        opList.add(cmf);
        opList.add(iF);
        opList.add(of);
        opList.add(pf);
        opList.add(sf);
        opList.add(stf);
        opList.add(swF);
        opList.add(uF);

        SubscriptionFile subF = SubscriptionFile.getInstance();
        File f = new File("Tests/Files/SubscriptionFile");
        f.delete();
        subF.setDirectory("Tests/Files/SubscriptionFile");

        for (int i = 0; i < dirList.size(); i++){
            opList.get(i).setDirectory(dirList.get(i));
        }
    }

    private Client createClient(){
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        add.addNewClient(c);
        return c;
    }

    @Test
    void validateNickUsed() {
        Client c = createClient();
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        String nick = "pruebanick";
        assertTrue(queries.validateNick(nick));
    }

    @Test
    void validateNickNotUsed() {
        //Comprueba que el nick no ha sido usado
        Client c = createClient();
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        String nick = "notUsedNick";
        assertFalse(queries.validateNick(nick));
    }

    @Test
    void validateNickNoUsers() {
        //Comprueba si no hay usuarios que el nick no está usado
        File f = new File("Tests/Files/ClientFile");
        f.delete();
        ClientFile cf = ClientFile.getInstance();
        cf.setDirectory("Tests/Files/ClientFile");
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        String nick = "notUsedNick";
        assertFalse(queries.validateNick(nick));
    }

    @Test
    void searchOffers() {
        //Comprueba que devuelve una lista de ofertas que no son del cliente que las busca
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        ClientFile cf = ClientFile.getInstance();
        cf.setDirectory("Tests/Files/ClientFile");
        OfferFile of = OfferFile.getInstance();
        of.setDirectory("Tests/Files/OfferFile");
        File f = new File("Tests/Files/ClientFile");
        f.delete();
        File ofF = new File("Tests/Files/OfferFile");
        ofF.delete();
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        add.addNewClient(c);
        Offer offer1 = new Offer();
        offer1.setId("O00000");
        offer1.setCreator("0000000");
        offer1.setType(0);
        offer1.setPrice(15000);
        add.addNewOffer(offer1);

        Offer offer2 = new Offer();
        offer2.setId("O00001");
        offer2.setCreator("0000001");
        offer2.setType(0);
        offer2.setPrice(15000);
        add.addNewOffer(offer2);
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        List<Offer> l = queries.searchOffers("SpaceStation","0000000");
        assertTrue(l.size()==1 && l.get(0).getId().equals(offer2.getId()));
    }

    @Test
    void searchOffersNotExists() {
        //Comprueba que no debe devolver ninguna oferta
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        ClientFile cf = ClientFile.getInstance();
        cf.setDirectory("Tests/Files/ClientFile");
        OfferFile of = OfferFile.getInstance();
        of.setDirectory("Tests/Files/OfferFile");
        File f = new File("Tests/Files/ClientFile");
        f.delete();
        File ofF = new File("Tests/Files/OfferFile");
        ofF.delete();
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        add.addNewClient(c);
        Offer offer1 = new Offer();
        offer1.setId("O00000");
        offer1.setCreator("0000000");
        offer1.setType(0);
        offer1.setPrice(15000);
        add.addNewOffer(offer1);

        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        List<Offer> l = queries.searchOffers("SpaceStation","0000000");
        assertTrue(l.size()==0);
    }

    @Test
    void searchOffersEmptyOffers() {
        //Comprueba que el metodo devuelve null si no hay ofertas en el sistema
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        ClientFile cf = ClientFile.getInstance();
        cf.setDirectory("Tests/Files/ClientFile");
        OfferFile of = OfferFile.getInstance();
        of.setDirectory("Tests/Files/OfferFile");
        File f = new File("Tests/Files/ClientFile");
        f.delete();
        File ofF = new File("Tests/Files/OfferFile");
        ofF.delete();
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        add.addNewClient(c);

        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        List<Offer> l = queries.searchOffers("SpaceStation","0000000");
        assertTrue(l == null);
    }

    @Test
    void openSession() {
        //Crea un cliente, inicia sesion y comprueba que devuelve el mismo cliente
        Client c = createClient();
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        assertEquals(queries.openSession(c.getNick(),c.getPassword()).getIdNumber(), c.getIdNumber());
    }

    @Test
    void openSessionUserNotFound() {
        //Crea un cliente pero no se almacena e intenta iniciar sesion. Debe devolver null.
        Client c1 = createClient();
        Client c = new Client("Prueba2", "EARTH", "HUMAN", "0000001", "pruebanick2", "prubapassword2", "pruebaemail2");
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        assertEquals(queries.openSession(c.getNick(),c.getPassword()), null);
    }

    @Test
    void getComments() {
        //Crea un comentario dirigido a un cliente. Comprueba que solo recibe un comentario
        Client c = createClient();
        Comment comment = new Comment();
        comment.setComment("Comentario de prueba");
        comment.setIdSeller("0000000");

        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        DataManageSystemAdders add =DataManageSystemAdders.getInstance();
        add.addNewComment(comment);
        assertEquals(queries.getComments("0000000").size(), 1);
    }

    @Test
    void getCommentsOfMyself() {
        //El clente pone un comentario dirigido a otro cliente. No debe devolverle ningun comentario.
        Client c = createClient();
        Comment comment = new Comment();
        comment.setComment("Comentario de prueba");
        comment.setIdSeller("0000001");

        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        DataManageSystemAdders add =DataManageSystemAdders.getInstance();
        add.addNewComment(comment);
        assertEquals(queries.getComments("0000000").size(), 0);
    }


    @Test
    void loadClients() {
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        boolean a = (queries.loadClients() == null) || (queries.loadClients().size() == 0) ;
        createClient();
        boolean b = queries.loadClients().size() == 1;
        createClient();
        boolean c = queries.loadClients().size() == 2;
        assertTrue(a & b & c);
    }

    @Test
    void loadPirates() {
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        boolean a = (queries.loadPirates() == null || queries.loadPirates().isEmpty()) ;
        Client c = createClient();
        c.setPirate(true);
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        add.addNewPirate(c.getIdNumber());
        boolean b = queries.loadPirates().size() == 1;
        assertTrue(a & b );
    }


    @Test
    void getClient() {
        Client c1 = createClient();
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        Client c = queries.getClient("0000000");
        assertEquals(c.getIdNumber(), c1.getIdNumber());
    }

}