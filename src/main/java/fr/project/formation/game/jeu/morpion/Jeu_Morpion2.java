package fr.project.formation.game.jeu.morpion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/morpion")
public class Jeu_Morpion2 {

	@Autowired
	private String[][] tab;
	
	
	@RequestMapping(path="/morpion", method=RequestMethod.GET)
	public ModelAndView editInit(){
        ModelAndView mav = new ModelAndView("morpion/morpion");
        mav.getModel().put("Message", "Le Joueur commence :");
        this.tab = creationMatrice();
        mav.getModel().put("Table", this.tab);
        //Display.displayGrid(tab);
        return mav;
	}
        

    @RequestMapping(path="/morpion", method=RequestMethod.POST)
	public ModelAndView editJeu(@RequestParam final Integer position){
    	ModelAndView mav = new ModelAndView("");
        if (!Ia.isGameEnd(this.tab, 0)){
        	this.tab[position/3][position%3] = "X";
            
            if (Ia.nombreEspace(this.tab) != 0) {
            	this.tab = Ia.iaPlay(this.tab);
            }
            //Score();
            Display.displayGrid(this.tab);
            mav.getModel().put("Table", this.tab);
        }else {
        	
        }
        //if (Ia.isGameWin(tab, 2)){win++;}
        //else if (Ia.isGameLose(tab, 2)){lose++;}
        //else if (Ia.isGameDraw(tab,2)){draw++;}
        //return Ia.isGameWin(tab,2);
        return mav;
    }
	
    public String[][] creationMatrice(){
        String[][] tabMorpion = {{"v", "v", "v"},{"v", "v", "v"},{"v", "v", "v"}};
        return tabMorpion;
    }
	
}
