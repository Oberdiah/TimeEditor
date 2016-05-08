package gameplay.Sprites.BoardTypes;

import java.awt.Color;
import java.awt.Point;

import gameplay.Sprites.BoardTile;

public class Floor extends BoardTile {
	public Floor(Point p) {
		super(p, Color.BLACK);
		passable = true;
	}
}
