package interficie_grafica;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VentanaLucha extends JFrame {
	private RectanguloHP r1;
	private JPanel panel0, panel1, panel2, panel3, panel4, panel5,panel6,panel7;
	private JButton choosecharacter, chooseweapon,ranking;
	
	public VentanaLucha() {
		panel0 = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        r1 = new RectanguloHP();
        
        panel2.add(r1);
        panel0.add(panel2);
        this.add(panel0);
        
        setSize(1250, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new VentanaLucha ();

	}
	
	
}
class RectanguloHP extends JPanel {
	private int hp_user;
	private int hp_bot;
	
	public RectanguloHP() {
		hp_user = 100;
		hp_bot = 100;
		setPreferredSize(new Dimension(1250,800)); 
	}

	protected void paintComponent(Graphics g) {
		String user_life = Integer.toString(hp_user);
		String bot_life = Integer.toString(hp_bot);
		super.paintComponent(g);
		g.setColor(Color.RED);
		//barras rojas
		g.fillRect(0, 0, 500, 60);
		g.fillRect(750, 0, 500, 60);
		//barras verdes
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 500, 60);
		g.fillRect(750, 0, 500, 60);
		g.setColor(Color.BLACK);
		g.setFont(new Font("AnjaliOldLipi", Font.BOLD, 16));
		int x1 = (350 - g.getFontMetrics().stringWidth(user_life)) / 2;
		int y1 = (60 + g.getFontMetrics().getHeight()) / 2;
		g.drawString(user_life, x1, y1);
		
		
		g.drawString(bot_life,750, 0);
	}
}