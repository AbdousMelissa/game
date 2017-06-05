package fr.project.formation.game.jeu.morpion;

/**
 * Created by Erwan on 11/05/2017.
 */
public class Ia {

    public static boolean isGameDraw(String[][] tabMorpion, int multi){
        for (int i = 0; i < 9 ; i ++) {
            if (tabMorpion[i / 3][i % 3] == " ") {
                return false;
            }
        }
        Display.displayMatchDraw(multi);
        return true;
    }

    public static boolean isGameWin(String[][] tabMorpion, int multi){
        String symbole = "XXX";
        boolean cond = false;
        for (int i = 0; i<3; i++) {
            cond = cond || (symbole.equals(tabMorpion[i][0] + tabMorpion[i][1] + tabMorpion[i][2]));//line horizontal
            cond = cond || (symbole.equals(tabMorpion[0][i] + tabMorpion[1][i] + tabMorpion[2][i]));//line verticale
        }
        cond = cond || (symbole.equals(tabMorpion[0][0] + tabMorpion[1][1] + tabMorpion[2][2]));//diagonale 1
        cond = cond || (symbole.equals(tabMorpion[0][2] + tabMorpion[1][1] + tabMorpion[2][0]));//diagonale 2
        if (cond){
            Display.displayMatchWin(multi);
        }
        return cond;
    }

    public static boolean isGameLose(String[][] tabMorpion, int multi){
        String symbole = "OOO";
        boolean cond = false;
        for (int i = 0; i<3; i++) {
            cond = cond || (symbole.equals(tabMorpion[i][0] + tabMorpion[i][1] + tabMorpion[i][2]));//line horizontal
            cond = cond || (symbole.equals(tabMorpion[0][i] + tabMorpion[1][i] + tabMorpion[2][i]));//line verticale
        }
        cond = cond || (symbole.equals(tabMorpion[0][0] + tabMorpion[1][1] + tabMorpion[2][2]));//diagonale 1
        cond = cond || (symbole.equals(tabMorpion[0][2] + tabMorpion[1][1] + tabMorpion[2][0]));//diagonale 2
        if (cond){
            Display.displayMatchLose(multi);
        }
        return cond;
    }

    public static boolean isGameEnd(String[][] tabMorpion, int multi){
        return (isGameLose(tabMorpion, multi) || isGameWin(tabMorpion, multi) || isGameDraw(tabMorpion , multi));
    }

    //----------------------------------------------------------------------
    //fonction ia
    public static int iaCentre(String[][] tabMorpion){
        if (tabMorpion[1][1] == " "){
            return 4;
        }
        return -1;
    }

    public static int randomBox(int low, int hight){
        int random = (int)(Math.random()*(hight-low));
        return random;
    }
    public static int iaRandomPlay(String[][] tabMorpion){
        int rand = randomBox(9-nombreEspace(tabMorpion), 9);
        System.out.println("ici" + rand);
        int compteur = 0;
        for (int i = 0; i < 9; i++){
            if (tabMorpion[i/3][i%3] == " "){
                compteur++;
            }
            if (compteur-1 == rand){
                return i;
            }
        }
        return -1;
    }

    public static int iaPlayToWin(String[][] tabMorpion){
        String symbole = "OO";
        for (int i = 0; i<3; i++) {
            //line horizontal
            if (symbole.equals(tabMorpion[i][0] + tabMorpion[i][1]) && tabMorpion[i][2] == " "){
                return (i*3+2);
            }else if (symbole.equals(tabMorpion[i][1] + tabMorpion[i][2]) && tabMorpion[i][0] == " "){
                return (i*3);
            }else if (symbole.equals(tabMorpion[i][0] + tabMorpion[i][2]) && tabMorpion[i][1] == " "){
                return (i*3+1);
            }
            //line verticale
            if (symbole.equals(tabMorpion[0][i] + tabMorpion[1][i]) && tabMorpion[2][i] == " "){
                return (i+2*3);
            }else if (symbole.equals(tabMorpion[1][i] + tabMorpion[2][i]) && tabMorpion[0][i] == " "){
                return (i);
            }else if (symbole.equals(tabMorpion[0][i] + tabMorpion[2][i]) && tabMorpion[1][i] == " "){
                return (i+3);
            }
        }
        //diagonale
        if (symbole.equals(tabMorpion[0][0] + tabMorpion[1][1]) && tabMorpion[2][2] == " "){
            return 8;
        }else if (symbole.equals(tabMorpion[2][2] + tabMorpion[1][1]) && tabMorpion[0][0] == " "){
            return 0;
        }else if ((symbole.equals(tabMorpion[2][2] + tabMorpion[0][0]) && tabMorpion[1][1] == " ") ||
                (symbole == (tabMorpion[0][2] + tabMorpion[2][0]) && tabMorpion[1][1] == " ")){
            return 4;
        }else if (symbole.equals(tabMorpion[0][2] + tabMorpion[1][1]) && tabMorpion[2][0] == " "){
            return 6;
        }else if (symbole.equals(tabMorpion[2][0] + tabMorpion[1][1]) && tabMorpion[0][2] == " "){
            return 2;
        }
        return -1;
    }

    public static int iaPlayToDefend(String[][] tabMorpion){
        String symbole = "XX";
        for (int i = 0; i<3; i++) {
            //line horizontal
            if (symbole.equals(tabMorpion[i][0] + tabMorpion[i][1]) && tabMorpion[i][2] == " "){
                return (i*3+2);
            }else if (symbole.equals(tabMorpion[i][1] + tabMorpion[i][2]) && tabMorpion[i][0] == " "){
                return (i*3);
            }else if (symbole.equals(tabMorpion[i][0] + tabMorpion[i][2]) && tabMorpion[i][1] == " "){
                return (i*3+1);
            }
            //line verticale
            if (symbole.equals(tabMorpion[0][i] + tabMorpion[1][i]) && tabMorpion[2][i] == " "){
                return (i+2*3);
            }else if (symbole.equals(tabMorpion[1][i] + tabMorpion[2][i]) && tabMorpion[0][i] == " "){
                return (i);
            }else if (symbole.equals(tabMorpion[0][i] + tabMorpion[2][i]) && tabMorpion[1][i] == " "){
                return (i+3);
            }
        }
        //diagonale
        if (symbole.equals(tabMorpion[0][0] + tabMorpion[1][1]) && tabMorpion[2][2] == " "){
            return 8;
        }else if (symbole.equals(tabMorpion[2][2] + tabMorpion[1][1]) && tabMorpion[0][0] == " "){
            return 0;
        }else if ((symbole.equals(tabMorpion[2][2] + tabMorpion[0][0]) && tabMorpion[1][1] == " ") ||
                (symbole == (tabMorpion[0][2] + tabMorpion[2][0]) && tabMorpion[1][1] == " ")){
            return 4;
        }else if (symbole.equals(tabMorpion[0][2] + tabMorpion[1][1]) && tabMorpion[2][0] == " "){
            return 6;
        }else if (symbole.equals(tabMorpion[2][0] + tabMorpion[1][1]) && tabMorpion[0][2] == " "){
            return 2;
        }
        return -1;
    }

    public static String[][] iaPlay(String[][] tabMorpion){
        int position = iaCentre(tabMorpion);
        if(position == -1) {
            position = iaPlayToWin(tabMorpion);
        }
        if(position == -1){
            position = iaPlayToDefend(tabMorpion);
        }
        if(position == -1) {
            position = iaRandomPlay(tabMorpion);
        }

        tabMorpion[position/3][position%3] = "O";
        return tabMorpion;
    }

    //----------------------------------------------------------------------
    //fonction supplementaire
    public static int nombreEspace(String[][] tabMorpion){
        int compteur = 0;
        for (int i = 0; i < 9; i++){
            if (tabMorpion[i/3][i%3] == " "){
                compteur++;
            }
        }
        return compteur;
    }

}
