package dynamicbeat;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	// ���� ���۸��� ���� ��üȭ�鿡 ���� �̹����� ��� ��ü
	
	private Image introBackground;
	// ���ÿ��� ������ �̹����� ��� ��ü
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ���� ȭ�� �ػ� ���������� ���� �Ұ���
		setLocationRelativeTo(null); // ���� ȭ�� ��� �� ��ǻ�� ���߾� ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ȭ�� ���� �� ���μ��� ����
		setVisible(true); // ���� ���� ȭ�� ���
		
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