/**
 * Classe ActionInconnueException
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
     * methode getMessage de la classe ActionInconnueException
     * @return le message de d'erreur
     */
    @Override
    public String getMessage() {
        return "ActionInconnueException : " + super.getMessage();
    }
}
