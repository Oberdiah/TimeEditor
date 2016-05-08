package gameplay;

import java.awt.Color;
import java.awt.Graphics2D;

import gameplay.Sprites.BoardTile;
import gameplay.Sprites.Player;
import main.Controller;
import main.Game;

public class GameController implements Controller {

	public static Level currentLevel;
	
	@Override
	public void keypressed(String k) {
		
	}

	@Override
	public void mousemoved(int x, int y) {
		
	}

	@Override
	public void mousepressed() {
		
	}

	@Override
	public void graphicsRender(Graphics2D g) {
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, Game.frame.getWidth(), Game.frame.getHeight());
		
		TickController.tick();
		
		LevelRendering.renderLevel(g);
		
		currentLevel.render(g);
	}
	
}
