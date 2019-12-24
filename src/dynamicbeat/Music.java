package dynamicbeat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private Player player; // 자바 zoom 사이트에서 받은 라이브러리
	private boolean isLoop; // 곡이 무한반복인지 한번 재생 후 꺼지는지 판단 변수
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		// Thread를 상속받을 시 무조건 사용해야하는 음악 실행 함수
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while(isLoop);
			// isLoop가 True값을 가질 경우 무한 반복
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
