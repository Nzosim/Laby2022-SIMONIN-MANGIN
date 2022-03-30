import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * public class Labyrinthe
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
     * final constante de la classe labyrinthe qui represente comment sont represente dans le labyrinthe
     * les murs, le personnage, la sortie et les zone vide
     * MUR qui represente les murs avec un X
     * PJ qui represente le personnage avec un P
     * SORTIE qui represente la sortie avec un S
     * VIDE qui represente les cases vide avec un .
     */
    public final static char MUR = 'X';
    public final static char PJ = 'P';
    public final static char SORTIE = 'S';
    public final static char VIDE = '.';

    /**
     * final constante de la classe qui represente les mouvement du personnage dans le labyrinthe
     */
    public final static String HAUT = "haut";
    public final static String BAS = "bas";
    public final static String GAUCHE = "gauche";
    public final static String DROITE = "droite";

    /**
     * methode getChar qui retourne le type d'une case (mur, case vide, personnage, sortie)
     * en fonction de ces coordonnee x et y
     * @param x position en x
     * @param y position en y
     * @return type de la case
     */
    public char getChar(int x, int y) {
        char res;
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
     * methode getSuivant qui retourne la case suivante du personnage en fonction d'une action (haut,bas,gauche,droite)
     * @param x position en x actuel du personnage
     * @param y position en y actuel du personnage
     * @param action action que le personnage effectue
     * @return la position du personnage apres le deplacement
     * @throws ActionInconnueException exception en cas d'action inconnue, les actions connues sont (haut,bas,gauche,droite)
     */
    public static int[] getSuivant(int x, int y, String action) throws ActionInconnueException {
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
                throw new ActionInconnueException("Action inconnue");

        }
        return new int[]{x, y};
    }

    /**
     * methode deplacerPerso qui permet de deplacer le personnage en fonction de l'action jusqu'au prochain mur
     * @param action action que doit effectuer le personnage
     * @throws ActionInconnueException exception en cas d'action inconnue, les actions connues sont (haut,bas,gauche,droite
     */
    public void deplacerPerso(String action) throws ActionInconnueException {
        int y = this.personnage.getPosition_Y();
        int x = this.personnage.getPosition_X();

        while (!this.murs[x][y]) {
            int[] coord = getSuivant(x, y, action);
            y = coord[1];
            x = coord[0];
            if (!this.murs[x][y]) {
                this.personnage.setPosition_Y(y);
                this.personnage.setPosition_X(x);
                y = this.personnage.getPosition_Y();
                x = this.personnage.getPosition_X();
            }
        }
    }

    /**
     * methode toString qui permet d'afficher un labyrinthe
     * @return le labyrinthe sous forme de texte
     */
    public String toString() {
        StringBuilder info = new StringBuilder();

        int hauteur = this.murs[0].length;
        int largeur = this.murs.length;

        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                info.append(getChar(i, j));
            }
            info.append("\n");
        }
        return info.toString();
    }

    /**
     * methode etreFini qui retourne si oui ou non le labyrinthe est fini
     * un labyrinthe est fini si le personnage est arrete sur la sortie
     * @return si oui ou non le labyrinthe est fini
     */
    public boolean etreFini() {
        return personnage.equals(sortie);
    }

    /**
     * methode chargerLabyrinthe qui permet de charger la labyrinthe grace a un fichier en parametre
     * de remplir les attribut murs, personnages en sortie
     * et de verifier si il n y a pas d erreur dans le fichier texte du labyrinthe
     * (nb de lignes ou de colonnes qui ne correspond pas, plusieurs personnages ou sortie, si il y a un caractère inconnu,
     * si il n y a pas de sortie ou si il n y a pas de personnage)
     * @param nom le nom du fichier du labyrinthe a ouvrir
     * @return le labyrinthe avec ces attributs complete
     * @throws IOException erreur pendant la lecture du fichier
     * @throws FichierIncorrectException erreur de colonnes, lignes, plusieurs personnages, sortie ou aucun personnage, aucune sortie
     */
    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FichierIncorrectException {

        BufferedReader buff = new BufferedReader(new FileReader(nom));
        Labyrinthe laby = new Labyrinthe();

        int nx = 0, ny = 0;
        try {
            nx = Integer.parseInt(buff.readLine());
            ny = Integer.parseInt(buff.readLine());
        }catch (NumberFormatException e){
            throw new FichierIncorrectException("Le caractère n'est pas un nombre, donc le fichier n'est pas correct");
        }

        laby.murs = new boolean[nx][ny];

        boolean persoPlace = false, sortiePlace = false;
        String ligne;

        for (int x = 0; x < nx; x++) {
            ligne = buff.readLine();

            if (ligne.length() > ny) throw new FichierIncorrectException("nbLignes ne correspond pas");

            for (int y = 0; y < ny; y++) {

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

        if (!sortiePlace) throw new FichierIncorrectException("Aucune sortie");
        if (!persoPlace) throw new FichierIncorrectException("Aucun personnage");

        buff.close();
        return laby;
    }


}
