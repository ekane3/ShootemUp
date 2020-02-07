package ecran;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
	Image bgroundmenu,v,wel;
	Music m;
	public Play() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bgroundmenu = new Image("src/images/starBackground.png");
		v = new Image("src/images/acteur.png");
		wel = new Image("src/images/wel.png");
		m = new Music("src/musics/start.ogg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bgroundmenu.draw(0, 0, 900,650);
		wel.draw(100, 20, 700, 400);
		v.draw(0, 0, 70,53);
		v.draw(0, 600, 70,53);
		v.draw(825, 0, 70,53);
		v.draw(825, 600, 70,53);
		g.setColor(Color.white);
		g.drawString("Shoot'em up Shoot'em up Shoot'em up Shoot'em up", 250, 325);
		g.drawString("********************\n	J : Pour jouer", 350, 400);
		g.drawString("	N : Choisir Niveau" , 350,440 );
		g.drawString("	O : Options du jeu" , 350,460 );
		g.drawString("	Q : Pour Quitter\n\n********************" , 350, 480);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		int posx = Mouse.getX();
		int posy = Mouse.getY();
		if ((posx>350 && posx <450) && (posy>325 && posy <360) ){
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(2);
			}
		}
		if (input.isKeyDown(input.KEY_N)) {
			sbg.enterState(4);
		}
		if (input.isKeyDown(input.KEY_O)) {
			sbg.enterState(5);
		}
		if (input.isKeyDown(input.KEY_J)) {
			sbg.enterState(2);
		}
		if (input.isKeyDown(input.KEY_Q)) {
			gc.exit();
		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	public static void main(String[] args) {
		
	}

}
