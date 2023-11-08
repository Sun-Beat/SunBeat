package project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(SunBeat.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			SunBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			SunBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			SunBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			SunBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			SunBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			SunBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			SunBeat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(SunBeat.game == null)
			return;
		if(e.getKeyCode() == KeyEvent.VK_S) {
			SunBeat.game.releaseS();
    	}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			SunBeat.game.releaseD();
    	}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			SunBeat.game.releaseF();
    	}           
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			SunBeat.game.releaseSpace();
    	}           
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			SunBeat.game.releaseJ();
    	}           	
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			SunBeat.game.releaseK();
    	}           	
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			SunBeat.game.releaseL();
    	}           
	}

}