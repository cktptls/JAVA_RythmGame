package dynamicbeat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위한 전체화면에 대한 이미지를 담는 객체
	
	private Image introBackground;
	// 로컬에서 가져온 이미지를 담는 객체
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 게임 화면 해상도 임의적으로 조정 불가능
		setLocationRelativeTo(null); // 게임 화면 출력 시 컴퓨터 정중앙 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 화면 종료 시 프로세스 종료
		setVisible(true); // 실제 게임 화면 출력
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
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