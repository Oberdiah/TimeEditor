package gameplay;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import gameplay.Sprites.BoardTile;
import gameplay.Sprites.Player;

public interface LevelInterface {
	BoardTile[][] getTiles();
	Player getPlayer();
	void render(Graphics2D g);
}
