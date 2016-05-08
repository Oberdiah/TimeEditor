package gameplay;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import gameplay.Sprites.Player;
import main.Game;

public class LevelRendering {
	public static final double zoom = 0.4;
	public static Player p = GameController.currentLevel.player;
	
	public static void renderLevel(Graphics2D g) {
		HashMap<Integer, ArrayList<Sprite>> spriteLevels = new HashMap<>();
		for (Sprite s : GameController.currentLevel.sprites) {
			if (!spriteLevels.containsKey(s.layer)) spriteLevels.put(s.layer, new ArrayList<Sprite>());
			spriteLevels.get(s.layer).add(s);
		}
		int maxLevel = 0;
		for (Integer i : spriteLevels.keySet()) {
			if (i > maxLevel) {
				maxLevel = i;
			}
		}
		
		for (int i = 0; i <= maxLevel; i++) {
			if (spriteLevels.containsKey(i)) {
				for (Sprite s : spriteLevels.get(i)) {
					g.setColor(s.c);
					int x = (int) ((s.rect.x - p.rect.x)*zoom + Game.frame.getWidth()/2);
					int y = (int) ((s.rect.y - p.rect.y)*zoom + Game.frame.getHeight()/2);
					
					g.fillRect(x, y, (int) (s.rect.width*zoom), (int) (s.rect.height*zoom));
				}
			}
		}
	}
}
