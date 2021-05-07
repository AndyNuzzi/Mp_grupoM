package Storage;

import Client.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataManageSystemAddersTest {

    @Test
    void addNewClient() {
        //Añade un cliente al fichero
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        ClientFile cl = ClientFile.getInstance();
        cl.setDirectory("Tests/Files/ClientFile");
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        assertTrue(add.addNewClient(c));
    }

    @Test
    void addNewAdministrator() {
        //Añade un administrador al fichero
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        AdministratorFile cl = AdministratorFile.getInstance();
        cl.setDirectory("Tests/Files/AdministratorFile");
        Administrator admin = new Administrator("adminprueba", "EARTH", "HUMAN", "00110011", "adminprueba", "password", "adminpruebaemail");
        assertTrue(add.addNewAdministrator(admin));
    }

    @Test
    void addNewStarship() {
        //Añade una nave al fichero
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        StarshipFile cl = StarshipFile.getInstance();
        cl.setDirectory("Tests/Files/StarshipFile");
        Fighter f = new Fighter();
        assertTrue(add.addNewStarship(f));
    }

    @Test
    void addNewOffer() {
        //Añade una oferta al fichero ofertas validadas
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        OfferFile cl = OfferFile.getInstance();
        cl.setDirectory("Tests/Files/OfferFile");
        Offer offer = new Offer();
        offer.setPrice(15000);
        offer.setType(0);
        offer.setCreator("C00000");
        offer.setId("O00000");
        assertTrue(add.addNewOffer(offer));
    }

    @Test
    void addNewSale() {
        //Añade una compra al fichero
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        SaleFile cl = SaleFile.getInstance();
        cl.setDirectory("Tests/Files/SaleFile");
        Sale sale = new Sale();
        assertTrue(add.addNewSale(sale));
    }

    @Test
    void addNewPirate() {
        //Añade un pirata al fichero
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        PiratesFile cl = PiratesFile.getInstance();
        cl.setDirectory("Tests/Files/PiratesFile");
        String id = "C000000";
        assertTrue(add.addNewPirate(id));
    }

    @Test
    void addNewSwindler() {
        //Añade un estafador al fichero
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        SwindlerFile cl = SwindlerFile.getInstance();
        cl.setDirectory("Tests/Files/SwindlerFile");
        String id = "C000000";
        assertTrue(add.addNewSwindler(id));
    }

    @Test
    void addNewComment() {
        //Añade un comentario al fichero
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        CommentFile cl = CommentFile.getInstance();
        cl.setDirectory("Tests/Files/CommentFile");
        Comment comment = new Comment();
        comment.setComment("Comentario de prueba");
        comment.setValoration(4);
        comment.setIdClient("C00000");
        comment.setIdSeller("C00001");
        comment.setIdSale("S00000");
        assertTrue(add.addNewComment(comment));
    }

    @Test
    void addNewUncheckedOffer() {
        //Añade una oferta al fichero de ofertas no validadas
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        UncheckedOffersFile cl = UncheckedOffersFile.getInstance();
        cl.setDirectory("Tests/Files/UncheckedOffersFile");
        Offer offer = new Offer();
        offer.setPrice(15000);
        offer.setType(0);
        offer.setCreator("C00000");
        offer.setId("O00000");
        assertTrue(add.addNewUncheckedOffer(offer));
    }

}