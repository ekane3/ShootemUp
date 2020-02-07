package elements;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class Ennemi extends EnnemiAbstrait{


	public Ennemi(float x, float y,float vy) {
		super(x, y, vy);
	}
	
	public boolean isDie() {
		return die;
	}

	public void setDie(boolean die) {
		this.die = die;
	}

	public void desinner(Graphics g) throws SlickException {	
		imageen =new Image("src/images/ennemi.png");
		imageen.draw(x, y, 50, 50);		
	}
	//methodes pour faire deplacer nos ennemis du haut vers le bas
	public void deplacer(int delta) {
		if (y<600) {
			y += vy*(delta/100f);
		}	
	}
	//verifier si les ennemis sont horsecran pour les supprimer apres
		public  boolean hrsEcran() {
			 if (this.getY() >= 600 ) 
				return true;
			 else 
				return false;
		 }
		
}
