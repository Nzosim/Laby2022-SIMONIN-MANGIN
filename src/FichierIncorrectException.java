/**
 * public class FichierIncorrectException
 * Exception lance lorsqu'il y a une erreur dans un fichier du labyrinthe
 */
public class FichierIncorrectException extends Exception {
    /**
     * constructeur de la classe FichierIncorrectException
     * @param message message detaille de l'erreur rencontre
     */
    public FichierIncorrectException(String message) {
        super(message);
    }
}
