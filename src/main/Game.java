package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.KeyListener;
import listeners.MouseListener;
import listeners.MouseMotionListener;
import menus.MenuController;

@SuppressWarnings("serial")
public class Game extends JPanel {
	public static void print(Object s) { System.out.println(s); }
	public static Controller currentController = new MenuController();
    public static JFrame frame = new JFrame("Game ver. 0.0.0.1");
    public static Color bgColor = new Color(152, 90, 87);
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 0));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        currentController.graphicsRender(g2d);
    }
    
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
     
        JTextField textField = new JTextField();
        textField.addKeyListener(new KeyListener());
        game.addMouseListener(new MouseListener());
        game.addMouseMotionListener(new MouseMotionListener());
        frame.add(textField);
        frame.add(game);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            game.repaint();
            Thread.sleep(10);
        }
    }
}
