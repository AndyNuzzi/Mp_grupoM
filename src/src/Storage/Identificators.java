package Storage;

import java.io.Serializable;

public class Identificators  implements Serializable {

    //Properties
    private String [] id = {"C000000", "A000000", "O000000", "S000000"};

    //Methods

    public String getId(int i){
        // Si i = 0, devuelve el identificador para el siguiente cliente
        // Si i = 1, devuelve el identificador para el siguiente administrador
        // Si i = 2, devuelve el identificador para la siguiente oferta
        // Si i = 3, devuelve el identificador para la siguiente compra
        String result = id[i];
        String c = "";
        switch (i){
            case 0 : c = "C00000";
            break;
            case 1 : c = "A00000";
            break;
            case 2 : c = "O00000";
            break;
            case 3 : c = "S00000";
            break;
        }
        id[i] = c + Long.toString(Long.parseLong(id[i].substring(1,id[i].length())) + 1);
        return result;
    }
}
