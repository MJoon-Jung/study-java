package ShootingGame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerAttack {
	Image image= new ImageIcon("D:\\programes\\java_workspace\\Java_self\\src\\ShootingGame\\image\\player_attack.png").getImage();
	int x,y;
	int width = image.getWidth(null);
	int height = image.getHeight(null);
	int attack = 5;
	
	public PlayerAttack(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public void fire() {
		this.x += 15;
	}
	
}
