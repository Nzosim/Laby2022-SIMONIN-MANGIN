## SIMONIN ENZO  ///  MANGIN FLORIAN

### Difficultés rencontrées au cours du TP :

    > La principale difficultés ont été rencontré sur la comprenhension de l'énoncé, 
    > nous avons compris que les coordonnées y et x était inversé donc nous avons dù tout remettre
    > dans le bon ordre, ce qui a été assez long de compréhension.

### - nos choix de programmation :

    idk

### - comment télécharger et lancer le labyrinthe :

- ouvrez un terminal de commande à l'emplacement voulu pour le dossier et tapez la commande :
  `git clone git@github.com:Nzosim/Laby2022-SIMONIN-MANGIN.git`


- ouvrez le dossier qui vien d'être téléchargé grâce à un éditeur de code (IntelliJ, VisualStudio, ...)


- il va falloir compiler le programme avant de le lancer pour cela ouvrez le terminal et tapez la commande :
  javac src/*.java


- lancer le programme grâce à la commande :
  java src/MainLaby.java

### — [comment lancer nos tests :](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/test/LabyrintheTest.java)

    - il faut avoir effectué les étapes 1 et 2 grâce à l'étape précédente 
    
    1) dans le terminal, tapez la commande :
        javac test/LabyrintheTest.java

    2) lancer le programme grâce à la commande :
        java test/LabyrintheTest

### - résulat de nos tests :
    la totalités de nos tests fonctionne correctement

### — [nos tests :](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/test/LabyrintheTest.java)
    - tout nos tests sont effectues avec la labyrinthe de test : labyO.txt

    1) test_01_getChar_OK permet de tester la méthode getChar() de la classe Labyrinthe
        cette méthode retourne la caractère présent à la position (x,y) dans le labyrinthe
        a/ tester si la position au coordonnées (0,0) contient bien le caractère 'X' qui est un mur
        b/ tester si la position au coordonnées (1,1) contient bien le caractère 'S' qui est la sortie
        c/ tester si la position au coordonnées (1,2) contient bien le caractère '.' qui est une case vide
        d/ tester si la position au coordonnées (2,3) contient bien le caractère 'P' qui est le personnage

    2) test_02_getSuivant_OK permet de tester la méthode getSuivant() de la classe Labyrinthe
        cette méthode retourne la position du personnage après avoir effectué une action
        a/ tester la position du personnage après l'action haut depuis la position (3,5) qui doit maintenant être (2,5)
        b/ tester la position du personnage après l'action bas depuis la position (2,5) qui doit maintenant être (4,5)
        c/ tester la position du personnage après l'action gauche depuis la position (4,5) qui doit maintenant être (3,4)
        d/ tester la position du personnage après l'action droite depuis la position (3,4) qui doit maintenant être (3,6)

    3) test_03_getSuivant_Exception() permet de tester la méthode getSuivant() de la classe Labyrinthe 
        a/ tester la position du personnage après un action inconnue depuis la position (3,5) qui ne doit pas changer

    4) test_04_deplacerPerso_OK() permet de tester la méthode deplacerPerso() de la classe Labyrinthe
        cette méthode permet de déplacer le personnage dans la direction indiquée jusqu'à rencontrer un mur
        a/ tester si le personnage est bien placé à la position (1,3) après avoir effectué une action haut et que son ancienne case (2,3) est bien vide
        b/ tester si le personnage est bien placé à la position (1,5) après avoir effectué une action droite et que son ancienne case (1,3) est bien vide
        c/ tester si le personnage est bien placé à la position (3,5) après avoir effectué une action bas et que son ancienne case (1,5) est bien vide
        d/ tester si le personnage est bien placé à la position (3,1) après avoir effectué une action gauche et que son ancienne case (3,5) est bien vide

    5) test_05_etreFini_OK() permet de tester la méthode etreFini() de la classe Labyrinthe
        cette méthode permet de savoir si le personnage est arrivé à la sortie
        a/ tester si le personnage est arrivé à la sortie après avoir effectué l'action haut et gauche

    6) test_06_etreFini_avance() permet de tester la méthode etreFini() de la classe Labyrinthe
        cette méthode permet de savoir si le personnage est arrivé à la sortie
        ce test reprend le test précédent mais en vérifiant la place de chaque cas après avoir effectué une action

    7) test_07_charge_OK permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe fonctionne correctement avec la labyrinthe laby0.txt

    8) test_08_charge_2_personnages permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient plusieurs personnages

    9) test_09_charge_0_personnages permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient aucun personnage

    10) test_10_charge_2_sorties permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient plusieurs sorties

    11) test_11_charge_0_sorties permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient aucune sortie
    
    12) test_12_charge_valeur_nb_lignes_invalide permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas le nombre de lignes et de colonnes dans les 2 premières lignes de son fichier
    
    13) test_13_charge_ligne_en_trop permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas le nombre de lignes indiqués dans la premières ligne du fichier, qu'il contienne plus de ligne qu'indiqué

    14) test_14_charge_ligne_en_moins permet de tester la méthode chargerLabyrinth() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas le nombre de lignes indiqués dans la premières ligne du fichier, qu'il contienne moins de ligne qu'indiqué

    15) test_15_charge_colonne_incorrect permet de tester la méthode chargerLabyrinth() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas le bon nombre de caractères par colonnes
    
    16) test_16_charge_caractere_inconnu permet de tester la méthode chargerLabyrinth() de la classe Labyrinthe
        cette méthode permet de tester si la méthode chargerLabyrinthe lève une exception de type FichierIncorrectException si un caractère du labyrinthe est inconnue
