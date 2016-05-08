package menus.levelselect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import gameplay.GameController;
import gameplay.Levels.*;
import main.Game;
import menus.*;
import menus.menus.*;

public class LevelSelect extends MenuController implements MenuInterface {
	static final TileButton[] tiles = new TileButton[]{
			new TileButton("The Beginning"),
			new TileButton("The Fall"),
			new TileButton("Baby love"),
			new TileButton("The Death"),
			new TileButton("Life and hope"),
			new TileButton("After the fall"),
			new TileButton("Big Balling"),
			new TileButton("Happy days"),
			new TileButton("The Darkness"),
			new TileButton("Sea of tears"),
			new TileButton("Land of sorrow"),
			new TileButton("Killing Luke"),
			new TileButton("A Duel of fates"),
			new TileButton("Sky of dreams"),
			new TileButton("Jo's rescue"),
			new TileButton("Fire Storm"),
			new TileButton("Beginning again"),
			new TileButton("Man's last joy"),
			new TileButton("Back of beyond"),
			new TileButton("Final Front"),
			new TileButton("Lost Hope"),
			new TileButton("Laughter's love"),
			new TileButton("Great Escape"),
			new TileButton(".2 Bullets"),
			new TileButton("The End"),
			new TileButton("The End - 2"),
			new TileButton("Epilogue")
	};
	static ArrayList<Button> totalButtons;
	static Button nextPage = new Button();
	static Button lastPage = new Button();
	static MenuButton back = new MenuButton("Back", "Go back");
	static final int trisize = 50;
	
	public LevelSelect() {
		nextPage.width = trisize;
		nextPage.height = trisize;
		lastPage.width = trisize;
		lastPage.height = trisize;
		back.leavePosAlone = true;
		
		totalButtons = new ArrayList<>(Arrays.asList(tiles));
		totalButtons.add(nextPage);
		totalButtons.add(lastPage);
		totalButtons.add(back);
	}
	
	private int page = 0;
	private boolean isLastPage = false;
	
	@Override
	public void mousemoved(int x, int y) {}

	@Override
	public void mousepressed() {
		if (nextPage.hover) {
			if (!isLastPage) {
				page++;
			}
		} else if (lastPage.hover) {
			if (page > 0) {
				page--;
			}
		} else if (back.hover) {
			MenuController.currentMenu = new MainMenu();
		}
		
		for (TileButton t : tiles) {
			if (t.hover) {
				new TheBeginning();
				Game.currentController = new GameController();
			}
		}
	}

	@Override
	public void graphicsRender(Graphics2D g, Point justify) {
		int f = 0;
		int frameHeight = Game.frame.getHeight();
		int frameWidth = Game.frame.getWidth();

		nextPage.y = frameHeight-trisize-60;
		lastPage.y = frameHeight-trisize-60;
		nextPage.x = frameWidth-trisize-50;
		lastPage.x = frameWidth-trisize*2-75;
		back.x = frameWidth-trisize-800;
		back.y = trisize;
		
		g.setColor(Color.WHITE);
		int up = 0;
		if (nextPage.hover) up = -5;
		g.fillPolygon(
				new int[] {nextPage.x, nextPage.x, nextPage.x+nextPage.width},
				new int[] {nextPage.y+up, nextPage.y+nextPage.height+up, nextPage.y+(nextPage.height/2)+up},
				3);
		up = 0;
		if (lastPage.hover) up = -5;
		g.fillPolygon(
				new int[] {lastPage.x+lastPage.width, lastPage.x+lastPage.width, lastPage.x},
				new int[] {lastPage.y+up, lastPage.y+lastPage.height+up, lastPage.y+(lastPage.height/2)+up},
				3);
		
		isLastPage = true;
		
		for (TileButton tile : tiles) {
			int size = 240;
			int gap = 20;
			int sigap = size+gap;
			
			int swidth = frameWidth - justify.x;
			int sheight = frameHeight - justify.y - justify.x*2 - 60;
			
			int noFitX = (int) Math.floor(swidth/sigap);
			int noFitY = (int) Math.floor(sheight/sigap);
			
			int noOnPage = noFitY*noFitX;
			int i = f - noOnPage*page;
			f++;
			if (i < 0) continue;
			if (noFitY <= Math.floor(i/noFitX)) {
				isLastPage = false;
				continue;
			}
			
			int centreBalX = (frameWidth - noFitX*sigap)/2;
			int centreBalY = (sheight - noFitY*sigap)/2;
			
			int x = ((i%noFitX)*sigap)+centreBalX;
			int y = (int) Math.floor(i/noFitX)*sigap+centreBalY+justify.y+justify.x;
					
			int move = 0;
			if (tile.hover) move = -10;
			
			tile.x = x;
			tile.y = y+move;
			tile.height = size-move;
			tile.width = size;
			
			g.setColor(new Color(235, 235, 235));
			if (tile.hover) g.setColor(new Color(255, 255, 255));
			g.fillRect(x, y+move, size, size-move);
			
			g.setColor(new Color(205, 205, 205));
			g.fillRect(x+20, y+20+move, size-40, size-100);
			
			g.setColor(Game.bgColor);
			g.setFont(new Font("Roboto Th", Font.PLAIN, 30));
			g.drawString(tile.text, x+20, y+size-40+move);
		}
	}

	@Override
	public Button[] getButtons() {
		return totalButtons.toArray(new Button[0]);
	}
}
