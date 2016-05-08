package menus.menus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedHashMap;

import main.Game;
import menus.MenuButton;
import menus.MenuController;
import menus.MenuInterface;

public class Settings extends MenuController implements MenuInterface {
	private MenuButton[] buttons = new MenuButton[]{
			new MenuButton("Sound:", "On").subtext(true),
			new MenuButton("Background Color:", "Reddish").subtext(true),
			new MenuButton("Back", "Go back to main menu")
			};
	
	Color[] colors = new Color[]{new Color(0, 100, 0), new Color(0, 0, 100), new Color(100, 0, 0), new Color(152, 90, 87)};
	String[] colorNames = new String[]{"Green", "Blue", "Red", "Reddish"};
	
	private int bgpos = 0;
	private Boolean sound = true;
	
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
			case "Back":
				currentMenu = new MainMenu();
				break;
			case "Sound:":
				sound = !sound;
				if (sound) {
					((MenuButton) hover).subText = "On";
				} else {
					((MenuButton) hover).subText = "Off";
				}
				break;
			case "Background Color:":
				bgpos++;
				if (bgpos > colors.length-1) {
					bgpos = 0;
				}
				Game.bgColor = colors[bgpos];
				((MenuButton) hover).subText = colorNames[bgpos];
				break;
			default:
				break;
		}
	}

	@Override
	public void graphicsRender(Graphics2D g, Point p) {
	}
}
