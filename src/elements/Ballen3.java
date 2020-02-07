package elements;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class Ballen3 {

	public float x,y;
	public float vy;
	Color c;
	public boolean collide=false,sens=false;
	public Image imageb;

	public Ballen3(float x, float y, float vy) {
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
	public boolean isCollide() {
		return collide;
	}
	public void setCollide(boolean collide) {
		this.collide = collide;
	}
	public Image getImageb() {
		return imageb;
	}
	public void setImageb(Image imageb) {
		this.imageb = imageb;
	}
	//dessiner nos balles sur l'ecran
	public void dessiner(Graphics g) throws SlickException{
		imageb = new Image("src/images/ballen3.png");
		imageb.draw(x, y,20,20);
		
	}
	
	//deplacer nos balles 
	public void deplacer(int delta) {
		if (!sens) {
			y += vy*(delta/1000f);
			x += vy*(delta/500f);
		}else {
			y += vy*(delta/1000f);
			x -= vy*(delta/500f);
		}
		
		if (x>700) {
			sens=true;
		}
		if (x<0) {
			sens=false;
		}
	}
	//verifier si nos balles sont hors ecran
	public  boolean horsEcran() {
		 if (this.y >= 600 ) 
			return true;
		 else 
			return false;
	 }
	 //verifier si nos balles touchent les ennemis
	public  boolean testCollision(Acteur a) {
		 Circle c = new Circle(x, y, 10);
		 Rectangle r = new Rectangle(a.getX(), a.getY(), 50,50);
		 boolean coll = c.intersects(r);

		 if(coll == true ) {
			 collide = true;
//POUR differents ennemis if (e instanceof Ennemi) {
//				((Ennemi) e).setDie(true);
//			}
			a.setCollideobs(true);	
		} 
		 return coll;
		}
}
