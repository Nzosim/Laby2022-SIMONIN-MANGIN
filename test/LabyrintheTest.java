import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    @Test
    public void test_01_getChar_OK() throws FichierIncorrectException, IOException {
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        assertEquals('X', l.getChar(0,0), "Cela devrait etre un mur");
        assertEquals('S', l.getChar(1,1), "Cela devrait etre la sortie");
        assertEquals('.', l.getChar(1,2), "Cela devrait etre une case vide");
        assertEquals('P', l.getChar(2,3), "Cela devrait etre le personnage");
    }

    @Test
    public void test_02_getSuivant_OK(){
        int x = 3;
        int y = 5;
        int [] haut = Labyrinthe.getSuivant(x,y,"haut");
        int [] bas = Labyrinthe.getSuivant(x,y,"bas");
        int [] gauche = Labyrinthe.getSuivant(x,y,"gauche");
        int [] droite = Labyrinthe.getSuivant(x,y,"droite");

        assertEquals(2,haut[0], "Cela devrait etre a 2");
        assertEquals(5, haut[1], "Cela devrait etre a 5");
        assertEquals(4, bas[0], "Cela devrait etre a 4");
        assertEquals(5, bas[1], "Cela devrait etre a 5");

        assertEquals(3, gauche[0], "Cela devrait etre a 3");
        assertEquals(4, gauche[1], "Cela devrait etre a 4");
        assertEquals(3, droite[0], "Cela devrait etre a 3");
        assertEquals(6, droite[1], "Cela devrait etre a 6");
    }

    @Test
    public void test_03_deplacerPerso_OK() throws FichierIncorrectException, IOException {
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        l.deplacerPerso("haut");
        System.out.println(l);
        assertEquals('P', l.getChar(1,3), "Le personnage devrait etre en 1, 3");
        assertEquals('.', l.getChar(2,3), "La case 2, 3 devrait etre vide");

        l.deplacerPerso("droite");
        assertEquals('P', l.getChar(1,5), "Le personnage devrait etre en 5, 1");
        assertEquals('.', l.getChar(1,3), "La case 3, 1 devrait etre vide");

        l.deplacerPerso("bas");
        assertEquals('P', l.getChar(3,5), "Le personnage devrait etre en 5, 1");
        assertEquals('.', l.getChar(1,5), "La case 3, 1 devrait etre vide");

        l.deplacerPerso("gauche");
        assertEquals('P', l.getChar(3,1), "Le personnage devrait etre en 5, 1");
        assertEquals('.', l.getChar(3,5), "La case 3, 1 devrait etre vide");
    }

}