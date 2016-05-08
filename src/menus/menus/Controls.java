package menus.menus;

import java.awt.Graphics2D;
import java.awt.Point;

import menus.MenuButton;
import menus.MenuController;
import menus.MenuInterface;

public class Controls extends MenuController implements MenuInterface {
	private MenuButton[] buttons = new MenuButton[]{
			new MenuButton("Back", "Go back to main menu")
			};
	@Override
	public MenuButton[] getButtons() {
		return buttons;
	}
	
	@Override
	public void mousemoved(int x, int y) {
		
	}

	@Override
	public void mousepressed() {
		if (hover == null) return;
		switch(hover.text) {
			case "Back":
				currentMenu = new MainMenu();
				break;
			default:
				break;
		}
	}

	@Override
	public void graphicsRender(Graphics2D g, Point p) { }
}
