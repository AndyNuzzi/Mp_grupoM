package Storage;

import Client.Client;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DataManageSystemActualizationTest {


    @Test
    void clientActualizationIsEmpty() {
        //Prueba de actualizacion de un cliente si no está almacenado
        ClientFile cl = ClientFile.getInstance();
        cl.setDirectory("Tests/Files/ClientFile");
        File f = new File("Tests/Files/ClientFile");
        f.delete();
        DataManageSystemActualization d = DataManageSystemActualization.getInstance();
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        assertFalse(d.clientActualization(c));
    }

    @Test
    void clientActualization() {
        //Prueba de actualizar un cliente si está almacenado
        ClientFile cl = ClientFile.getInstance();
        cl.setDirectory("Tests/Files/ClientFile");
        DataManageSystemActualization d = DataManageSystemActualization.getInstance();
        Client c = new Client("Prueba", "EARTH", "HUMAN", "0000000", "pruebanick", "prubapassword", "pruebaemail");
        DataManageSystemAdders add = DataManageSystemAdders.getInstance();
        add.addNewClient(c);
        assertTrue(d.clientActualization(c));
    }
}