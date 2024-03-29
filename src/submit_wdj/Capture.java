package submit_wdj;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capture {
	public static void main(String[] args) {
		JFrame capture = new JFrame();
		capture.setDefaultCloseOperation(capture.EXIT_ON_CLOSE);
		
		Dimension d;
		Rectangle rect = new Rectangle(1000,1000);
		capture.setSize(d = new Dimension(1000,1000));
		
		try {
			Robot robot = new Robot();
			final BufferedImage image = robot.createScreenCapture(rect);
			image.flush();
			
			JPanel panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(image, 0, 0, d.width, d.height, this);
				}
			};
			panel.setOpaque(false);
			panel.prepareImage(image, panel);
			panel.repaint();
			capture.getContentPane().add(panel);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		capture.setLocationRelativeTo(null);
		capture.setVisible(true);
		
	}
}
