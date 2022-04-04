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
