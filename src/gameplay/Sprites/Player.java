package gameplay.Sprites;

import java.awt.Color;

import gameplay.GameController;
import gameplay.Sprite;
import listeners.KeyListener;
import main.Game;

public class Player extends Sprite {
	public int speed = 10;
	
	public Player(int x, int y) {
		super(x, y, boardTileSize, boardTileSize, Color.red, 10);
	}
	@Override
	public void tick() {
		vx = 0;
		vy = 0;
		if (KeyListener.isPressed("a")) vx = -speed;
		if (KeyListener.isPressed("d")) vx = speed;
		if (KeyListener.isPressed("w")) vy = -speed;
		if (KeyListener.isPressed("s")) vy = speed;
	}
}
