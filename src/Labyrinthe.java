import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {
    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;

    public final static char MUR = 'X';
    public final static char PJ = 'P';
    public final static char SORTIE = 'S';
    public final static char VIDE = '.';

    public final static String HAUT = "haut";
    public final static String BAS = "bas";
    public final static String GAUCHE = "gauche";
    public final static String DROITE = "droite";

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


    public static int[] getSuivant(int x, int y, String action) {
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
        }
        return new int[]{x, y};
    }


    public void deplacerPerso(String action) {
        int y = this.personnage.getPosition_Y();
        int x = this.personnage.getPosition_X();

        while (!this.murs[x][y]) {
            int[] coord = getSuivant(x, y, action);
            y = coord[0];
            x = coord[1];
            if (!this.murs[x][y]) {
                this.personnage.setPosition_Y(y);
                this.personnage.setPosition_X(x);
                y = this.personnage.getPosition_Y();
                x = this.personnage.getPosition_X();
            }
        }
    }


    public String toString() {
        StringBuilder info = new StringBuilder();

        int hauteur = this.murs[0].length;
        int largeur = this.murs.length;

        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                info.append(getChar(j, i));
            }
            info.append("\n");
        }
        System.out.println(personnage+"\n"+sortie);
        return info.toString();
    }


    public boolean etreFini() {
        return personnage.equals(sortie);
    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FichierIncorrectException {

        BufferedReader buff = new BufferedReader(new FileReader(nom));
        Labyrinthe laby = new Labyrinthe();

        int x = Integer.parseInt(buff.readLine());
        int y = Integer.parseInt(buff.readLine());
        laby.murs = new boolean[y][x];

        boolean persoPlace = false, sortiePlace = false;
        String ligne;

        for (int i = 0; i < x; i++) {
            ligne = buff.readLine();

            if (ligne.length() > y) throw new FichierIncorrectException("nbLignes ne correspond pas");

            for (int j = 0; j < y; j++) {

                switch (ligne.charAt(j)) {
                    case 'S':
                        if (sortiePlace) throw new FichierIncorrectException("plusieurs sorties");
                        laby.sortie = new Sortie(j, i);
                        sortiePlace = true;
                        break;
                    case 'P':
                        if (persoPlace) throw new FichierIncorrectException("plusieurs personnages");
                        laby.personnage = new Personnage(j, i);
                        persoPlace = true;
                        break;
                    case 'X':
                        laby.murs[j][i] = true;
                        break;
                    case '.':
                        laby.murs[j][i] = false;
                        break;
                    default:
                        throw new FichierIncorrectException("caractere inconnu " + ligne.charAt(j));
                }
            }
        }

        if (!sortiePlace) throw new FichierIncorrectException("sortie inconnue");
        if (!persoPlace) throw new FichierIncorrectException("personnage inconnue");

        buff.close();
        return laby;
    }


}
