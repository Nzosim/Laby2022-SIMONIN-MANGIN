/**
 * Classe FichierIncorrectException
 */
public class FichierIncorrectException extends Exception {
    /**
     * constructeur de la classe FichierIncorrectException
     * @param message message detaille de l'erreur rencontre
     */
    public FichierIncorrectException(String message) {
        super(message);
    }


    /**
     * methode getMessage de la classe FichierIncorrectException
     * @return le message de d'erreur
     */
    @Override
    public String getMessage() {
        return "FichierIncorrectException : " + super.getMessage();
    }
}
