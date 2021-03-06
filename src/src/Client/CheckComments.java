package Client;

import java.io.Serializable;
import java.util.List;

public class CheckComments extends ClientOperation implements Serializable {
    public CheckComments (Client client){
        super (client);
    }

    @Override
    public boolean doOperation() {
        /**
         * doOperation de la clase CheckComments muestra la lista con los comentarios de un cliente
         */

        List<Comment> comments = controller.getCommentsList(client.getIdNumber());

        if (comments != null && comments.size() > 0) {
            System.out.println("---------------  NEW COMMENTS  ---------------");
            for (Comment commentInfo : comments) {
                System.out.println("--------------------------------------------------");
                System.out.println("Id sale: " + commentInfo.getIdSale());
                System.out.println("Id client: " + commentInfo.getIdClient());
                System.out.println("Valoration: " + commentInfo.getValoration());
                System.out.println("Comment: " + commentInfo.getComment());
                System.out.println("--------------------------------------------------");
            }
            /**
             * lista con los comentarios
             */
        }
        else {
            System.out.println("There aren't comments available. ");
        }
        return true;
    }
}
