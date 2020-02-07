package elements;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Obstacle extends EnnemiAbstrait {

	public Obstacle(float x, float y, float vy) {
		super(x, y, vy);
	}

	@Override
	public void desinner(Graphics g) throws SlickException {
		Image obs = new Image("src/images/obstaclepetit.png");
		obs.draw(x, y, 80, 80);

	}
	//Deplacer nos obstacles
	@Override
	public void deplacer(int delta) {
		if (y<600) {
			y += vy*(delta*0.09f);
		}
	}
	//verifier si les obstacles sont hors ecran pour les supprimer apres
	@Override
	public boolean hrsEcran() {
		 if (this.getY() >= 600 ) 
				return true;
			 else 
				return false;
	}

}
