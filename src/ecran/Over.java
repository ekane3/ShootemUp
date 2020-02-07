package ecran;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import elements.Balles;
import elements.Obstacle;

public class Over extends BasicGameState {
	Image bgroundmenu,ptitetoile,grosetoile,go;
	Music m;
	public Over() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bgroundmenu = new Image("src/images/bgMenu.png");
		ptitetoile = new Image("src/images/starSmall.png");
		grosetoile = new Image("src/images/starBig.png");
		go = new Image("src/images/GO.png");
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bgroundmenu.draw(0, 0, 900,650);
		g.setColor(Color.white);
		go.draw(150, 50, 600, 400);
		g.drawString("********************\n	Vous avez perdu", 350, 400);
		g.drawString("	N : Nouveau jeu" , 350,440 );
		g.drawString("	R : Retour au menu" , 350,460 );
		g.drawString("	Q : Pour quitter :\n\n********************" , 350, 480);
		
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyDown(input.KEY_Q)) {
			gc.exit();
		}
		if (input.isKeyDown(input.KEY_R)) {
			sbg.enterState(1);
		}
		if (input.isKeyDown(input.KEY_N)) {
			sbg.enterState(2);
		}
		
	}

	@Override
	public int getID() {
		return 3;
	}
	public static void main(String[] args) throws SlickException{
		
	}

}
