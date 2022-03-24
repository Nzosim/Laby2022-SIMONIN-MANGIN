import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe{
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
        if (murs[x][y]){
            res = MUR;
        }else if (personnage.equals(y,x)){
            res = PJ;
        }else if (sortie.equals(y,x)){
            res = SORTIE;
        }else{
            res = VIDE;
        }
        return res;
    }



    public static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT :
                x--;
                break;
            case BAS :
                x++;
                break;
            case GAUCHE :
                y--;
                break;
            case DROITE :
                y++;
                break;
        }
        return new int[]{x,y};
    }


    public void deplacerPerso(String action) {
        int y = this.personnage.getPosition_Y();
        int x = this.personnage.getPosition_X();

        while(!this.murs[y][x]){
            int[] coord = getSuivant(x, y, action);
            x = coord[0];
            y = coord[1];
            if(!this.murs[coord[1]][coord[0]]){
                this.personnage.setPosition_Y(coord[1]);
                this.personnage.setPosition_X(coord[0]);
                y = this.personnage.getPosition_Y();
                x = this.personnage.getPosition_X();
            }
        }
    }


    public String toString() {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i<murs.length; i++){
            for (int j = 0; j < murs[i].length; j++){
                if (murs[i][j]){
                    info.append(MUR);
                }else{
                    info.append(getChar(i,j));
                }
            }
            info.append("\n");
        }
        System.out.println(info);
        return info.toString();
    }


    public boolean etreFini() {
        return personnage.equals(sortie);
    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FichierIncorrectException {

            BufferedReader buff = new BufferedReader(new FileReader(nom));
            Labyrinthe laby = new Labyrinthe();

            int y = Integer.parseInt(buff.readLine());
            int x = Integer.parseInt(buff.readLine());
            laby.murs = new boolean[x][y];

            boolean persoPlace = false, sortiePlace = false;
            String ligne;

            for(int i = 0 ; i < y ; i++) {
                ligne = buff.readLine();

                if (ligne.length() > x) throw new FichierIncorrectException("nbLignes ne correspond pas");

                for (int j = 0; j < y; j++) {

                    switch (ligne.charAt(j)) {
                        case 'S':
                            if (sortiePlace) throw new FichierIncorrectException("plusieurs sorties");
                            laby.sortie = new Sortie(i, j);
                            sortiePlace = true;
                            break;
                        case 'P':
                            if (persoPlace) throw new FichierIncorrectException("plusieurs personnages");
                            laby.personnage = new Personnage(i, j);
                            persoPlace = true;
                            break;
                        case 'X':
                            laby.murs[i][j] = true;
                            break;
                        case '.':
                            laby.murs[i][i] = false;
                            break;
                        default:
                            throw new FichierIncorrectException("caractere inconnu " + ligne.charAt(j));
                    }
                }
            }

        if(!sortiePlace) throw new FichierIncorrectException("sortie inconnue");
        if(!persoPlace) throw new FichierIncorrectException("personnage inconnue");

        buff.close();
        return laby;
    }

}
