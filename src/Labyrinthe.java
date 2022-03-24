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
            case HAUT : x--;
            case BAS : x++;
            case GAUCHE : y--;
            case DROITE : y++;
        }
        return new int[]{x,y};
    }


    public void deplacerPerso(String action) {
        int y = this.personnage.getPosition_Y();
        int x = this.personnage.getPosition_X();

        while(!this.murs[y][x]){
            int[] coord = getSuivant(x, y, action);
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
                if (murs[j][i]){
                    info.append(MUR);
                }else{
                    char temp = getChar(j,i);
                    switch (temp){
                        case PJ :
                            info.append(PJ);
                            break;
                        case SORTIE:
                            info.append(SORTIE);
                        case VIDE:
                            info.append(VIDE);
                    }
                }
            }
            info.append("\n");
        }
        return info.toString();
    }


    public boolean etreFini() {
        return personnage.equals(sortie);
    }

    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException, FileNotFoundException, FichierIncorrectException {
            BufferedReader buff = new BufferedReader(new FileReader(nom));
            Labyrinthe laby = new Labyrinthe();
            String ligne;

            int y = Integer.parseInt(buff.readLine());
            int x = Integer.parseInt(buff.readLine());

            laby.murs = new boolean[x][y];

            boolean persoPlace = false, sortiePlace = false;
            int ligneEnCour = 0;
            while((ligne = buff.readLine()) != null){
                if(ligne.length() > x) throw new FichierIncorrectException("nbLignes ne correspond pas");
                if(ligneEnCour > y) throw new FichierIncorrectException("nbColonnes ne correspond pas");
                for(int i = 0 ; i < ligne.length() ; i++){
                    if(ligne.charAt(i) == 'S'){
                        if(sortiePlace) throw new FichierIncorrectException("plusieurs sorties");
                        laby.sortie = new Sortie(ligneEnCour,i);
                        sortiePlace = true;
                    }else if(ligne.charAt(i) == 'P'){
                        if(sortiePlace) throw new FichierIncorrectException("plusieurs personnages");
                        laby.personnage = new Personnage(ligneEnCour,i);
                        persoPlace = true;
                    }else if(ligne.charAt(i) == 'X'){
                        laby.murs[ligneEnCour][i] = true;
                    }else if(ligne.charAt(i) == '.'){
                        laby.murs[ligneEnCour][i] = false;
                    }else{
                        throw new FichierIncorrectException("caractere inconnu "+ligne.charAt(i));
                    }
                }
                ligneEnCour ++;
            }

            if(!sortiePlace) throw new FichierIncorrectException("sortie inconnue");
            if(!persoPlace) throw new FichierIncorrectException("personnage inconnue");

            buff.close();
            return laby;
    }

}
