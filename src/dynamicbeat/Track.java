package dynamicbeat;

public class Track {
	 private String titleImage; // 게임 선택시 제목 이미지
	 private String startImage; // 게임 선택시 시작 이미지
	 private String startMusic; // 게임 선택시 하이라이트 음악
	 private String gameMusic; // 게임 실행시 음악
	 private String titleName; // 곡 이름
	 
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public Track(String titleImage, String startImage, String startMusic,
			String gameMusic, String titleName) {
		
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}
}
