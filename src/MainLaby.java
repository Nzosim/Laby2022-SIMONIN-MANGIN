import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Entrer le nom du fichier");
            System.exit(1);
        }
        Labyrinthe laby = new Labyrinthe();
        boolean jeu = false;
        try{
            laby = Labyrinthe.chargerLabyrinthe(args[0]);
        }catch (FileNotFoundException e){
            System.out.println("Le fichier n'existe pas");
            jeu = true;
        }catch (FichierIncorrectException e){
            System.out.println("Le labyrinthe du fichier n'est pas conforme");
            jeu = true;
        }catch (IOException e){
            System.out.println(e.getMessage());
            jeu = true;
        }

        Scanner sc = new Scanner(System.in);
        String entree = "";

        ArrayList<String> actions = new ArrayList<>();
        actions.add(Labyrinthe.HAUT);
        actions.add(Labyrinthe.BAS);
        actions.add(Labyrinthe.DROITE);
        actions.add(Labyrinthe.GAUCHE);
        actions.add("exit");


        while (!jeu){
            System.out.println(laby);

            do {
                System.out.println("Quel sera votre prochaine action : haut, bas, gauche, droite ou exit");
                entree = sc.nextLine().toLowerCase();

                if (!actions.contains(entree)){
                    System.out.println("Mauvaise action");
                }
            }while (!actions.contains(entree));

            if (entree.equals("exit")){
                System.out.println("Vous avez abandonnée la partie");
                System.exit(0);
            }

            laby.deplacerPerso(entree);


            jeu = laby.etreFini();
            if (jeu){
                System.out.println("!!!  Vous avez reussi le labyrinthe  !!!");
            }
        }
        sc.close();
    }
}
