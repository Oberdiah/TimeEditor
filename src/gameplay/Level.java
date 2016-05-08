package gameplay;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import gameplay.Sprites.BoardTile;
import gameplay.Sprites.Player;
import main.Game;

public abstract class Level implements LevelInterface {
	public BoardTile[][] tiles = new BoardTile[1000][1000];
	public ArrayList<Sprite> sprites = new ArrayList<>();
	public Player player;
	
	public Level(String path) {
		GameController.currentLevel = this;
		try {
			LevelDecoder.decodeLevel(ImageIO.read(new File("levels/" + path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BoardTile[][] getTiles() {
		return tiles;
		
	}

	@Override
	public Player getPlayer() {
		return player;
	}
}
