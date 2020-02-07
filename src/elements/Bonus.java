package elements;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Bonus extends EnnemiAbstrait {
	public boolean die=false;

	public Bonus(float x, float y, float vy) {
		super(x, y, vy);
	}
	public boolean isDie() {
		return die;
	}

	public void setDie(boolean die) {
		this.die = die;
	}
	@Override
	public void desinner(Graphics g) throws SlickException {
		Image bon = new Image("src/images/bonus.png");
		bon.draw(x, y, 40, 40);

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
	 //Tester les collisions entre les bonus et l'acteur(le vaisseau)
		public  boolean testCollision(Acteur a) {
			 Rectangle R = new Rectangle(x-20, y-20, 40,40);
			 Rectangle r = new Rectangle(a.getX()-40, a.getY()-(53/2), 70,53);
			 boolean coll = R.intersects(r);

			 if(coll == true ) {
				 die = true;
				a.setCollideobs(true);	
			} 
			 return coll;
			}
}
