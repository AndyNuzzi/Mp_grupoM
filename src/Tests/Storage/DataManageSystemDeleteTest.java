package Storage;

import Client.Offer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataManageSystemDeleteTest {

    @Test
    void deleteOffer() {
        //Añade y elimina una oferta y comprueba que se ha eliminado
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        File f = new File("Tests/Files/OfferFile");
        f.delete();
        DataManageSystemDelete del = DataManageSystemDelete.getInstance();
        DataManageSystemAddersTest d = new DataManageSystemAddersTest();
        d.addNewOffer();
        del.deleteOffer("O00000");
        assertEquals(queries.loadOffersFile().size(), 0);
    }

    @Test
    void deleteUncheckedOffer() {
        //Añade y elimina una oferta a las no validadas y comprueba que se ha eliminado correctamente
        File f = new File("Tests/Files/UncheckedOffersFile");
        f.delete();
        DataManageSystemDelete del = DataManageSystemDelete.getInstance();
        DataManageSystemAddersTest d = new DataManageSystemAddersTest();
        d.addNewUncheckedOffer();
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        List<Offer> l = queries.loadUncheckedOffers();
        Offer offer = l.get(0);
        del.deleteUncheckedOffer(offer);
        assertEquals(queries.loadUncheckedOffers().size(), 0);
    }

    @Test
    void deletePirate() {
        //Añade y elimina un pirata y comprueba que se ha eliminado correctamente
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        File f = new File("Tests/Files/PiratesFile");
        f.delete();
        DataManageSystemDelete del = DataManageSystemDelete.getInstance();
        DataManageSystemAddersTest d = new DataManageSystemAddersTest();
        d.addNewPirate();
        del.deletePirate("C000000");
        assertEquals(queries.loadPirates().size(), 0);
    }

    @Test
    void deleteSwindler() {
        //Añade y elimina un estafador y comprueba que se ha eliminado correctamente
        DataManageSystemQueries queries = DataManageSystemQueries.getInstance();
        File f = new File("Tests/Files/SwindlerFile");
        f.delete();
        DataManageSystemDelete del = DataManageSystemDelete.getInstance();
        DataManageSystemAddersTest d = new DataManageSystemAddersTest();
        d.addNewSwindler();
        del.deleteSwindler("C000000");
        assertEquals(queries.loadSwindlers().size(),0);
    }

    //Podria probarse intentar eliminar sin que haya nada
}