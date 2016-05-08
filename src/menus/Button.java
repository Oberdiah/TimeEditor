package menus;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Button extends Rectangle {
	private static final long serialVersionUID = -2716213317237964540L;
	public boolean hover = false;
	
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public Button() {
		super(0,0,0,0);
	}
}
