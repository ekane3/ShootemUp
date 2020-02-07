package elements;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.*;

public class Balles {

	public int x,y;
	public float vy;
	Color c;
	public boolean collide=false;
	public Image imageb;

	public Balles(int x, int y, float vy) {
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
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
		imageb = new Image("src/images/balles.png");
		imageb.draw(x, y,20,20);
		
	}
	//Tricherie pour dessiner etoile
	public void etoile(Graphics g) throws SlickException{
		imageb = new Image("src/images/starBig.png");
		imageb.draw(x, y,20,20);
	}
	//deplacer nos balles 
	public void deplacer(int delta) {
		y -= vy*(delta/100f);
	}
	//verifier si nos balles sont hors ecran
	public  boolean horsEcran() {
		 if (this.y <= 0 ) 
			return true;
		 else 
			return false;
	 }
	 //verifier si nos balles touchent les ennemis
	public  boolean testCollision(EnnemiAbstrait e) {
		 Circle c = new Circle(x, y, 10);
		 Rectangle r = new Rectangle(e.getX(), e.getY(), 50,50);
		 boolean coll = c.intersects(r);

		 if(coll == true ) {
			 collide = true;
//POUR differents ennemis if (e instanceof Ennemi) {
//				((Ennemi) e).setDie(true);
//			}
			e.setDie(true);	
		} 
		 return coll;
		}
	 	 
}
