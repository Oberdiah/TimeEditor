package main;

import java.awt.Graphics2D;

public interface Controller {
	void keypressed(String k);
	void mousemoved(int x, int y);
	void mousepressed();
	void graphicsRender(Graphics2D g);
}
