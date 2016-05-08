package gameplay;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import gameplay.Sprites.BoardTile;
import gameplay.Sprites.Enemy;
import gameplay.Sprites.Player;
import gameplay.Sprites.BoardTypes.*;

public abstract class LevelDecoder {
	public static void decodeLevel(BufferedImage image) {
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int size = BoardTile.boardTileSize;
				Color c = new Color(image.getRGB(x, y));
				if (c.equals(new Color(255, 255, 255))) {
					new Floor(new Point(x, y));
				} else if (c.equals(new Color(0, 0, 0))) {
					new Wall(new Point(x, y));
				} else if (c.equals(new Color(0, 0, 255))) {
					new Finish(new Point(x, y));
				} else {
					new Floor(new Point(x, y));
					if (c.equals(new Color(0, 255, 0))) {
						new Enemy(x*size, y*size);
					} else if (c.equals(new Color(255, 0, 0))) {
						GameController.currentLevel.player = new Player(x*size, y*size);
					}
				}
			}
		}
	}
}
