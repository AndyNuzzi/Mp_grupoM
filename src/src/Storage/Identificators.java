package Storage;

import java.io.Serializable;

public class Identificators  implements Serializable {

    //Properties
    private String [] id;

    //Methods

    public Identificators(String [] id){
        this.id = id;
    }

    public String getId(int i){
        // Si i = 0, devuelve el identificador para el siguiente cliente
        // Si i = 1, devuelve el identificador para el siguiente administrador
        // Si i = 2, devuelve el identificador para la siguiente oferta
        // Si i = 3, devuelve el identificador para la siguiente compra
        String result = id[i];
        String c = "";
        switch (i){
            case 0: c = "C00000";
            break;
            case 1: c = "A00000";
            break;
            case 2: c = "O00000";
            break;
            case 3: c = "S00000";
            break;
        }
        id[i] = c + Long.toString(Long.parseLong(id[i].substring(1, id[i].length()-1)) + 1);
        IdentificatorsFile idFile = IdentificatorsFile.getInstance();
        idFile.writeId(idFile.getDirectory(), this);
        return result;
    }
}
