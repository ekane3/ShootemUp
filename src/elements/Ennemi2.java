package elements;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
	
public class Ennemi2 extends Ennemi {
	public boolean move=false;
	
	public Ennemi2(float x, float y, float vy) {
		super(x, y, vy);
	}
	
	@Override
	public void desinner(Graphics g) throws SlickException {
		imageen =new Image("src/images/ennemi2.png");
		imageen.draw(x, y, 50, 50);	
	}

	@Override //methodes pour faire deplacer nos ennemis du haut vers le bas
	public void deplacer(int delta) {
		if (x<0) {
			move=true;
		}
		if(x+50>=690) {
			move=false;
		}
		
		if (move) {
			x+=vy*(delta/100f);
		}else {
			x-=vy*(delta/100f);
		}
						
	}

	@Override //verifier si les ennemis sont horsecran pour les supprimer apres
	public boolean hrsEcran() {
		if (this.getY() >= 600 ) 
			return true;
		 else 
			return false;
	}
		
  	}
