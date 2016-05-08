package gameplay.Sprites.BoardTypes;

import java.awt.Color;
import java.awt.Point;

import gameplay.Sprites.BoardTile;

public class Wall extends BoardTile {
	public Wall(Point p) {
		super(p, Color.WHITE);
	}
}
