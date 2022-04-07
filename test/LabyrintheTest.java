import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    /**
     * test numero 1 qui test si la methode getChar fonctionne correctement
     * @throws FichierIncorrectException
     * @throws IOException
     */
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

    /**
     * test numero 2 qui test si la methode getSuivant fonctionne correctement
     * @throws ActionInconnueException
     */
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

    /**
     * test numero 3 qui test si la methode getSuivant leve une exception si l'action est inconnue
     */
    @Test
    public void test_03_getSuivant_Exception() {
        // preparation des donnees
        int x = 3;
        int y = 5;

        // methode a tester
        // getSuivant

        // verifications
        assertThrows(ActionInconnueException.class, () -> Labyrinthe.getSuivant(x, y, "boo"));
        try {
            Labyrinthe.getSuivant(x, y, "boo");
        } catch (ActionInconnueException e) {
            assertEquals("ActionInconnueException : boo", e.getMessage(), "Action InconnueException : boo");
        }
    }

    /**
     * test numero 4 qui test si la methode deplacerPerso fonctionne correctement
     * @throws FichierIncorrectException
     * @throws IOException
     * @throws ActionInconnueException
     */
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

    /**
     * test numero 5 qui test si la methode etreFini leve une exception si l'action est inconnue
     * @throws FichierIncorrectException
     * @throws IOException
     * @throws ActionInconnueException
     */
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

    /**
     * test numero 6 qui test si la methode etreFini de maniere plus developpe
     * @throws FichierIncorrectException
     * @throws IOException
     * @throws ActionInconnueException
     */
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

    /**
     * test numero 7 qui test si la methode charge fonctionne correctement
     * @throws FichierIncorrectException
     * @throws IOException
     */
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

    /**
     * test numero 8 qui test si la methode charge leve une exception lorsqu il y a 2 personnages dans le labyrinthe
     * @throws IOException
     */
    @Test
    public void test_08_charge_2_personnages() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_deuxPersonnage.txt"));
        try{
            Labyrinthe.chargerLabyrinthe("laby/laby_deuxPersonnage.txt");
        }catch(FichierIncorrectException e){
            assertEquals(e.getMessage(), "FichierIncorrectException : plusieurs personnages", "L'exception plusieurs personnages devrait etre levée");
        }
    }

    /**
     * test numero 9 qui test si la methode charge leve une exception lorsqu il n y a pas de personnage dans le labyrinthe
     * @throws IOException
     */
    @Test
    public void test_09_charge_0_personnages() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_SansPersonnage.txt"));
        try{
            Labyrinthe.chargerLabyrinthe("laby/laby_SansPersonnage.txt");
        }catch(FichierIncorrectException e){
            assertEquals(e.getMessage(), "FichierIncorrectException : personnage inconnu", "L'exception aucun personnages devrait etre levée");
        }
    }

    /**
     * test numero 10 qui test si la methode charge leve une exception lorsqu il y a plusieurs sorties dans le labyrinthe
     * @throws IOException
     */
    @Test
    public void test_10_charge_2_sorties() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_deuxSortie.txt"));
        try{
            Labyrinthe.chargerLabyrinthe("laby/laby_deuxSortie.txt");
        }catch(FichierIncorrectException e){
            assertEquals(e.getMessage(), "FichierIncorrectException : plusieurs sorties","L'exception plusieurs sorties devrait etre levée");
        }
    }

    /**
     * test numero 11 qui test si la methode charge leve une exception lorsqu il n y a pas de sortie dans le labyrinthe
     * @throws IOException
     */
    @Test
    public void test_11_charge_0_sorties() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt"));
        try{
            Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt");
        }catch(FichierIncorrectException e){
            assertEquals(e.getMessage(), "FichierIncorrectException : sortie inconnue", "L'exception aucune sortie devrait etre levée");
        }
    }

    /**
     * test numero 12 qui test si la methode charge leve une exception lorsque les lignes du debut du fichier labyrinthe lu
     * qui correspondent au nombre de lignes et de colonnes est invalide
     * @throws IOException
     */
    @Test
    public void test_12_charge_valeur_nb_lignes_invalide() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_2PremieresValeurNaN.txt"));
        try {
            Labyrinthe.chargerLabyrinthe("laby/laby_2PremieresValeurNaN.txt");
        } catch (FichierIncorrectException e) {
            assertEquals(e.getMessage(), "FichierIncorrectException : pb num ligne ou colonne", "L'exception caractère non nombre devrait etre levee");
        }
    }

    /**
     * test numero 13 qui test si la methode charge leve une exception lorsqu une ligne est plus grande que la valeur inscrite en debut de fichier
     * @throws IOException
     */
    @Test
    public void test_13_charge_ligne_en_trop() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_ligneEnPlus.txt"));
        try {
            Labyrinthe.chargerLabyrinthe("laby/laby_ligneEnPlus.txt");
        } catch (FichierIncorrectException e) {
            assertEquals(e.getMessage(), "FichierIncorrectException : nbLignes ne correspond pas", "L'exception FichierIncorectException : Le nombre de ligne ne correspond pas devrait etre levee");
        }
    }

    /**
     * test numero 14 qui test si la methode charge leve une exception lorsqu une ligne est plus petite que la valeur inscrite en debut de fichier
     * @throws IOException
     */
    @Test
    public void test_14_charge_ligne_en_moins() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_ligneEnMoins.txt"));
        try {
            Labyrinthe.chargerLabyrinthe("laby/laby_ligneEnMoins.txt");
        } catch (FichierIncorrectException e) {
            assertEquals(e.getMessage(), "FichierIncorrectException : nbLignes ne correspond pas", "L'exception FichierIncorectException : Le nombre de ligne ne correspond pas devrait etre levée");
        }
    }

    /**
     * test numero 15 qui test si la methode charge leve une exception lorsque le nombre de colonne est plus grand ou plus petit que la valeur inscrite en debut de fichier
     * @throws IOException
     */
    @Test
    public void test_15_charge_colonne_incorrect() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_colonneIncorrect.txt"));
        try {
            Labyrinthe.chargerLabyrinthe("laby/laby_colonneIncorrect.txt");
        } catch (FichierIncorrectException e) {
            assertEquals(e.getMessage(), "FichierIncorrectException : nbColonnes ne correspond pas", "L'exception FichierIncorectException : Le nombre de colonne ne correspond pas devrait être levée");
        }
    }

    /**
     * test numero 16 qui test la methode charge lorsque le labyrinthe contient un caractère autre que '.', 'X', 'S' ou 'P'
     * @throws IOException
     */
    @Test
    public void test_16_charge_caractere_inconnu() throws IOException {
        // verification
        assertThrows(FichierIncorrectException.class, () -> Labyrinthe.chargerLabyrinthe("laby/laby_caractereInconnu.txt"));
        try {
            Labyrinthe.chargerLabyrinthe("laby/laby_caractereInconnu.txt");
        } catch (FichierIncorrectException e) {
            assertEquals(e.getMessage(), "FichierIncorrectException : caractere inconnu E", "L'exception FichierIncorectException : Caractere inconnu  devrait être levée");
        }
    }

    /**
     * test numero 17 qui test la methode deplacerPerso lorsque le personnage rencontre une sortie
     *
     * @throws IOException
     * @throws FichierIncorrectException
     * @throws ActionInconnueException
     */
    @Test
    public void test_17_deplacerPerso_rencontre_sortie() throws IOException, FichierIncorrectException, ActionInconnueException {
        // preparation des donnees
        Labyrinthe laby = Labyrinthe.chargerLabyrinthe("laby/laby2.txt");

        // methode a tester
        laby.deplacerPerso("haut");

        // verification
        assertEquals(laby.getChar(1, 17), 'P', "La position du perso devrait etre (1,17)");
        assertFalse(laby.etreFini(), "Le labyrinthe devrait pas etre fini");
    }
}