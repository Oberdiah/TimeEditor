package menus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

import main.Controller;
import main.Game;
import menus.menus.MainMenu;

public class MenuController implements Controller {
	public static MenuInterface currentMenu = new MainMenu();
	public static MenuButton hover = null;
	
	@Override
	public void keypressed(String k) {}

	@Override
	public void mousemoved(int x, int y) {
		currentMenu.mousemoved(x, y);
		
		hover = null;
		for (Button b : currentMenu.getButtons()) {
			b.hover = false;
			if (x > b.x && x < b.x + b.width) {
				if (y > b.y && y < b.y + b.height) {
					b.hover = true;
					if (b instanceof MenuButton) hover = (MenuButton) b;
				}
			}
		}
	}
	
	final int yOff = 120;
	final int xOff = 50;
	
	@Override
	public void mousepressed() {
		currentMenu.mousepressed();
	}

	public void buttonRender(Graphics2D g) {
		final int height = 60;
		int dy = 0;
		for (Button bb : currentMenu.getButtons()) {
			if (bb instanceof MenuButton) {
				MenuButton b = (MenuButton) bb;
				
				if (!b.leavePosAlone) b.y = yOff+height+30+dy;
				
				g.setColor(new Color(235, 235, 235));
				if (b.hover) g.setColor(new Color(255, 255, 255));
				
				if (b.height == 0) b.height = height;
				if (b.hover || b.showSubText) {
					if (b.height < 100) {
						b.height += 10;
					}
					
					if (!b.leavePosAlone) {
						b.x = xOff - 10;
						b.width = 820;
					}
				} else {
					if (b.height > 60) {
						b.height -= 10;
					}
					if (!b.leavePosAlone) b.x = xOff;
					b.width = 800;
				}
				
				g.fillRect(b.x, b.y, b.width, b.height);
				
				g.setColor(Game.bgColor);
				
				if (b.hover || b.showSubText) {
					g.setFont(new Font("Roboto Th", Font.PLAIN, 30));
					g.drawString(b.subText, b.x+20, b.y+b.height-15);
				}
				
				g.setFont(new Font("Roboto Th", Font.PLAIN, 45));
				g.drawString(b.text, b.x+20, b.y+height-15);
				
				dy += b.height + 30;
			}
		}
	}
	
	@Override
	public void graphicsRender(Graphics2D g) {
		g.setColor(Game.bgColor);
		g.fillRect(0, 0, Game.frame.getWidth(), Game.frame.getHeight());
		g.setColor(new Color(255,255,255));
		g.setFont(new Font("Roboto Th", Font.PLAIN, 100));
		g.drawString("Trekk", xOff, yOff);
		g.setStroke(new BasicStroke(3));
		g.drawLine(xOff, yOff+30, xOff+550, yOff+30);
		
		buttonRender(g);
		
		currentMenu.graphicsRender(g, new Point(xOff, yOff+30));
	}
}
