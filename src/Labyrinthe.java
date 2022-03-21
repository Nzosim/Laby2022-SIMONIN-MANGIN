import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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

    char getChar(int x, int y) {
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



    static int[] getSuivant(int x, int y, String action) {
        switch (action){
            case HAUT :
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
        int [] position = {x,y};
        return position;
    }


    void deplacerPerso(String action) throws ActionInconnueException {
        int y = this.personnage.getPosition_Y();
        int x = this.personnage.getPosition_X();

        while(!this.murs[y][x]){
            int[] coord = this.getSuivant(x, y, action);  
            if(!this.murs[coord[1]][coord[0]]){
                this.personnage.setPosition_Y(y+coord[1]);
                this.personnage.setPosition_X(x+coord[0]);
                y = this.personnage.getPosition_Y();
                x = this.personnage.getPosition_X();
            }
        }

    }


    public String toString() {
        String info = "";
        for (int i = 0; i<murs.){

        }
    }


    public boolean etreFini() {
        return personnage.equals(sortie);
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        try{
            BufferedReader buff = new BufferedReader(new FileReader(nom));
        }catch(FileNotFoundException e){
            
        }
    }

}
