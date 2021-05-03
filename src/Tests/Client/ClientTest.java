package Client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public static void doOperation(){
        // Probaremos si se introducen correctamente las operaciones en la lista de operaciones.
        Client c = new Client("Juan", "Earth", "Human", "1", "Juan1", "password", "Juan@gmail.com");
        //metemos las operaciones
        c.doOperation();
        //ahora solo hay que comprobar que se han metido bien
        assertEquals(c.getOperation())


    }

}
