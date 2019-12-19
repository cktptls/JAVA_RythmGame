package dynamicbeat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위한 전체 화면에 대한 이미지 객체
	
	private Image introBackground;
	// 로컬에서 가져온 이미지를 불러올 객체
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 사용자가 임의로 창 조절 불가
		setLocationRelativeTo(null); // 화면 실행 시 컴퓨터의 정중앙으로 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 종료하면 프로세스 종료
		setVisible(true); // 실제 게임 화면 출력
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
}