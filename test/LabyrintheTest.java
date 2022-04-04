import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    @Test
    public void test_01_getChar_OK() throws FichierIncorrectException, IOException {
        // preparation des donnees
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //verifications
        assertEquals('X', l.getChar(0, 0), "Cela devrait etre un mur");
        assertEquals('S', l.getChar(1, 1), "Cela devrait etre la sortie");
        assertEquals('.', l.getChar(1, 2), "Cela devrait etre une case vide");
        assertEquals('P', l.getChar(2, 3), "Cela devrait etre le personnage");
    }

    @Test
    public void test_02_getSuivant_OK() throws ActionInconnueException {
        // preparation des donnees
        int x = 3;
        int y = 5;

        // methode a tester
        int[] haut = Labyrinthe.getSuivant(x, y, "haut");
        int[] bas = Labyrinthe.getSuivant(x, y, "bas");
        int[] gauche = Labyrinthe.getSuivant(x, y, "gauche");
        int[] droite = Labyrinthe.getSuivant(x, y, "droite");

        //verifications
        assertEquals(2, haut[0], "Cela devrait etre a 2");
        assertEquals(5, haut[1], "Cela devrait etre a 5");
        assertEquals(4, bas[0], "Cela devrait etre a 4");
        assertEquals(5, bas[1], "Cela devrait etre a 5");

        assertEquals(3, gauche[0], "Cela devrait etre a 3");
        assertEquals(4, gauche[1], "Cela devrait etre a 4");
        assertEquals(3, droite[0], "Cela devrait etre a 3");
        assertEquals(6, droite[1], "Cela devrait etre a 6");
    }

    @Test
    public void test_03_getSuivant_Exception() {
        // preparation des donnees
        int x = 3;
        int y = 5;
        assertThrows(ActionInconnueException.class, () -> Labyrinthe.getSuivant(x, y, "boo"));
    }

    @Test
    public void test_04_deplacerPerso_OK() throws FichierIncorrectException, IOException, ActionInconnueException {
        // preparation des donnees
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // methode a tester
        l.deplacerPerso("haut");

        //verifications
        assertEquals('P', l.getChar(1, 3), "Le personnage devrait etre en 1, 3");
        assertEquals('.', l.getChar(2, 3), "La case 2, 3 devrait etre vide");

        // methode a tester
        l.deplacerPerso("droite");

        //verifications
        assertEquals('P', l.getChar(1, 5), "Le personnage devrait etre en 5, 1");
        assertEquals('.', l.getChar(1, 3), "La case 3, 1 devrait etre vide");

        // methode a tester
        l.deplacerPerso("bas");

        //verifications
        assertEquals('P', l.getChar(3, 5), "Le personnage devrait etre en 5, 1");
        assertEquals('.', l.getChar(1, 5), "La case 3, 1 devrait etre vide");

        // methode a tester
        l.deplacerPerso("gauche");

        //verifications
        assertEquals('P', l.getChar(3, 1), "Le personnage devrait etre en 5, 1");
        assertEquals('.', l.getChar(3, 5), "La case 3, 1 devrait etre vide");

    }


    @Test
    public void test_05_etreFini_OK() throws FichierIncorrectException, IOException, ActionInconnueException {
        // preparation des donnees
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // methode a tester
        l.deplacerPerso("haut");
        l.deplacerPerso("gauche");

        //verifications
        // On verifie que le personnage est bien sur la sortie
        assertTrue(l.etreFini(), "La partie devrait etre finie");
    }

    @Test
    public void test_06_etreFini_avance() throws FichierIncorrectException, IOException, ActionInconnueException {
        // preparation des donnees
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // methode a tester
        l.deplacerPerso("haut");
        l.deplacerPerso("gauche");

        // Definition du labyrinthe
        // toString nous donne le x et y du labyrinthe
        String[] labyrinthe = l.toString().split("\n");

        // On verifie que le personnage est bien sur la sortie
        // donc toutes les autres lignes ne contienne que des '.'

        // On verifie la premiere ligne du labyrinthe
        assertEquals('P', l.getChar(1, 1), "Le personnage devrait etre en 1, 1");
        for (int i = 2; i < labyrinthe[1].length() - 1; i++) {
            assertEquals('.', l.getChar(1, i), "La case " + 1 + "," + i + " devrait etre vide");
        }

        // On verifie les autres lignes du labyrinthe
        for (int i = 2; i < labyrinthe.length - 1; i++) {
            for (int j = 1; j < labyrinthe[i].length() - 1; j++) {
                assertEquals('.', l.getChar(i, j), "La case " + i + "," + j + " devrait etre vide");
            }
        }

        // On verifie que le personnage est bien sur la sortie
        assertTrue(l.etreFini(), "La partie devrait etre finie");
    }

    @Test
    public void test_07_charge_OK() throws FichierIncorrectException, IOException {
        // preparation des donnees
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // methode a tester
        // Definition du labyrinthe
        // toString nous donne le x et y du labyrinthe
        String[] labyrinthe = l.toString().split("\n");

        // On verifie que le personnage est bien sur la sortie
        // donc toutes les autres lignes ne contienne que des '.'

        // On verifie la premiere ligne du labyrinthe
        assertEquals('S', l.getChar(1, 1), "La sortie devrait etre en 1, 1");
        for (int i = 2; i < labyrinthe[1].length() - 1; i++) {
            assertEquals('.', l.getChar(1, i), "La case " + 1 + "," + i + " devrait etre vide");
        }

        // On verifie les autres lignes du labyrinthe
        for (int i = 2; i < labyrinthe.length - 1; i++) {
            for (int j = 1; j < labyrinthe[i].length() - 1; j++) {
                if (i == 2 && j == 3) {
                    assertEquals('P', l.getChar(i, j), "La case " + i + "," + j + " devrait etre un personnage");
                } else {
                    assertEquals('.', l.getChar(i, j), "La case " + i + "," + j + " devrait etre vide");

                }
            }
        }

        // On verifie que le personnage est bien sur la sortie
        assertFalse(l.etreFini(), "La partie ne devrait pas etre finie");
    }
}