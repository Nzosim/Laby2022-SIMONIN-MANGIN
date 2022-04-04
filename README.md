## SIMONIN ENZO  ///  MANGIN FLORIAN

### - difficultés rencontrées au cours du TP :
    la principale difficultés rencontrées est dû au fait que dans l'énoncé
    les coordonnées 'x' et 'y' sont inversées, par rapport au cour et au TP précédent.

### - nos choix de programmation :
    idk

### - comment télécharger et lancer le labyrinthe :
    1) ouvrez un terminal de commande à l'emplacement voulu pour le dossier et tapez la commande :
        git clone git@github.com:Nzosim/Laby2022-SIMONIN-MANGIN.git

    2) ouvrez le dossier qui vien d'être téléchargé grâce à un éditeur de code (IntelliJ, VisualStudio, ...)

    3) il va falloir compiler le programme avant de le lancer pour cela ouvrez le terminal et tapez la commande :
        javac src/*.java
    
    4) lancer le programme grâce à la commande :
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


