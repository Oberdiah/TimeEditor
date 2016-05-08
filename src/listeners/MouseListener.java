package listeners;

import java.awt.event.MouseEvent;

import main.Game;

import java.awt.event.MouseAdapter;;

public class MouseListener extends MouseAdapter {
	public static Boolean down = false;
	
	@Override
	public void mousePressed(MouseEvent e) {
		down = true;
		Game.currentController.mousepressed();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		down = false;
	}

}
