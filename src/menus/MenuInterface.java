package menus;

import java.awt.Graphics2D;
import java.awt.Point;

public interface MenuInterface{
	void graphicsRender(Graphics2D g, Point justify);
	void mousemoved(int x, int y);
	void mousepressed();
	Button[] getButtons();
}
