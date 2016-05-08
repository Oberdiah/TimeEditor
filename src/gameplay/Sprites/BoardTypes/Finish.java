package gameplay.Sprites.BoardTypes;

import java.awt.Color;
import java.awt.Point;

import gameplay.Sprites.BoardTile;

public class Finish extends BoardTile {
	public Finish(Point p) {
		super(p, new Color(0, 0, 255));
	}
}
