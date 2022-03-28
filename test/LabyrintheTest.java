import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    @Test
    public void test_01_getChar() throws FichierIncorrectException, IOException {
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        assertEquals('X', l.getChar(0,0), "Cela devrait etre un mur");
        assertEquals('S', l.getChar(1,1), "Cela devrait etre la sortie");
        assertEquals('.', l.getChar(1,2), "Cela devrait etre une case vide");
        assertEquals('P', l.getChar(3,2), "Cela devrait etre le personnage");
    }

    /*
    @Test
    public void test_02_getSuivant_OK(){
        int x = 4;
        int y = 10;
        int [] haut = Labyrinthe.getSuivant(x,y,"haut");
        int [] bas = Labyrinthe.getSuivant(x,y,"bas");
        int [] gauche = Labyrinthe.getSuivant(x,y,"gauche");
        int [] droite = Labyrinthe.getSuivant(x,y,"droite");

        assertEquals(3,haut[0], "Cela devrait etre a 10");
        assertEquals(10, haut[1], "Cela devrait etre a 10");
        assertEquals(5, bas[0], "Cela devrait etre a 5");
        assertEquals(10, bas[1], "Cela devrait etre a 10");

        assertEquals(4, gauche[0], "Cela devrait etre a 4");
        assertEquals(9, gauche[1], "Cela devrait etre a 9");
        assertEquals(4, droite[0], "Cela devrait etre a 4");
        assertEquals(11, droite[1], "Cela devrait etre a 11");
    }
*/

}