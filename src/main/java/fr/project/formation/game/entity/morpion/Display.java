package fr.project.formation.game.entity.morpion;

import java.util.Scanner;

/**
 * Created by Erwan on 11/05/2017.
 */
public class Display {

    public static void displayEmpltyLine(){
        System.out.println("   |   |   ");
    }

    public static void displaySplitLine(){
        System.out.println("---+---+---");
    }

    public static void displayEmpltyGrid(){
        for (int i = 1; i <= 9; i++){
            displayEmpltyLine();
            if (i%3 == 0 && i != 9){
                displaySplitLine();
            }
        }
    }

    public static void displayLine(String[] tabLine){
    	
        System.out.println(" "+ (tabLine[0]=="v"?" ":tabLine[0]) + " | "+ (tabLine[1]=="v"?" ":tabLine[1]) + " | "+ (tabLine[2]=="v"?" ":tabLine[2]) + " ");
    }

    public static void displayGrid(String[][] tabMorpion){
        System.out.println("############################################################");
        for (int i = 2; i > -1; i--){
            displayEmpltyLine();
            displayLine(tabMorpion[i]);
            displayEmpltyLine();
            if (i != 0){
                displaySplitLine();
            }
        }
    }

    public static int displayQuestion(){
        Scanner Scan = new Scanner(System.in);
        System.out.print("Quelle case voulez-vous prendre (entre 1 et 9): ");
        return (Scan.nextInt()-1);
    }
    public static boolean displayError(String[][] tabMorpion, int cellule){
        if (tabMorpion[cellule/3][cellule%3] != " ") {
            System.out.println("Erreur : la case " + cellule + "est déjà occuper");
            return true;
        }
        return false;
    }
    public static void displaylaPlay(){
        Scanner Scan = new Scanner(System.in);
        System.out.println("Ces au tour de l'ordinateur de jouer");
    }

    public static void displayMatchDraw(int multi){
        if (multi == 0 || multi == 1) {
            System.out.println("Match nul!!!");
        }
    }

    public static void displayMatchWin(int multi){
        if (multi == 1){
            System.out.println("J1 a gagné");
        }else if (multi == 0) {
            System.out.println("Vous avez gagnez!!!!");
        }
    }

    public static void displayMatchLose(int multi){
        if (multi == 1){
            System.out.println("J2 a gagné");
        }else if (multi == 0) {
            System.out.println("Vous avez perdu.");
        }
    }

    public static void MenuJeu() {

        System.out.println("############################################################");
        System.out.println("#######            Menu du Jeu Morpion               #######");
        System.out.println("############################################################");
        System.out.println("\tSelection de la parti:");
        System.out.println("\t 0 - Partie simple / le joueur commence ");
        System.out.println("\t 1 - Partie simple / l'ordinateur commence ");
        System.out.println("\t 2 - Partie continu / le joueur commence ");
        System.out.println("\t 3 - Partie simple / Partie multi-joueur ");
        System.out.println("\t 4 - Partie continu / Partie multi-joueur ");
        System.out.println("\t 5 - Quitter le Jeu ");
        System.out.println("############################################################");
        System.out.print("\t Choisisser votre menu : ");
    }
}
