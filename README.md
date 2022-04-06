## [SIMONIN ENZO](https://github.com/Nzosim)  ///  [MANGIN FLORIAN](https://github.com/Flotss) [S2A]
#### Difficultés rencontrées au cours du TP :

> La principale difficulté que nous avons rencontré sur la compréhension de l'énoncé,
> nous avons compris que les coordonnées y et x était inversé donc nous avons du tout remettre dans le bon ordre,
> ce qui a été assez long de compréhension.

### Nos choix de programmation :

> Nous avons choisi de ne pas faire de constructeur dans la classe Labyrinthe, grâce à notre méthode chargerLabyrinthe
> qui est une méthode static et on peut donc être utilisé sans objet. Cela nous permet donc d'initialiser totalement un labyrinthe seulement
> avec la méthode chargerLabyrinthe

### — Comment télécharger et lancer le labyrinthe :

- Ouvrez un terminal de commande à l'emplacement voulu pour le dossier et tapez la commande :
  <br>`git clone git@github.com:Nzosim/Laby2022-SIMONIN-MANGIN.git`


- Ouvrez le dossier qui vient d'être téléchargé grâce à un éditeur de code (IntelliJ, VisualStudio, ...)


- Vous devez compiler le programme avant de le lancer, pour cela ouvrez le terminal et tapez la commande :
  <br>`javac src/*.java`


- Lancer le programme grâce à la commande :
  <br>`java src/MainLaby.java`

### — [Comment lancer nos tests :](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/test/LabyrintheTest.java)

#### Il faut avoir effectué les étapes 1 et 2 pour pouvoir lancer les tests.

> 1 : Dans le terminal, tapez la commande :
`javac test/LabyrintheTest.java`

> 2 : Lancer le programme grâce à la commande :
`java test/LabyrintheTest`

### — Résulat de nos tests :

> Nous avons abordé l'ensemble des tests possible en passant du test basique de méthode jusqu'aux tests
> d'exception nous avons au total : **16** tests qui sont tous validés.

### — Nos tests : [LabyrintheTest.java](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/test/LabyrintheTest.java)

#### Pour les tests 1, 4, 5, 6, 7 nous avons utilisé le fichier [laby0.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby0.txt) pour faire les tests où les exceptions ne sont pas verifier.

1) [test_01_getChar_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L15)
   permet de tester la méthode getChar() de la classe Labyrinthe cette méthode retourne la caractère présent à la
   position (x,y) dans le labyrinthe
    - **a)** tester si la position au coordonnées (0,0) contient bien le caractère 'X' qui est un **mur**
    - **b)** tester si la position au coordonnées (1,1) contient bien le caractère 'S' qui est la **sortie**
    - **c)** tester si la position au coordonnées (1,2) contient bien le caractère '.' qui est une case **vide**
    - **d)** tester si la position au coordonnées (2,3) contient bien le caractère 'P' qui est le **personnage**

2) [test_02_getSuivant_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L31)
   permet de tester la méthode getSuivant() de la classe Labyrinthe cette méthode retourne la position du personnage
   après avoir effectué une action
    - **a)** tester la position du personnage après l'action haut depuis la position (3,5) qui doit maintenant être (
      2,5)
    - **b)** tester la position du personnage après l'action bas depuis la position (2,5) qui doit maintenant être (4,5)
    - **c)** tester la position du personnage après l'action gauche depuis la position (4,5) qui doit maintenant être (
      3,4)
    - **d)** tester la position du personnage après l'action droite depuis la position (3,4) qui doit maintenant être (
      3,6)

3) [test_03_getSuivant_Exception](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L58)
   permet de tester la méthode getSuivant() de la classe Labyrinthe a/ tester la position du personnage après un action
   inconnue depuis la position (3,5) qui ne doit pas changer

4) [test_04_deplacerPerso_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L77)
   permet de tester la méthode deplacerPerso() de la classe Labyrinthe cette méthode permet de déplacer le personnage
   dans la direction indiquée jusqu'à rencontrer un mur
    - **a)** tester si le personnage est bien placé à la position (1,3) après avoir effectué une action haut et que son
      ancienne case (2,3) est bien vide
    - **b)** tester si le personnage est bien placé à la position (1,5) après avoir effectué une action droite et que
      son ancienne case (1,3) est bien vide
    - **c)** tester si le personnage est bien placé à la position (3,5) après avoir effectué une action bas et que son
      ancienne case (1,5) est bien vide
    - **d)** tester si le personnage est bien placé à la position (3,1) après avoir effectué une action gauche et que
      son ancienne case (3,5) est bien vide

5) [test_05_etreFini_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L118)
   permet de tester la méthode etreFini() de la classe Labyrinthe cette méthode permet de savoir si le personnage est
   arrivé à la sortie
    - **a)** tester si le personnage est arrivé à la sortie après avoir effectué l'action haut et gauche

6) [test_06_etreFini_avance]((https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L138))
   permet de tester la méthode etreFini() de la classe Labyrinthe cette méthode permet de savoir si le personnage est
   arrivé à la sortie ce test reprend le test précédent mais en vérifiant la place de chaque cas après avoir effectué
   une action

7) [test_07_charge_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L176)
   permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe cette méthode permet de tester si la méthode
   chargerLabyrinthe fonctionne correctement avec la labyrinthe laby0.txt

Utilisation du
fichier [laby_deuxPersonnage.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_deuxPersonnage.txt)

8) [test_08_charge_2_personnages](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L215)
   permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe cette méthode permet de tester si la méthode
   chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient plusieurs
   personnages

Utilisation du
fichier [laby_SansPersonnage.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_SansPersonnage.txt)

9) [test_09_charge_0_personnages](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L230)
   permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe cette méthode permet de tester si la méthode
   chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient aucun personnage

Utilisation du
fichier [laby_deuxSortie.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_deuxSortie.txt)

10) [test_10_charge_2_sorties](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L245)
    permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe cette méthode permet de tester si la méthode
    chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient plusieurs sorties

Utilisation du
fichier [laby_SansSortie.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_SansSortie.txt)

11) [test_11_charge_0_sorties](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L260)
    permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe cette méthode permet de tester si la méthode
    chargerLabyrinthe lève une exception de type FichierIncorrectException si le labyrinthe contient aucune sortie

Utilisation du
fichier [laby_2PremieresValeursNaN](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_2PremieresValeurNaN.txt)

12) [test_12_charge_valeur_nb_lignes_invalide](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L275)
    permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe cette méthode permet de tester si la méthode
    chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas
    le nombre de lignes et de colonnes dans les 2 premières lignes de son fichier

Utilisation du
fichier [laby_ligneEnPlus.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_ligneEnPlus.txt)

13) [test_13_charge_ligne_en_trop](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L291)
    permet de tester la méthode chargerLabyrinthe() de la classe Labyrinthe cette méthode permet de tester si la méthode
    chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas
    le nombre de lignes indiqués dans la premières ligne du fichier, qu'il contienne plus de ligne qu'indiqué

Utilisation du
fichier [laby_ligneEnMoins.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_ligneEnMoins.txt)

14) [test_14_charge_ligne_en_moins](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L306)
    permet de tester la méthode chargerLabyrinth() de la classe Labyrinthe cette méthode permet de tester si la méthode
    chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas
    le nombre de lignes indiqués dans la premières ligne du fichier, qu'il contienne moins de ligne qu'indiqué

Utilisation du
fichier [laby_colonneIncorrect.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_colonneIncorrect.txt)

15) [test_15_charge_colonne_incorrect](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L321)
    permet de tester la méthode chargerLabyrinth() de la classe Labyrinthe cette méthode permet de tester si la méthode
    chargerLabyrinthe lève une exception de type FichierIncorrectException si le fichier du labyrinthe ne contient pas
    le bon nombre de caractères par colonnes

Utilisation du
fichier [laby_caractereInconnu.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_caractereInconnu.txt)

16) [test_16_charge_caractere_inconnu](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/6209d5d168c8e05963417bd7abeeba09f7ea7ddc/test/LabyrintheTest.java#L336)
    permet de tester la méthode chargerLabyrinth() de la classe Labyrinthe cette méthode permet de tester si la méthode
    chargerLabyrinthe lève une exception de type FichierIncorrectException si un caractère du labyrinthe est inconnue
