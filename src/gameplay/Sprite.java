package gameplay;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import gameplay.Sprites.Player;
import main.Game;

public abstract class Sprite {
	public static final int boardTileSize = 100;
	
	public Rectangle rect;
	public double vx = 0;
	public double vy = 0;
	public int layer = 0;
	public Color c = Color.WHITE;
	public boolean passable = false;
	
	public Sprite(int x, int y, int width, int height, Color c, int layer) {
		GameController.currentLevel.sprites.add(this);
		rect = new Rectangle(x, y, width, height);
		this.c = c;
		this.layer = layer;
	}
	
	public boolean intersects(Sprite s) {
		return s.rect.intersects(rect);
	}
	
	public void intersected(Sprite s) {}
	public void tick() {};
}
