package gameplay.Sprites;

import java.awt.Color;
import java.awt.Point;

import gameplay.GameController;
import gameplay.Sprite;

public class BoardTile extends Sprite {
	public BoardTile(Point p, Color c) {
		super(p.x*boardTileSize, p.y*boardTileSize, boardTileSize, boardTileSize, c, 0);
		GameController.currentLevel.tiles[p.x][p.y] = this;
	}

	@Override
	public void tick() {}
}
