package project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player;
	private boolean isLoop;
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
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt(); //프로그램 중지 곡 재생 종료
	}
	
	@Override
	public  void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);	// isLoop가 true값을 갖는다면 곡은 무한반복된다.
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
