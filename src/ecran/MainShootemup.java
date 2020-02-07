package ecran;

import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;

import elements.Acteur;
import elements.Ballen;
import elements.Ballen2;
import elements.Ballen3;
import elements.Balles;
import elements.Bonus;
import elements.Ennemi;
import elements.Ennemi2;
import elements.Ennemi3;
import elements.Obstacle;

public class MainShootemup extends BasicGameState {
	String souris = "sok";
	Acteur acteur;
	Ennemi ennemi;
	Balles ba;
	ArrayList<Ennemi> ennemilist;
	ArrayList<Ennemi2> ennemi2list;
	ArrayList<Ennemi3> ennemi3list;
	ArrayList<Balles> ballelist;
	ArrayList<Ballen> ballenlist;
	ArrayList<Ballen2> balle2list;
	ArrayList<Ballen3> balle3list;
	ArrayList<Obstacle> obslist;
	ArrayList<Bonus> bonuslist;
	int temps = 0, vie = 6, highscore = 200, score, add = 0, ancienscore, niveau, obstouchact = 0, timer, t, bb = 0;
	Image bground, exploen;
	Music bomb, mus;

	float alpha = 0;

	public MainShootemup() {
		super();
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// Image quand on tue ennemi
		exploen = new Image("src/images/explosion1.png");
		// Inistialisation de notre acteur
		acteur = new Acteur();
		// Inistialisation de nos ennemis
		ennemilist = new ArrayList<Ennemi>();
		ennemi2list = new ArrayList<Ennemi2>();
		ennemi3list = new ArrayList<Ennemi3>();
		for (float x = 0; x < 6; x++) {
			ennemilist.add(new Ennemi((float) (Math.random() * 600), (float) (Math.random() * 90), 1f));
		}
		for (float x = 0; x < 4; x++) {
			for (int j = 0; j < 5; j++) {
				ennemi2list.add(new Ennemi2((float) (Math.random() * 600), (float) (Math.random() * 200), 4f));
			}
		}
		for (float x = 0; x < 4; x++) {
			for (int j = 0; j < 5; j++) {
				ennemi3list.add(new Ennemi3((float) (Math.random() * 600), (float) (Math.random() * 200), 4f));
			}
		}
		// Initialisation de nos balles
		ballelist = new ArrayList<Balles>();
		ballenlist = new ArrayList<Ballen>();
		balle2list = new ArrayList<Ballen2>();
		balle3list = new ArrayList<Ballen3>();

		for (int i = 0; i < ballelist.size(); i++) {
			ballelist.add(new Balles(acteur.x, acteur.y, 2));
		}

		// Initialisons nos obstacles
		obslist = new ArrayList<Obstacle>();
		// Initialisons notre liste de bonus
		bonuslist = new ArrayList<Bonus>();
		// on met en place notre background
		bground = new Image("src/images/starBackground.png");
		// on met en place notre musique du background
		mus = new Music("src/musics/start.ogg");
		mus.play(1.0f, 4.0f);
		bomb = new Music("src/musics/en1kill.wav");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		// si obstouch alors on reduit vie
		if (vie == 0) {
			sbg.enterState(3);
		}
		// Mettre notre background
		bground.draw(0, 0, 700, 700);
		// Afficher de notre acteur
		acteur.dessiner(g);
		// g.drawString(souris, 400, 400);
		// Afficher nos ennemis
		for (Ennemi en : ennemilist) {
			en.desinner(g);
		}
		for (Ennemi2 en2 : ennemi2list) {
			en2.desinner(g);
		}
		for (Ennemi3 en3 : ennemi3list) {
			en3.desinner(g);
		}
		// Afficher nos obstacles
		for (Obstacle ob : obslist) {
			ob.desinner(g);
		}
		// Afficher nos balles
		for (Balles b : ballelist) {
			b.dessiner(g);
		}
		for (Ballen ben : ballenlist) {
			ben.dessiner(g);
		}
		for (Ballen2 b2 : balle2list) {
			b2.dessiner(g);
		}
		for (Ballen3 b3 : balle3list) {
			b3.dessiner(g);
		}
		// Afficher nos bonus
		for (Bonus bon : bonuslist) {
			bon.desinner(g);
		}
		// Ligne pour limiter la zone de jeu
		g.drawLine(700, 0, 700, 650);
		// Zone d'affichage de resultats
		g.drawRect(720, 10, 160, 160);
		g.drawString("N° de vie :" + vie, 730, 30);
		g.drawString("Score :" + score, 730, 60);
		g.drawString("High-Score :" + highscore, 730, 90);
		g.drawString("Temps : " + temps, 730, 120);
		g.drawRect(720, 230, 160, 160);
		g.drawString("Vous devez evitez \nles meteorites", 725, 250);
		g.drawRect(720, 430, 160, 160);
		g.drawString("Vous jouez ", 730, 450);
		g.drawString("actuellement a ", 730, 480);
		g.drawString("Shoot'em Up ", 730, 510);
		g.drawString("Ekane Emile ", 730, 540);
		g.drawString("3iL 2019-2020 " + obstouchact, 730, 570);

		if (gc.isPaused()) {
			Rectangle r = new Rectangle(0, 0, 700, 650);
			g.setColor(new Color(0.2f, 0.2f, 0.2f, alpha));
			g.fill(r);
			if (alpha < 0.5f) {
				alpha += 0.01f;
			} else {
				if (alpha > 0)
					alpha -= 0.01f;
			}
			g.setColor(Color.white);
			g.drawString(
					"LE JEU EST EN PAUSE\n\n*********************\nAppuyer sur la touche \n*********************\n\'D\': Desactivez son\n\'A': Activez son\n\'C\': Pour Continuer\n\'Q\': Pour Quitter\n*********************\n\'R\':Retour au Menu",
					250, 325);
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		// Deplacer l'acteur
		super.keyPressed(key, c);
		switch (key) {
		case Input.KEY_UP:
			acteur.haut();
			break;
		case Input.KEY_D:
			mus.stop();
			bomb.stop();
			break;
		case Input.KEY_A:
			mus.play(1.0f, 4.0f);
			bomb.resume();
			break;
		case Input.KEY_SPACE:
			if (ballelist.size() < 10) {
				ballelist.add(new Balles(acteur.x + 27, acteur.y, 20f));
			}
			break;

		default:
			break;
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (vie == 0) {
			sbg.enterState(3);
		}
		temps++;
		int posx = Mouse.getX();
		int posy = Mouse.getY();
		// Deplacer l'acteur
		Input input = gc.getInput();
		if (input.isKeyDown(input.KEY_LEFT)) {
			acteur.gauche(delta);
		}
		if (input.isKeyDown(input.KEY_RIGHT)) {
			acteur.droite(delta);
		}
		if (input.isKeyDown(input.KEY_P)) {
			gc.pause();
			mus.pause();
		}
		if (input.isKeyDown(input.KEY_C)) {
			if (gc.isPaused()) {
				gc.resume();
			}
		}
		if (input.isKeyDown(input.KEY_Q)) {
			if (gc.isPaused()) {
				gc.exit();
			}
		}
		if (input.isKeyDown(input.KEY_R)) {
			sbg.enterState(1);
		}
		souris = "Position de la souris :" + posx + "," + posy;
		// Deplacer nos balles du bas vers le haut
		for (Balles b : ballelist) {
			b.deplacer(delta);
		}
		for (Ballen ben : ballenlist) {
			ben.deplacer(delta);
		}
		for (Ballen2 b2 : balle2list) {
			b2.deplacer(delta);
		}
		for (Ballen3 b3 : balle3list) {
			b3.deplacer(delta);
		}
		// Deplacer nos ennemis
		for (Ennemi en : ennemilist) {
			en.deplacer(delta);
		}
		for (Ennemi2 en2 : ennemi2list) {
			en2.deplacer(delta);
		}
		for (Ennemi3 en3 : ennemi3list) {
			en3.deplacer(delta);
		}
		// Deplacer nos obstacles et Tester nos collisions
		for (Obstacle ob : obslist) {
			ob.deplacer(delta);
			acteur.testCollision(ob);
		}
		// Deplacer nos bonus
		for (Bonus bon : bonuslist) {
			bon.deplacer(delta);
		}
		// Retirer l'acteur du jeu apres de nombreux touchés de lobstacles
		for (int i = 0; i < obslist.size(); i++) {
			acteur.testCollision(obslist.get(i));
			if (acteur.isCollideobs()) {
				if (obstouchact == 1) {
					if (vie > 0) {
						vie -= 2;
					}
					obstouchact = 0;
				}
			}
		}

		for (int i = 0; i < obslist.size(); i++) {
			if (obslist.get(i).hrsEcran()) {
				if (obslist.get(i) != null) {
					obslist.remove(i);
					break;
				}
			}
			if (obslist.get(i).isDie()) {
				obslist.remove(i);
				obstouchact++;
				break;
			}
		}
		// Retirer projectile quand c'est hors ecran
		for (int i = 0; i < ballelist.size(); i++) {
			// si notre balle depasse la taille de l'ecran(y sup ou egal a 600)
			if (ballelist.get(i) != null) {
				if (ballelist.get(i).horsEcran()) {
					ballelist.remove(i);
					break;
				}
			}
		}
		// retirer projectile apres collision
		for (int i = 0; i < ballelist.size(); i++) {
			if (ballelist.get(i).isCollide()) {
				ballelist.remove(i);
				bomb.play();
				break;
			}
		}
		for (int i = 0; i < balle2list.size(); i++) {
			balle2list.get(i).testCollision(acteur);
			if (acteur.isCollideobs()) {
				// gc.pause();
			}
		}
		// Retirer balles ennemis quand c'est hors ecran
		for (int i = 0; i < balle2list.size(); i++) {
			// si notre balle depasse la taille de l'ecran(y sup ou egal a 600)
			if (balle2list.get(i) != null) {
				if (balle2list.get(i).horsEcran()) {
					balle2list.remove(i);
					break;
				}
			}
		}
		// retirer balles de differents ennemis apres collision
		for (int i = 0; i < balle2list.size(); i++) {
			if (balle2list.get(i).isCollide()) {
				balle2list.remove(i);
				bomb.play();
				break;
			}
		}
		// Tester nos collisions avec nos ennemis
		for (Ennemi enn : ennemilist) {
			for (Balles bal : ballelist) {
				bal.testCollision(enn);
			}
		}
		for (Ennemi2 en2 : ennemi2list) {
			for (Balles bal : ballelist) {
				bal.testCollision(en2);
			}
		}
		for (Ennemi3 en3 : ennemi3list) {
			for (Balles bal : ballelist) {
				bal.testCollision(en3);
			}
		}
		// supprimer 1er ennemi apres collision
		for (int i = 0; i < ennemilist.size(); i++) {
			if (ennemilist.get(i).hrsEcran()) {
				ennemilist.remove(i);
				break;
			}
			if (ennemilist.get(i).isDie()) {
				exploen.draw(ennemilist.get(i).getX(), ennemilist.get(i).getY(), 50, 50);
				ennemilist.remove(i);
				score++;
				break;
			}
		}
		// Supprimer 2eme ennemi apres collision
		for (int i = 0; i < ennemi2list.size(); i++) {
			if (ennemi2list.get(i).isDie()) {
				ennemi2list.remove(i);
				score++;
				break;
			}
		}
		// Supprimer 3eme ennemi apres collision
		for (int i = 0; i < ennemi3list.size(); i++) {
			if (ennemi3list.get(i).isDie()) {
				ennemi3list.remove(i);
				score++;
				break;
			}
		}
		// Enlever les bonus de lecran
		for (int i = 0; i < bonuslist.size(); i++) {
			if (bonuslist.get(i).hrsEcran()) {
				if (bonuslist.get(i) != null) {
					bonuslist.remove(i);
					break;
				}
			}
			if (bonuslist.get(i).isDie()) {
				bb++;
			}
		}
		// Ajoutons les balles ennemis
		timer += delta;
		t += delta;
		if (t >= 1000) {
			for (int i = 0; i < ennemilist.size(); i++) {
				ballenlist.add(new Ballen(ennemilist.get(i).getX(), ennemilist.get(i).getY(), 1000f));
			}
			t = 0;
		}
		if (timer >= 9000) {
			for (int i = 0; i < ennemi2list.size(); i++) {
				balle2list.add(new Ballen2(ennemi2list.get(i).getX(), ennemi2list.get(i).getY(), 100f));
			}
			for (int i = 0; i < ennemi3list.size(); i++) {
				balle3list.add(new Ballen3(ennemi3list.get(i).getX(), ennemi3list.get(i).getY(), 100f));
			}

			timer = 0;
		}
		// Ajoutons les ennemis apres quelques secondes
		add = add + delta;
		if ((int) (Math.random() * 1000) == 0) {
			// Ajoutons les ennemis apres quelques secondes
			if (add > 8000) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						ennemilist.add(new Ennemi((float) (Math.random() * 600), (float) (Math.random() * 90), 2f));
					}
				}
			}

			if (add > 200) {
				// Ajoutons les obstacles apres quelques secondes
				for (int i = 0; i < (int) (Math.random() * 2); i++) {
					obslist.add(new Obstacle((float) (Math.random() * 600), (float) (Math.random() * 200), 2f));
				}

			}
			// Ajoutons les bonus apres quelques secondes
			if (add > 40000) {
				for (int i = 0; i < 1; i++) {
					bonuslist.add(new Bonus((float) (Math.random() * 600), (float) (Math.random() * 200), 3f));
					break;
				}
			}
		}

	}

	@Override
	public int getID() {
		return 2;
	}
}
