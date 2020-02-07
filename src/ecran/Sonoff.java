package ecran;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Sonoff extends BasicGameState {

	Image bgroundmenu,v,wel;
	Music m;
	public Sonoff() {
	
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		bgroundmenu = new Image("src/images/starBackground.png");
		v = new Image("src/images/acteur.png");
		wel = new Image("src/images/niveau.png");
		m = new Music("src/musics/start.ogg");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		bgroundmenu.draw(0, 0, 900,650);
		//wel.draw(100, 20, 700, 400);
		v.draw(0, 0, 70,53);
		v.draw(0, 600, 70,53);
		v.draw(825, 0, 70,53);
		v.draw(825, 600, 70,53);
		g.setColor(Color.white);
		g.drawString("Shoot'em up Shoot'em up Shoot'em up Shoot'em up", 250, 325);
		g.drawString("********************\n	Options", 350, 400);
		g.drawString("	A : Activez son" , 350,440 );
		g.drawString("	D : Désactivez son" , 350,460 );
		g.drawString("	Q : Pour quitter :\n\n********************\n\n\n" , 350, 480);
		g.drawString("	R : Retour au Menu" , 350, 500);
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
		if (input.isKeyDown(input.KEY_R)) {
			sbg.enterState(1);
		}
		if (input.isKeyDown(input.KEY_A)) {
			//sbg.enterState(3);
			m.play(1.f, 1.f);
		}
		if (input.isKeyDown(input.KEY_D)) {
			m.stop();
			//sbg.enterState(2);
		}
		if (input.isKeyDown(input.KEY_Q)) {
			gc.exit();
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}

}
