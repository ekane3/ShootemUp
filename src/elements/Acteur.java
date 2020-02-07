package elements;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class Acteur {
	public int x,y;
	public float vitesse;
	public Image image;
	public boolean collideobs;
	


	public Acteur() {
		this.x = 350;
		this.y = 600;
		this.vitesse = 20;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isCollideobs() {
		return collideobs;
	}
	public int getX() {
		return x;
	}

	public float getVitesse() {
		return vitesse;
	}

	public Image getImage() {
		return image;
	}
	public void setCollideobs(boolean collideobs) {
		this.collideobs = collideobs;
	}
	
	public void dessiner(Graphics g)  throws SlickException{
		image =new Image("src/images/acteur.png");
		image.draw(x, y, 70, 53);
	}
	
	//methode pour aller a gauche
	public void gauche(int delta) {
		if (x>=10) {
			x-=vitesse*(delta/100f);	
		}	
	}
	//methode pour aller a droite
	public void droite(int delta) {
		if (x<=599) {
			x+=vitesse*(delta/100f);
		}
		
	}
	//methode pour aller en haut
	public void haut( ) {
		if (y > 500) {
			y-=1;
		}
		
	}
	
	//methode pour aller en bas
	public void bas() {
		if (y<=600) {
			y+=1;
		}
	}
	 //Tester les collisions entre les obstacles et mes ennemis
		public  boolean testCollision(Obstacle o) {
			 Rectangle R = new Rectangle(x-(70/2), y-(53/2), 70,53);
			 Rectangle r = new Rectangle(o.getX()-40, o.getY()-40, 80,80);
			 boolean coll = R.intersects(r);

			 if(coll == true ) {
				 collideobs = true;
	//POUR differents ennemis if (e instanceof Ennemi) {
//					((Ennemi) e).setDie(true);
//				}
				o.setDie(true);	
			} 
			 return coll;
			}


}
