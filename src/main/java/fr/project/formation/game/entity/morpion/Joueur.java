package fr.project.formation.game.entity.morpion;

/**
 * Created by Erwan on 11/05/2017.
 */
public class Joueur {

    public static String[][] joureurPlay(String[][] tabMorpion){
        int position;
        do {
            do {
                position = Display.displayQuestion();
            }while(position > 8 || position < 0);

        }while(Display.displayError(tabMorpion, position));

        tabMorpion[position/3][position%3] = "X";
        return tabMorpion;
    }

    public static String[][] joureurPlay2(String[][] tabMorpion){
        int position;
        do {
            do {
                position = Display.displayQuestion();
            }while(position > 8 || position < 0);

        }while(Display.displayError(tabMorpion, position));

        tabMorpion[position/3][position%3] = "O";
        return tabMorpion;
    }

}
