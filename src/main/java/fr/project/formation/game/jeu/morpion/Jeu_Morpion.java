package fr.project.formation.game.jeu.morpion;

import java.util.Scanner;

/**
 * Created by Erwan on 11/05/2017.
 */
public class Jeu_Morpion {

	String[][] tab = creationMatrice();
    static int win = 0, lose = 0, draw = 0;

    public static void Menu() {
        Scanner Scan = new Scanner(System.in);
        boolean bool = false;
        do{
            Display.MenuJeu();
            switch(Scan.nextInt()){
                case 0 : {//Partit Le Joueur commence
                    Jeujoueur();
                    break;
                }
                case 1 : {//Partit ordinateur commence
                    Jeuordi();
                    break;
                }
                case 2 : {//Partit continu
                    Jeu();
                    break;
                }
                case 3 : {//Partit multijoueur
                    Jeumulti();
                    break;
                }
                case 4 : {//Partit multijoueur
                    Jeumultiboucle();
                    break;
                }
                default : {//quitte
                    bool = quitte();
                    break;
                }
            }
        }while(!bool);
        System.out.println("Bonne journée");
    }

    //Partie sans fin
    public static void Jeu(){
        boolean bool, bool2;
        win = 0; lose = 0; draw = 0;
        do {
            do {
                bool = Jeujoueur();
                bool2 = quitte();
            } while (!bool && !bool2);
            while (bool && !bool2) {
                bool = Jeuordi();
                bool2 = quitte();
            }
        }while(!bool2);
    }

    public static boolean quitte(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Voulez-vous quitter le jeu ('y' pour quitter) :");
        return (Scan.next().charAt(0) == 'y');
    }

    //Le joueur commence
    public static boolean Jeujoueur(){
        System.out.println("############################################################");
        System.out.println("Le Joueur commence :");
        String[][] tab = creationMatrice();
        Display.displayGrid(tab);

        while(!Ia.isGameEnd(tab, 0)){
            tab = Joueur.joureurPlay(tab);

            if (Ia.nombreEspace(tab) != 0) {
                tab = Ia.iaPlay(tab);
            }
            Score();
            Display.displayGrid(tab);
        }
        if (Ia.isGameWin(tab, 2)){win++;}
        else if (Ia.isGameLose(tab, 2)){lose++;}
        else if (Ia.isGameDraw(tab,2)){draw++;}
        return Ia.isGameWin(tab,2);
    }

    //L'ordinateur commence
    public static boolean Jeuordi(){
        System.out.println("############################################################");
        System.out.println("L'ordinateur commence :");
        String[][] tab = creationMatrice();
        Display.displayGrid(tab);

        while(!Ia.isGameEnd(tab, 0)){
            tab = Ia.iaPlay(tab);
            Score();
            Display.displayGrid(tab);

            if (Ia.nombreEspace(tab) != 0) {
                tab = Joueur.joureurPlay(tab);
            }

        }
        if (Ia.isGameWin(tab,2)){win++;}
        else if (Ia.isGameLose(tab,2)){lose++;}
        else if (Ia.isGameDraw(tab,2)){draw++;}
        return Ia.isGameWin(tab,2);
    }

    //Le multi-joueur
    //Partie sans fin
    public static void Jeumultiboucle(){
        boolean bool, bool2;
        win = 0; lose = 0; draw = 0;
        do {
            do {
                bool = Jeumulti();
                bool2 = quitte();
            } while (!bool && !bool2);
            while (bool && !bool2) {
                bool = Jeumulti2();
                bool2 = quitte();
            }
        }while(!bool2);
    }

    public static boolean Jeumulti(){
        System.out.println("############################################################");
        System.out.println("Le Joueur 1 commence :");
        String[][] tab = creationMatrice();
        Display.displayGrid(tab);

        while(!Ia.isGameEnd(tab, 1)){
            System.out.println("Le Joueur 1 commence (symbole : X) :");
            tab = Joueur.joureurPlay(tab);
            Score2();
            Display.displayGrid(tab);
            if (Ia.nombreEspace(tab) != 0 && !Ia.isGameWin(tab, 2)) {
                System.out.println("Le Joueur 2 commence (symbole : O) :");
                tab = Joueur.joureurPlay2(tab);
            }
            Score2();
            Display.displayGrid(tab);
        }
        if (Ia.isGameWin(tab, 2)){win++;}
        else if (Ia.isGameLose(tab, 2)){lose++;}
        else if (Ia.isGameDraw(tab,2)){draw++;}
        return Ia.isGameWin(tab, 2);
    }

    public static boolean Jeumulti2(){
        System.out.println("############################################################");
        System.out.println("Le Joueur 2 commence :");
        String[][] tab = creationMatrice();
        Display.displayGrid(tab);

        while(!Ia.isGameEnd(tab, 1)){
            System.out.println("Le Joueur 2 commence (symbole : O) :");
            tab = Joueur.joureurPlay2(tab);
            Score2();
            Display.displayGrid(tab);
            if (Ia.nombreEspace(tab) != 0 && !Ia.isGameLose(tab, 2)) {
                System.out.println("Le Joueur 1 commence (symbole : X) :");
                tab = Joueur.joureurPlay(tab);
            }
            Score2();
            Display.displayGrid(tab);
        }
        if (Ia.isGameWin(tab, 2)){win++;}
        else if (Ia.isGameLose(tab, 2)){lose++;}
        else if (Ia.isGameDraw(tab,2)){draw++;}
        return Ia.isGameWin(tab, 2);
    }

    public static String[][] creationMatrice(){
        String[][] tabMorpion = {{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
        return tabMorpion;
    }

    public static void Score(){
        System.out.println("Match Gagner : " + win + "   \tMatch Perdu : " + lose + "   \tMatch nul : " + draw);
    }

    public static void Score2(){
        System.out.println("J1 : " + win + "   \tJ2 : " + lose + "   \tMatch nul : " + draw);
    }

}
