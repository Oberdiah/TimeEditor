package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import main.Game;
import menus.MenuController;

public class MouseMotionListener extends MouseMotionAdapter {
	public static int x = 0;
	public static int y = 0;
	
	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		Game.currentController.mousemoved(x, y);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		Game.currentController.mousemoved(x, y);
	}
}
