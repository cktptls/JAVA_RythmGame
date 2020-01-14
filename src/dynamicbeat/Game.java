package dynamicbeat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteLineImage, 236, 30, null);
		g.drawImage(noteRouteSImage, 240, 30, null);
		g.drawImage(noteRouteLineImage, 340, 30, null);
		g.drawImage(noteRouteDImage, 344, 30, null);
		g.drawImage(noteRouteLineImage, 444, 30, null);
		g.drawImage(noteRouteFImage, 448, 30, null);
		g.drawImage(noteRouteLineImage, 548, 30, null);
		g.drawImage(noteRouteSpace1Image, 552, 30, null);
		g.drawImage(noteRouteSpace2Image, 652, 30, null);
		g.drawImage(noteRouteLineImage, 752, 30, null);
		g.drawImage(noteRouteJImage, 756, 30, null);
		g.drawImage(noteRouteLineImage, 856, 30, null);
		g.drawImage(noteRouteKImage, 860, 30, null);
		g.drawImage(noteRouteLineImage, 960, 30, null);
		g.drawImage(noteRouteLImage, 964, 30, null);
		g.drawImage(noteRouteLineImage, 1064, 30, null);
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 560, null);
		
		g.drawImage(noteBasicImage, 240, 30, null);
		g.drawImage(noteBasicImage, 344, 69, null);
		g.drawImage(noteBasicImage, 448, 560, null);
		g.drawImage(noteBasicImage, 552, 144, null);
		g.drawImage(noteBasicImage, 652, 144, null);
		g.drawImage(noteBasicImage, 756, 125, null);
		g.drawImage(noteBasicImage, 860, 38, null);
		g.drawImage(noteBasicImage, 964, 57, null);
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		/* g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Joakim Karud - Mighty Love", 20, 702);
		g.drawString("Easy", 1190, 702); */
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.drawString("S", 280, 590);
		g.drawString("D", 384, 590);
		g.drawString("F", 488, 590);
		g.drawString("Space Bar", 582, 590);
		g.drawString("J", 796, 590);
		g.drawString("K", 900, 590);
		g.drawString("L", 1004, 590);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702); // 점수
	}
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall4.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig2.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig3.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	@Override
	public void run() { // Thread는  run메소드를 무조건 실행해야함
		
	}
}
