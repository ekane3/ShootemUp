package ecran;

import org.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends StateBasedGame {
	Image bgroundmenu;
	
	public Menu(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new Menu("Emile's Shoot'em up"),900,650,false);
		app.setShowFPS(false);
		app.start();
	}
//
//	public Menu() {
//		
//	}
//
//	@Override
//	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
//		g.fillOval(75, 100, 100, 100);
//		g.drawString("ok ok ", 80, 70);
//	}
//
//	@Override
//	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
//
//
//	}
//
//	@Override
//	public int getID() {
//		return 0;
//	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Play());
		addState(new MainShootemup());
		addState(new Over());	
		addState(new ChoisirNiveau());
		addState(new Sonoff());
	}
	

}
