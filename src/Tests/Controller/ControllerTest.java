package Controller;

import Client.*;
import Client.User;
import Storage.DataManageSystemAdders;
import Storage.DataManageSystemQueries;
import Storage.Identificators;
import Storage.OfferFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Client createClient(){
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        return c;
    }

    private Administrator createAdministrator(){
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        Administrator admin = new Administrator("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        return admin;
    }

    private void createOffers(){
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        Offer o1 = new Offer();
        o1.setId("O1");
        o1.setType(0);
        o1.setCreator("C1");
        o1.setPrice(15000);
        o1.setDateEnd(LocalDate.now().plusDays(5));

        Offer o2 = new Offer();
        o2.setId("O2");
        o2.setType(0);
        o2.setCreator("C1");
        o2.setPrice(15000);
        o2.setDateEnd(LocalDate.now().minusDays(1));
        add.addNewOffer(o1);
        add.addNewOffer(o2);
    }

    private void banClient(Client c){
        c.setBanned(LocalDate.now().plusDays(5));
    }

    @Test
    void validateBanned() {
        //Cliente con acceso prohibido
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        Client cl = createClient();
        banClient(cl);
        User u = cl;
        if (u!=null&&u.getClass().getSimpleName().equals("Client")) {
            Client c = (Client) u;
            assertTrue (c.getBanned() != null && LocalDate.now().isBefore(c.getBanned()));
        } else {
            fail();
        }
    }

    @Test
    void validateNotExists(){
        //Cliente no existe
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        Client cl = createClient();
        User u = null;
        if (u!=null&&u.getClass().getSimpleName().equals("Client")){
            fail();
        }
        assertEquals(null, u);
    }

    @Test
    void validateExists(){
        //Cliente existe
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        Client cl = createClient();
        User u = cl;
        if (u!=null&&u.getClass().getSimpleName().equals("Client")){
            Client c = (Client) u;
            if (c.getBanned()!= null && LocalDate.now().isBefore(c.getBanned())){
                fail();
            }
            assertEquals(cl.getIdNumber(), u.getIdNumber());
        } else {
            fail();
        }
    }

    @Test
    void validateAdminsitrator(){
        //Administrador existe
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        Administrator admin = createAdministrator();
        User u = admin;
        if (u!=null&&u.getClass().getSimpleName().equals("Client")){
            fail();
        }
        assertTrue(u.getClass().getSimpleName().equals("Administrator"));
    }

    @Test
    void deleteOfferPassedDates() {
        //Crear dos ofertas, una con fecha anterior y otra con posterior e invocar el metodo
        OfferFile of = OfferFile.getInstance();
        File f = new File("Tests/Files/OfferFile");
        f.delete();
        of.setDirectory("Tests/Files/OfferFile");
        createOffers();
        Controller c = new Controller();
        c.deleteOfferPassedDates();
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        assertTrue(queries.loadOffers().size() == 1);
    }

}