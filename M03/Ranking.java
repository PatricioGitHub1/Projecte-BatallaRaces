package ventanas;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
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

import javax.imageio.ImageIO;
import javax.swing.*;

public class Ranking extends JFrame {
	private JPanel p0,p1,p2,p3,panel1;
	private JLabel titulo,subtitulo,creators;
	private JButton back,exit;
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "Admin1234";
	

	public Ranking() {
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		back = new JButton("Back");
		exit = new JButton("Exit");
		p2.add(back);
		p2.add(exit);
		panel1 = new JPanel() {
			private BufferedImage image;
			private int newWidth = 1250;
			private int newHeight = 600;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					image = ImageIO.read(new File("../PROYECTO_FINAL/src/proyecto/portada.jpg"));
					g.drawImage(image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		titulo = new JLabel("Ranking");
		Font font = new Font("Dialog", Font.BOLD, 30);
		titulo.setFont(font);
		subtitulo = new JLabel("Top 10 of players");
		Font font1 = new Font("Arial", Font.BOLD, 20);
		subtitulo.setFont(font1);
		p1.add(titulo);
		p1.add(subtitulo);
		creators = new JLabel("By Cristian Alvarez | Alex Martinez | Patricio");
		creators.setFont(new Font("Abyssinica SIL", Font.ITALIC, 10));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
			String query = "select * from PLAYERS order by Total_Points desc limit 10;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
					JLabel label = new JLabel(rs.getString("Player_name"));
					label.setText(label.getText()+"                   "+(Integer.toString(rs.getInt("Total_points"))));
					Font font3 = new Font("Arial", Font.PLAIN, 18);
					label.setFont(font3);
					p1.add(label);
	        }
			

		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println(y.getMessage());
			System.out.println("Conexion no creada con exito!!");
		}
		
		p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		
		p0.add(panel1);
		p0.add(p1,BorderLayout.CENTER);
		p3.add(creators);
		p0.add(p2);
		p0.add(p3);
		p0.setLayout(null);
		panel1.setBounds(0, 0, 1250, 400);
		p1.setBounds(550, 400, 1250, 280);
		p2.setBounds(0, 680, 1250, 50);
		p3.setBounds(0, 740, 1250, 50);
		this.add(p0);
		
		setSize(1250, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	public static void main(String[] args) {
		new Ranking();
		
	}
}
