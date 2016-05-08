package menus.menus;

import java.awt.Graphics2D;
import java.awt.Point;

import menus.MenuButton;
import menus.MenuController;
import menus.MenuInterface;
import menus.levelselect.LevelSelect;

public class MainMenu extends MenuController implements MenuInterface {
	private MenuButton[] buttons = new MenuButton[]{
			new MenuButton("Play", "Play the game"),
			new MenuButton("Settings", "Change the settings"),
			new MenuButton("Controls", "Change your preferred control mode"),
			new MenuButton("Exit", "Exit the game. It's sad to see you go")
		};
	@Override
	public MenuButton[] getButtons() {
		return buttons;
	}
	
	@Override
	public void mousemoved(int x, int y) {}

	@Override
	public void mousepressed() {
		if (hover == null) return;
		switch(hover.text) {
			case "Play":
				currentMenu = new LevelSelect();
				break;
			case "Settings":
				currentMenu = new Settings();
				break;
			case "Controls":
				currentMenu = new Controls();
				break;
			case "Exit":
				System.exit(0);
				break;
			default:
				break;
		}
	}

	@Override
	public void graphicsRender(Graphics2D g, Point justify) {}
}
