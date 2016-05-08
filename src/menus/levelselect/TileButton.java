package menus.levelselect;

import java.util.ArrayList;

import menus.Button;

public class TileButton extends Button {
	private static final long serialVersionUID = -260026316220164894L;
	public String text;
	
	public TileButton(String s) {
		super(0, 0, 0, 0);
		text = s;
	}
}
