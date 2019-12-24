package dynamicbeat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위한 전체 화면에 대한 이미지 객체
	
	private Image introBackground  = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	// 로컬에서 가져온 이미지를 불러올 객체
	
	private ImageIcon shutdownBasicImage = new ImageIcon(Main.class.getResource("../images/shutdownButton_Entered.png"));
	private ImageIcon shutdownEnteredImage = new ImageIcon(Main.class.getResource("../images/shutdownButton_Basic.png"));
	private ImageIcon startBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton shutdownButton = new JButton(shutdownBasicImage);
	private JButton startButton = new JButton(startBasicImage);
	private JButton quitButton = new JButton(quitBasicImage);
	
	private int mouseX, mouseY; // 화면 창에서 마우스의 좌표 얻을 변수
	
	public DynamicBeat() {
		setUndecorated(true); // 기본적으로 존재하는 메뉴바 숨김
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 사용자가 임의로 창 조절 불가
		setLocationRelativeTo(null); // 화면 실행 시 컴퓨터의 정중앙으로 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 종료하면 프로세스 종료
		setVisible(true); // 실제 게임 화면 출력
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null); // 버튼이나 JLable등을 나타냄
		
		
		shutdownButton.setBounds(1245, 0, 32, 32);
		shutdownButton.setBorderPainted(false); // 버튼 테두리 설정
		shutdownButton.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		shutdownButton.setFocusPainted(false); // 포커스 표시 설정
		shutdownButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				shutdownButton.setIcon(shutdownEnteredImage);
				shutdownButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				shutdownButton.setIcon(shutdownBasicImage);
				shutdownButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch(Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		add(shutdownButton);
		
		menuBar.setBounds(0, 0, 1280, 32);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				// 클릭 이벤트 발생 시 해당 좌표를 얻는 이벤트 처리기
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
				// 드래그 이벤트 발생 시 순간순간마다 x좌표와 y좌표를 얻어와서 게임화면 창의 위치를 바꿔줌
			}
		});
		add(menuBar);
		
		startButton.setBounds(20, 150, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		add(startButton);
		
		quitButton.setBounds(20, 270, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch(Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
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
		paintComponents(g); // JLabel과 같이 고정적으로 존재하는 이미지에 사용
		this.repaint();
	}
}