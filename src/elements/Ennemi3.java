package elements;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ennemi3 extends EnnemiAbstrait {
	public boolean move=false;
	
	public Ennemi3(float x, float y, float vy) {
		super(x, y, vy);
	}

	@Override
	public void desinner(Graphics g) throws SlickException {
		imageen =new Image("src/images/ennemi3.png");
		imageen.draw(x, y, 50, 50);	
	}

	@Override //methodes pour faire deplacer nos ennemis du haut vers le bas a une position et vice versa
	public void deplacer(int delta) {
		if (y<0) {
			move=true;
		}
		if(y+50>=300) {
			move=false;
		}
		
		if (move) {
			y+=vy*(delta/100f);
		}else {
			y-=vy*(delta/100f);
		}
	}

	@Override //verifier si les ennemis sont horsecran pour les supprimer apres
	public boolean hrsEcran() {
		if (this.getY() >= 600 ) {
			return true;
		}else 
			return false;
  	}
}