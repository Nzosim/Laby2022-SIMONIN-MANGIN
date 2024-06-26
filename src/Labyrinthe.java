import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * La classe Labyrinthe
 */
public class Labyrinthe {

    /**
     * attribut prive de la classe labyrinthe
     * mur un tableau de booleen a double dimensions qui represente si l'emplacement est un mur ou non
     * le personnage de type Personnage
     * la sortie de type Sortie
     */
    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;

    /**
     * constante fini de la classe labyrinthe qui represente comment est representee le labyrinthe
     * les murs, le personnage, la sortie et les zone vide
     * MUR qui represente les murs avec un X
     * PJ qui represente le personnage avec un P
     * SORTIE qui represente la sortie avec un S
     * VIDE qui represente les cases vide avec un
     */
    public final static char MUR = 'X';
    public final static char PJ = 'P';
    public final static char SORTIE = 'S';
    public final static char VIDE = '.';

    /**
     * constante fini de la classe qui represente les mouvements du personnage dans le labyrinthe
     */
    public final static String HAUT = "haut";
    public final static String BAS = "bas";
    public final static String GAUCHE = "gauche";
    public final static String DROITE = "droite";

    /**
     * methode chargerLabyrinthe qui permet de charger le labyrinthe grace a un fichier en parametre
     * de remplir les attributs murs, personnages en sortie
     * et de verifier s'il n'y a pas d'erreur dans le fichier texte du labyrinthe
     * (nb de lignes ou de colonnes qui ne correspond pas, plusieurs personnages ou plusieurs sorties, s'il y a un caractère inconnu,
     *  s'il n'y a pas de sortie ou s'il n'y a pas de personnage)
     * @param nom le nom du fichier du labyrinthe a ouvrir
     * @return le labyrinthe avec ces attributs complete
     * @throws IOException erreur pendant la lecture du fichier
     * @throws FichierIncorrectException erreur de colonnes, lignes, plusieurs personnages, plusieurs sorties ou aucun personnage, aucune sortie
     */
    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FichierIncorrectException {
        // On ouvre le fichier et initialise le labyrinthe
        BufferedReader buff = new BufferedReader(new FileReader(nom));
        Labyrinthe laby = new Labyrinthe();

        int nx;
        int ny;
        try {
            nx = Integer.parseInt(buff.readLine());
            ny = Integer.parseInt(buff.readLine());
        } catch (NumberFormatException e) {
            // On lance une exception si le fichier n'est pas au bon format
            throw new FichierIncorrectException("pb num ligne ou colonne");
        }

        // Initialisation des murs du labyrinthe
        laby.murs = new boolean[nx][ny];

        // Pour savoir si le personnage ou la sortie sont deja present dans le labyrinthe
        // On utilise deux booleens pour savoir si le personnage ou la sortie sont deja present
        boolean persoPlace = false;
        boolean sortiePlace = false;
        String ligne;

        // On parcours le fichier
        for (int x = 0; x < nx; x++) {
            // On lit une ligne du fichier

            ligne = buff.readLine();

            // On lance une exception si le fichier a une ou plusieurs lignes en moins que le nombre de lignes du labyrinthe
            if (ligne == null) {
                throw new FichierIncorrectException("nbLignes ne correspond pas");
            }

            // On verifie que la ligne est de la bonne taille
            // Sinon on lance une exception FichierIncorrectException
            if (ligne.length() < ny) throw new FichierIncorrectException("nbColonnes ne correspond pas");

            // On parcours la ligne
            for (int y = 0; y < ny; y++) {

                // On verifie que le caractere est un mur ou un personnage ou une sortie
                // Sinon on lance une exception FichierIncorrectException

                // Pour la sortie on verifie que la sortie n'est pas deja presente
                // Pour le personnage on verifie que le personnage n'est pas deja present
                switch (ligne.charAt(y)) {
                    case 'S':
                        if (sortiePlace) throw new FichierIncorrectException("plusieurs sorties");
                        laby.sortie = new Sortie(x, y);
                        sortiePlace = true;
                        break;
                    case 'P':
                        if (persoPlace) throw new FichierIncorrectException("plusieurs personnages");
                        laby.personnage = new Personnage(x, y);
                        persoPlace = true;
                        break;
                    case 'X':
                        laby.murs[x][y] = true;
                        break;
                    case '.':
                        laby.murs[x][y] = false;
                        break;
                    default:
                        throw new FichierIncorrectException("caractere inconnu " + ligne.charAt(y));
                }
            }
        }

        // On regarde qu'il n'y a plus aucune ligne
        ligne = buff.readLine();
        if (ligne != null) throw new FichierIncorrectException("nbLignes ne correspond pas");

        // On verifier que le fichier contient bien une sortie et un personnage
        if (!sortiePlace) throw new FichierIncorrectException("sortie inconnue");
        if (!persoPlace) throw new FichierIncorrectException("personnage inconnu");

        // On ferme le fichier
        buff.close();

        // On retourne le labyrinthe
        return laby;
    }

    /**
     * methode getChar qui retourne le caractere d'une case (mur, case vide, personnage, sortie)
     * en fonction de ces coordonnees x et y
     *
     * @param x position en x
     * @param y position en y
     * @return le caractere de la case
     */
    public char getChar(int x, int y) {
        char res;

        // On prend le caractere correspondant a la case
        if (murs[x][y]) {
            res = MUR;
        } else if (personnage.equals(x, y)) {
            res = PJ;
        } else if (sortie.equals(x, y)) {
            res = SORTIE;
        } else {
            res = VIDE;
        }
        return res;
    }

    /**
     * methode etreFini qui retourne si oui ou non le labyrinthe est fini
     * un labyrinthe est fini si le personnage est arrete sur la sortie
     *
     * @return si oui ou non le labyrinthe est fini
     */
    public boolean etreFini() {
        return personnage.equals(sortie);
    }

    /**
     * methode deplacerPerso qui permet de deplacer le personnage en fonction de l'action jusqu'au prochain mur ou la sortie
     *
     * @param action action que doit effectuer le personnage
     * @throws ActionInconnueException exception en cas d'action inconnue, les actions connues sont (haut,bas,gauche,droite)
     */
    public void deplacerPerso(String action) throws ActionInconnueException {
        int x = this.personnage.getPosition_X();
        int y = this.personnage.getPosition_Y();

        // On avance le personnage tant qu'il ne rencontre pas de mur ou de sortie
        while (!this.murs[x][y]) {
            int[] coord = getSuivant(x, y, action);
            x = coord[0];
            y = coord[1];

            // Si la coordonnee suivante n'est pas un mur,
            // On met a jour la position du personnage
            if (!this.murs[x][y]) {
                this.personnage.setPosition_Y(y);
                this.personnage.setPosition_X(x);
                y = this.personnage.getPosition_Y();
                x = this.personnage.getPosition_X();
            }
        }
    }


    /**
     * methode getSuivant qui retourne la case suivante du personnage en fonction d'une action (haut,bas,gauche,droite)
     *
     * @param x      position en x actuel du personnage
     * @param y      position en y actuel du personnage
     * @param action action que le personnage effectue
     * @return la position du personnage apres le deplacement
     * @throws ActionInconnueException exception en cas d'action inconnue, les actions connues sont (haut,bas,gauche,droite)
     */
    public static int[] getSuivant(int x, int y, String action) throws ActionInconnueException {
        // On verifie que l'action est connue et donne la nouvelle position suivante du personnage
        switch (action) {
            case HAUT:
                x--;
                break;
            case BAS:
                x++;
                break;
            case GAUCHE:
                y--;
                break;
            case DROITE:
                y++;
                break;
            default:
                // On lance une exception si l'action n'est pas connue
                throw new ActionInconnueException(action);

        }
        return new int[]{x, y};
    }

    /**
     * methode toString qui permet d'afficher le labyrinthe
     *
     * @return le labyrinthe sous forme de texte
     */
    public String toString() {
        // On utilise un StringBuilder pour eviter d'utiliser String
        // Qui est plus lent pour la concatenation
        StringBuilder info = new StringBuilder();

        // Initialisation des variables de coordonnees
        int largeur = this.murs[0].length;
        int hauteur = this.murs.length;

        // On parcourt le labyrinthe et on ajoute les caracteres correspondant
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                info.append(getChar(i, j));
            }
            // On ajoute un retour a la ligne a la fin de chaque ligne
            info.append("\n");
        }

        // On retourne le labyrinthe sous forme de texte
        return info.toString();
    }




}
