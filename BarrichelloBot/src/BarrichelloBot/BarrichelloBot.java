package BarrichelloBot;

import java.awt.Color;

import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

/**
 * 
 * @author Aline Santos 
 * 	BarrichelloBot tenta ganhar mas sempre se atrasa
 *  batalha e se atrapalha no battlefield!
 *
 */

public class BarrichelloBot extends Robot {
	// controlar as dire��es do Scan


	public void run() {
		// estiliza��o
		setBodyColor(Color.red);
		setGunColor(Color.gray);
		setRadarColor(Color.darkGray);
		setBulletColor(Color.red);

		//movimentos
		
		turnGunRight(90);

		// rodar enqto o rob� estiver vivo
		while (true) {

			turnGunRight(360);
			ahead(300);
			back(50);
			turnGunLeft(360);
		}

	}

	public void onScannedRobot(ScannedRobotEvent event) {
		// qnd v� outro rob� no alcance
		// getBearing -> pega a posi��o do inimigo (angulo)
		// getDistance -> pega a posi��o do inimigo (coords)

		turnRight(event.getBearing());
		back(event.getDistance() + 5);
		scan();
		fireBullet(1); // pode ser at� 3, mas se errar vai perder energy/life
	}

	public void onHitWall(HitWallEvent event) {
		ahead(500);
		turnLeft(180);
		turnGunRight(360);
		turnLeft(180);
		ahead(100);

	}

	public void onHitRobot(HitRobotEvent event) {
		turnLeft(180);
		ahead(500);
		turnGunRight(360);
	}

	public void onHitByBullet(HitByBulletEvent event) {
		//fazer afastar
		ahead(550);
		turnLeft(180);
		turnGunRight(360);
	}

	public void onDeath(DeathEvent event) {
		out.println("Alas! at least I arrived on time to die");
	}

	public void onWin(WinEvent event) {
		turnLeft(36000);
		out.println("Wait?! what?! That's impossible!");

	}
}
