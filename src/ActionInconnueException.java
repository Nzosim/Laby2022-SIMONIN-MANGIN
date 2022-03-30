import java.time.LocalDate;

/**
 * public class ActionInconnueException
 * Exception lance lorsqu'une action effectue par le joueur est inconnue
 */
public class ActionInconnueException extends Exception {
    /**
     * constructeur de la classe ActionInconnueException
     * @param message message detaille de l'erreur rencontre
     */
    public ActionInconnueException(String message) {
        super(message);
    }

    /**
     * constructeur vide de la classe ActionInconnueException
     */
    public ActionInconnueException() {
        super();
    }

    /**
     * methode getMessage de la classe ActionInconnueException
     * @return le message de d'erreur
     */
    @Override
    public String getMessage() {
        return "Action InconnueException : " + super.getMessage() + " " + LocalDate.now();
    }
}
