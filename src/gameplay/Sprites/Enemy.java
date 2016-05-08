package gameplay.Sprites;

import java.awt.Color;

import gameplay.GameController;
import gameplay.Sprite;
import gameplay.Levels.TheBeginning;
import main.Game;
import gameplay.GameController.*;

public class Enemy extends Sprite {
	public Enemy(int x, int y) {
		super(x, y, boardTileSize, boardTileSize, new Color(102, 0, 204), 1);
	}
	
	public static Player p = GameController.currentLevel.player;
	public final int speed = 5;
	
	@Override
	public void tick() {
		double x = p.rect.x - rect.x;
		double y = p.rect.y - rect.y;
		double hyp = Math.sqrt(x*x + y*y);
		x /= hyp;
		y /= hyp;
		
		vx = x*speed;
		vy = y*speed;
	}
	
	@Override
	public void intersected(Sprite s) {
		Game.print(s.rect.x + " " + s.rect.y);
		if (s.equals(p)) {
			GameController.currentLevel = new TheBeginning();
		}
	}
}
