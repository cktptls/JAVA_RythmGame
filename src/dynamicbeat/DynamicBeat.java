package dynamicbeat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위한 전체 화면에 대한 이미지 객체
	
	private Image Background  = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	// 로컬에서 가져온 이미지
	
	private ImageIcon shutdownBasicImage = new ImageIcon(Main.class.getResource("../images/shutdownButton_Basic.png"));
	private ImageIcon shutdownEnteredImage = new ImageIcon(Main.class.getResource("../images/shutdownButton_Entered.png"));
	private ImageIcon startBasicImage = new ImageIcon(Main.class.getResource("../images/startButton_Basic.png"));
	private ImageIcon startEnteredImage = new ImageIcon(Main.class.getResource("../images/startButton_Entered.png"));
	private ImageIcon quitBasicImage = new ImageIcon(Main.class.getResource("../images/quitButton_Basic.png"));
	private ImageIcon quitEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButton_Entered.png"));
	private ImageIcon rightBasicImage = new ImageIcon(Main.class.getResource("../images/rightButton_Basic.png"));
	private ImageIcon rightEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButton_Entered.png"));
	private ImageIcon leftBasicImage = new ImageIcon(Main.class.getResource("../images/leftButton_Basic.png"));
	private ImageIcon leftEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButton_Entered.png"));
	private ImageIcon selectedLevelEasyBasicImage = new ImageIcon(Main.class.getResource("../images/selectedLevel EASY Basic.png"));
	private ImageIcon selectedLevelEasyEnteredImage = new ImageIcon(Main.class.getResource("../images/selectedLevel EASY Pressed.png"));
	private ImageIcon selectedLevelHardBasicImage = new ImageIcon(Main.class.getResource("../images/selectedLevel HARD Basic.png"));
	private ImageIcon selectedLevelHardEnteredImage = new ImageIcon(Main.class.getResource("../images/selectedLevel HARD Pressed.png"));

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	private JButton shutdownButton = new JButton(shutdownBasicImage);
	private JButton startButton = new JButton(startBasicImage);
	private JButton quitButton = new JButton(quitBasicImage);
	private JButton rightButton = new JButton(rightBasicImage);
	private JButton leftButton = new JButton(leftBasicImage);
	private JButton easyButton = new JButton(selectedLevelEasyBasicImage);
	private JButton hardButton = new JButton(selectedLevelHardBasicImage);
	
	private int mouseX, mouseY;		// 화면 창에서 마우스의 좌표 얻을 변수
	
	private boolean isMainScreen = false; // 메인화면인지 시작화면인지 판단하는 변수. 시작화면에서 메인화면으로 넘어갈 때 true값
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Music selectedMusic;	// 현재 선택된 곡의 하이라이트 음악
	private Image selectedImage;	// 현재 선택된 곡의 시작 이미지
	private Image titleImage;		// 현재 선택된 곡의 제목 이미지
	private int nowSelected = 0;	// 현재 선택된 번호 의미. 인덱스이기 때문에 기본 0 값
	
	
	public DynamicBeat() {
		setUndecorated(true);			// 기본적으로 존재하는 메뉴바 숨김
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);			// 사용자가 임의로 창 조절 불가
		setLocationRelativeTo(null);	// 화면 실행 시 컴퓨터의 정중앙으로 출력
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램을 종료하면 프로세스 자체 종료
		setVisible(true); 				// 실제 게임 화면 출력
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null); 				// 버튼이나 JLable등을 나타냄
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		trackList.add(new Track("Joakim Karud - Mighty Love Title.png", "Joakim Karud - Mighty Love Image.png",
				"Joakim Karud - Mighty Love Image.png", "Joakim Karud - Mighty Love Highright.mp3", "Joakim Karud - Mighty Love.mp3"));
		trackList.add(new Track("Joakim Karud - Dreams Title.png", "Joakim Karud - Dreams Image.png",
				"Joakim Karud - Mighty Love Image.png", "Joakim Karud - Dreams Highright.mp3", "Joakim Karud - Dreams.mp3"));
		trackList.add(new Track("HYP - Dynamic Summer Title.png", "HYP - Dynamic Summer Image.png",
				"HYP - Dynamic Summer Image.png", "HYP - Dynamic Summer Highright.mp3", "HYP - Dynamic Summer.mp3"));

		shutdownButton.setBounds(1245, 0, 32, 32);
		shutdownButton.setBorderPainted(false); 	// 버튼 테두리 설정
		shutdownButton.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		shutdownButton.setFocusPainted(false); 		// 포커스 표시 설정
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
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				introMusic.close();
				selectedTrack(0);
				
				startButton.setVisible(false);
				quitButton.setVisible(false);
				rightButton.setVisible(true);
				leftButton.setVisible(true);
				easyButton.setVisible(true);
				hardButton.setVisible(true);
				Background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				// introBackground의 배경 화면을 mainBackgorund의 게임화면으로 전환
				isMainScreen = true;
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
		
		leftButton.setBounds(140, 300, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.setVisible(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectedLeft();
			}
		});
		add(leftButton);
		
		rightButton.setBounds(1040, 300, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.setVisible(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectedRight();
			}
		});
		add(rightButton);
		
		easyButton.setBounds(350, 600, 275, 80);
		easyButton.setContentAreaFilled(false);
		easyButton.setBorderPainted(false);
		easyButton.setFocusPainted(false);
		easyButton.setVisible(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(selectedLevelEasyEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(selectedLevelEasyBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// !!이지버튼 이벤트 처리!!
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
			}
		});
		add(easyButton);
		
		hardButton.setBounds(645, 600, 275, 80);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.setVisible(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(selectedLevelHardEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(selectedLevelHardBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// !!하드 버튼 이벤트 처리!!
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
			}
		});
		add(hardButton);
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null); // 일반적인 이미지, 역동적인 이미지 등은 draw이미지 함수로 이용
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 150, null);
			g.drawImage(titleImage, 340, 35, null);
		}
		paintComponents(g); // JLabel과 같이 add()를 이용한 고정적으로 존재하는 이미지에 사용
		this.repaint();
	}
	
	public void selectedTrack(int nowSelected) { // 현재 선택된 곡의 번호 입력받음
		if(selectedMusic != null) {
			selectedMusic.close(); // 어떠한 곡이 실행중에 있다면 종료
		}
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		// 현재 선택된 곡이 가지고 있는 titleImage를 가져옴
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		// 현재 선택된 곡이 가지고 있는 startImage를 가져옴
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectedLeft() {
		if(nowSelected == 0) {
			nowSelected = trackList.size() - 1; // 제일 첫 곡(0번째 곡)일 때 왼쪽 버튼 클릭 시 마지막 곡으로 이동
		}
		else
			nowSelected--;
		selectedTrack(nowSelected);
	}
	
	public void selectedRight() {
		if(nowSelected == trackList.size() - 1) {
			nowSelected = 0; // 제일 마지막 곡일 때 오른쪽 버튼 클릭 시 첫 곡으로 이동
		}
		else
			nowSelected++;
		selectedTrack(nowSelected);
	}
}