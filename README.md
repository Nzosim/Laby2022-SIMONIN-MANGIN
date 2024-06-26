## [SIMONIN ENZO](https://github.com/Nzosim)  ///  [MANGIN FLORIAN](https://github.com/Flotss) [S2A]
#### Difficultés rencontrées au cours du TP :

> La principale difficulté que nous avons rencontré sur la compréhension de l'énoncé,
> nous avons compris que les coordonnées y et x était inversé donc nous avons du tout remettre dans le bon ordre,
> ce qui a été assez long, mais aussi long de compréhension.

### Nos choix de programmation :

> Nous avons choisi de ne pas faire de constructeur dans la classe Labyrinthe, grâce à notre méthode chargerLabyrinthe
> qui est une méthode static et on peut donc être utilisé sans objet. Cela nous permet donc d'initialiser totalement un labyrinthe seulement
> avec la méthode chargerLabyrinthe
>
> Durant la conception nous avons choisi de créer de nouveaux fichiers de labyrinthe, et ainsi tester toutes les possiblités d'erreurs
> lorsque l'on charge un labyrinthe
>
> Nous avons choisi d'utiliser des messages personnalisé dans les exceptions, pour pourvoir plus facilement les comprendre les types d'erreurs
> mais aussi pour pouvoir les tester plus facilement.
>
> Lorsque l'on parametre le message d'une exception, nous avons décider de mettre le nom de la classe de l'exception aussi dans le message
> c'est pourquoi le message ressemble à ceci : <br> Pour FichierIncorrectException : "FichierIncorrectException : [Le message]"

### — Comment télécharger et lancer le labyrinthe :

- Ouvrez un terminal de commande à l'emplacement voulu pour le dossier et tapez la commande :
  <br>`git clone git@github.com:Nzosim/Laby2022-SIMONIN-MANGIN.git`


- Ouvrez le dossier qui vient d'être téléchargé grâce à un éditeur de code (IntelliJ, VisualStudio, ...)


- Vous devez compiler le programme avant de le lancer, pour cela ouvrez le terminal et tapez la commande :
  <br>`javac src/*.java`


- Lancer le programme grâce à la commande :
  <br>`java src/MainLaby.java laby/<nom du fichier>`

### — [Comment lancer nos tests :](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/test/LabyrintheTest.java)

 - Pour pouvoir lancer les tests il faudra télécharger JUnit 5.8.1 à partir de IntelliJ
 - Ensuite vous n'avez qu'à executer le fichier `LabyrintheTest.java` avec IntelliJ 

### Résulat de nos tests :

> Nous avons abordé l'ensemble des tests possible en passant du test basique de méthode jusqu'aux tests
> d'exceptions, nous avons un total de **17** tests qui sont tous validés.

### Nos tests : [LabyrintheTest.java](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/test/LabyrintheTest.java)

#### Pour les tests 1, 4, 5, 6, 7 nous avons utilisé le fichier [laby0.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby0.txt) pour faire les tests où les exceptions ne sont pas à verifier.

Pour tester les exceptions que renvoie les méthodes de la classe Labyrinthe, nous utilisons des Exceptions que l'on a
créé voici les deux fichiers exceptions que nous avons créé :
<br>[ActionInconnueException.java](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/src/ActionInconnueException.java)
, [FichierIncorrectException.java](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/src/FichierIncorrectException.java)

1) [test_01_getChar_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L15)
   permet de tester la méthode `getChar()` de la classe Labyrinthe cette méthode retourne le caractère présent à la
   position (x,y) dans le labyrinthe
    - **a)** tester si la position au coordonnées (0,0) contient bien le caractère 'X' qui est un **mur**
    - **b)** tester si la position au coordonnées (1,1) contient bien le caractère 'S' qui est la **sortie**
    - **c)** tester si la position au coordonnées (1,2) contient bien le caractère '.' qui est une case **vide**
    - **d)** tester si la position au coordonnées (2,3) contient bien le caractère 'P' qui est le **personnage**

2) [test_02_getSuivant_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L31)
   permet de tester la méthode `getSuivant()` de la classe Labyrinthe cette méthode retourne la position du personnage
   après avoir effectué une action
    - **a)** tester la position du personnage après l'action haut depuis la position (3,5) qui doit maintenant être (
      2,5)
    - **b)** tester la position du personnage après l'action bas depuis la position (2,5) qui doit maintenant être (4,5)
    - **c)** tester la position du personnage après l'action gauche depuis la position (4,5) qui doit maintenant être (
      3,4)
    - **d)** tester la position du personnage après l'action droite depuis la position (3,4) qui doit maintenant être (
      3,6)

3) [test_03_getSuivant_Exception](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L58)
   permet de tester la méthode `getSuivant()` de la classe Labyrinthe cette méthode permet de tester si la méthode
   getSuivant lève bien une exception de type `ActionInconnueException` si l'action n'est pas reconnue, ici nous testons
   l'action 'boo' qui n'est pas reconnue donc et a pour message :
   `"Action inconnue : boo"`


4) [test_04_deplacerPerso_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L82)
   permet de tester la méthode `deplacerPerso()` de la classe Labyrinthe cette méthode permet de déplacer le personnage
   dans la direction indiquée jusqu'à rencontrer un mur
    - **a)** tester si le personnage est bien placé à la position (1,3) après avoir effectué une action haut et que son
      ancienne case (2,3) est bien vide
    - **b)** tester si le personnage est bien placé à la position (1,5) après avoir effectué une action droite et que
      son ancienne case (1,3) est bien vide
    - **c)** tester si le personnage est bien placé à la position (3,5) après avoir effectué une action bas et que son
      ancienne case (1,5) est bien vide
    - **d)** tester si le personnage est bien placé à la position (3,1) après avoir effectué une action gauche et que
      son ancienne case (3,5) est bien vide

5) [test_05_etreFini_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L123)
   permet de tester la méthode `etreFini()` de la classe Labyrinthe cette méthode permet de savoir si le personnage est
   arrivé à la sortie
    - **a)** tester si le personnage est arrivé à la sortie après avoir effectué l'action haut et gauche

6) [test_06_etreFini_avance](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L143)
   permet de tester la méthode `etreFini()` de la classe Labyrinthe cette méthode permet de savoir si le personnage est
   arrivé à la sortie ce test reprend le test précédent, mais en vérifiant la place de chaque cas après avoir effectué
   une action

7) [test_07_charge_OK](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L181)
   permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
   méthode chargerLabyrinthe fonctionne correctement avec le labyrinthe laby0.txt

Utilisation du
fichier [laby_deuxPersonnage.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_deuxPersonnage.txt)

8) [test_08_charge_2_personnages](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L220)
   permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
   méthode chargerLabyrinthe lève bien une **exception** de type `FichierIncorrectException` si le labyrinthe contient
   plusieurs personnages ici le message est : `"FichierIncorrectException : plusieurs personnages"`

Utilisation du
fichier [laby_SansPersonnage.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_SansPersonnage.txt)

9) [test_09_charge_0_personnages](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L235)
   permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
   méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si le labyrinthe contient aucun
   personnage ici le message est : `"FichierIncorrectException : personnage inconnu"`

Utilisation du
fichier [laby_deuxSortie.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_deuxSortie.txt)

10) [test_10_charge_2_sorties](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L250)
    permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
    méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si le labyrinthe contient
    plusieurs sorties, mais aussi de verifier que le message d'erreur est correct ici le message d'erreur est :
    `"FichierIncorrectException : plusieurs sorties"`

Utilisation du
fichier [laby_SansSortie.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_SansSortie.txt)

11) [test_11_charge_0_sorties](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L265)
    permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
    méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si le labyrinthe ne contient
    aucune sortie, mais aussi de verifier que le message d'erreur est correct ici le message d'erreur est :
    `"FichierIncorrectException : sortie inconnue"`

Utilisation du
fichier [laby_2PremieresValeursNaN](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_2PremieresValeurNaN.txt)

12) [test_12_charge_valeur_nb_lignes_invalide](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L281)
    permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
    méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si le fichier du labyrinthe
    des caractères qui ne sont pas des nombres, ici le message d'erreur est :
    `"FichierIncorrectException : pb num ligne ou colonne"`

Utilisation du
fichier [laby_ligneEnPlus.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_ligneEnPlus.txt)

13) [test_13_charge_ligne_en_trop](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L296)
    permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
    méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si le fichier du labyrinthe ne
    contient pas le nombre de lignes indiqué dans la première ligne du fichier, qu'il contienne **plus** de ligne
    qu'indiqué ici le message d'erreur est :
    `"FichierIncorrectException : nbLignes ne correspond pas"`

Utilisation du
fichier [laby_ligneEnMoins.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_ligneEnMoins.txt)

14) [test_14_charge_ligne_en_moins](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L311)
    permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
    méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si le fichier du labyrinthe ne
    contient pas le nombre de lignes indiqué dans la première ligne du fichier, qu'il contienne **moins** de ligne
    qu'indiqué ici le message d'erreur est :
    `"FichierIncorrectException : nbLignes ne correspond pas"`

Utilisation du
fichier [laby_colonneIncorrect.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_colonneIncorrect.txt)

15) [test_15_charge_colonne_incorrect](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L326)
    permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
    méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si le fichier du labyrinthe ne
    contient pas le bon nombre de caractères par colonnes ici le message d'erreur est :
    `"FichierIncorrectException : nbColonnes ne correspond pas"`

Utilisation du
fichier [laby_caractereInconnu.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_caractereInconnu.txt)

16) [test_16_charge_caractere_inconnu](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/3f00e3bf66a7323d98c4d7fc196a94f81960c960/test/LabyrintheTest.java#L341)
    permet de tester la méthode `chargerLabyrinthe()` de la classe Labyrinthe cette méthode permet de tester si la
    méthode chargerLabyrinthe lève bien une exception de type `FichierIncorrectException` si un caractère du labyrinthe
    est inconnue nous avons pris comme caractère inconnu le caractère `E` donc ici le message d'erreur est :
    `"FichierIncorrectException : caractere inconnu E"`

Utilisation du fichier [laby2.txt](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/main/laby/laby_2.txt)

17) [test_17_deplacerPerso_rencontre_sortie](https://github.com/Nzosim/Laby2022-SIMONIN-MANGIN/blob/a5c3db9baac1f1f415a3e5fbaf949d9215ac58ef/test/LabyrintheTest.java#L359)
    permet de tester la méthode deplacerPerso() de la classe Labyrinthe cette méthode permet de tester si le personnage
    ne s'arrete pas sur la sortie du labyrinthe ce qui est attendu.

### - Converture de test

**Voici le tableau de la couverture des tests**

| Nom des classes             | Classe % | Methode % | Ligne % |
|-----------------------------|----------|-----------|---------|
| `ActionInconnuException`    | 100%     | 100%      | 100%    |
| `FichierIncorrectException` | 100%     | 100%      | 100%    |
| `Position`                  | 100%     | 100%      | 100%    |
| `Personnage`                | 100%     | 100%      | 100%    |
| `Sortie`                    | 100%     | 100%      | 100%    |
| `Labyrinthe`                | 100%     | 100%      | 100%    |
| `MainLaby`                  | 0%       | 0%        | 0%      |

Toutes les classes sont testées avec 100% de couverture puisqu'il n'y a aucune méthode qui est inutile dans les classes
testées et que tous les tests sont **validés**.

Pour la classe `MainLaby`, nous ne pouvons pas la tester, car un main ne peut être testé. Donc c'est pour cela qu'elle a
0% dans chaque colonne.
