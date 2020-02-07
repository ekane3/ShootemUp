package elements;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class EnnemiAbstrait {

	public float x,y;
	float vy;
	public Image imageen;
	boolean die = false;
	public EnnemiAbstrait(float x, float y,float vy) {
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	public boolean isDie() {
		return die;
	}

	public void setDie(boolean die) {
		this.die = die;
	}

	//afficher nos ennemis dans notre graphique
	abstract public void desinner(Graphics g) throws SlickException;
	//methodes pour faire deplacer nos ennemis du haut vers le bas
	abstract public void deplacer(int delta);
	//verifier si les ennemis sont horsecran pour les supprimer apres
	abstract public  boolean hrsEcran();
}
