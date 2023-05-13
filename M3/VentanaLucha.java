

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

public class VentanaLucha extends JFrame {
	private static VentanaLucha instance;
	private PlayersImage playimage;
	private JPanel panel0, panel1, panel2, panel3;
	private JButton chooseCharacter, chooseWeapon,ranking,fight,clear;
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	private JTextArea console;
	private Fight f;
	private BBDD bd;
	
	public VentanaLucha(String userimg, String userweapon, String botimg, String botweapon,int id,String username,Warrior warrior_enemy, Weapons weapons_enemy,Warrior user_warrior,Weapons user_weapon) {
		instance = this;
		panel0 = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        clear = new JButton("Clear Console");
        bd = new BBDD();
        
        console = new JTextArea();
        console.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(console);
        clear.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearConsole();

                    }
                });

        playimage = new PlayersImage(userimg,userweapon,botimg,botweapon);
        chooseCharacter = new JButton("Choose Character");
        chooseWeapon = new JButton("Choose Weapon");
        ranking = new JButton("Ranking");
        fight = new JButton("Fight");
        
        
        panel1.add(chooseCharacter);
        panel1.add(chooseWeapon);
        panel1.add(ranking);
        panel2.add(playimage);
        panel2.add(fight);
        panel2.add(clear);
        
        scrollPane.setPreferredSize(new Dimension(200, 80));
        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);
        
        panel0.add(panel1);
        panel0.add(panel2);
        panel0.add(panel3);
        panel0.add(scrollPane);
		f=new Fight( userimg,  userweapon,  botimg,  botweapon);

        ranking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ranking();
				
			}
		});
        
        chooseCharacter.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (f.getRounds()>=1) {
					f.getRoundsarray().clear();
					bd.updatePlayer(username, f.getTotal_points());
					
				}
				dispose();
				new FrameWarriors(username);
				
			}
		});
        
        chooseWeapon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (userimg!="./imagenes/-.jpg") {
					clearConsole();
					dispose();
					new FrameWeapons(id,userimg,username,botimg,botweapon,warrior_enemy,weapons_enemy,user_warrior,user_weapon);
				}else {
					consoleText("Tienes que elegir primer un guerrero");
				}
				
				
			}
		});
        
        fight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (userimg!="./imagenes/-.jpg" && userweapon!="./imagenes/-.jpg") {
					f.lucha(username, warrior_enemy, weapons_enemy, user_warrior, user_weapon);
				}
				
			}
		});
        
        this.add(panel0);
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
        
        setSize(1250, 800);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	public void clearConsole() {
        console.setText("");
    }
	public void consoleText(String text) {
        console.append(text+"\n");
    }
	
	public static VentanaLucha getInstance() {
	    return instance;
	}
	
	
	
	
	
	
}

class PlayersImage extends JPanel{
	private JPanel panel2,panel3;
	
	private BufferedImage userImage;
	private BufferedImage botImage,versus;
	private int characterimageWidth = 501;
    private int charaterimageHeight = 370;
    private JLabel usupower,usuagility,ususpeed,usudefense,botpower,botagility,botspeed,botdefense;
    
	private BufferedImage userweaponImage;
	private BufferedImage botweaponImage;
	private int weaponimageWidth = 140;
    private int weaponimageHeight = 98;
    
    private int hp_user;
	private int hp_bot;
	private String userimg1,userweapon1,botimg1,botweapon1;
	
	public PlayersImage() {
		// TODO Auto-generated constructor stub
	}
    
    public PlayersImage(String userimg, String userweapon, String botimg, String botweapon) {
    	userimg1 = userimg;
    	userweapon1 = userweapon;
    	botimg1 = botimg;
    	botweapon1 = botweapon;
    	hp_user = 100;
		hp_bot = 100;
		setPreferredSize(new Dimension(1250,525));
		setOpaque(false);
		
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
		usupower = new JLabel("Power");
		usuagility = new JLabel("Agility");
		ususpeed = new JLabel("Apeed");
		usudefense = new JLabel("Defense");
		
		usupower.setFont(new Font("Arial", Font.BOLD, 20));
		usuagility.setFont(new Font("Arial", Font.BOLD, 20));
		ususpeed.setFont(new Font("Arial", Font.BOLD, 20));
		usudefense.setFont(new Font("Arial", Font.BOLD, 20));
		
		botpower = new JLabel("Power");
		botagility = new JLabel("Agility");
		botspeed = new JLabel("Apeed");
		botdefense = new JLabel("Defense");
		
		botpower.setFont(new Font("Arial", Font.BOLD, 20));
		botagility.setFont(new Font("Arial", Font.BOLD, 20));
		botspeed.setFont(new Font("Arial", Font.BOLD, 20));
		botdefense.setFont(new Font("Arial", Font.BOLD, 20));
		
		
		
		panel2.add(usupower);
		panel2.add(usuagility);
		panel2.add(ususpeed);
		panel2.add(usudefense);
		
		panel3.add(botpower);
		panel3.add(botagility);
		panel3.add(botspeed);
		panel3.add(botdefense);
		this.setLayout(null);
		panel2.setBounds(150, 431, 100, 95);
		panel3.setBounds(900, 431, 100, 95);
		this.add(panel2);
		this.add(panel3);
		
		
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // VIDA DE USUARIO Y DEL ENEMIGO
        String user_life = Integer.toString(hp_user)+"%";
		String bot_life = Integer.toString(hp_bot)+"%";
		// Link de la foto character
		String linkcharacteruser = userimg1;
		String linkcharacterbot = botimg1;
		// Link de la foto weapon
		String linkweaponuser = userweapon1;
		String linkweaponbot = botweapon1;
		
		
		
        
		
		
		//se cambia el tercer valor a menor
		//power
		g.setColor(Color.red);
		g.fillRect(301, 432, 199, 22); 
		//agiliti
		g.setColor(Color.green);
		g.fillRect(301, 455, 199, 22);
		//speed
		g.setColor(Color.blue);
		g.fillRect(301, 478, 199, 22);
		//def
		g.setColor(Color.darkGray);
		g.fillRect(301, 501, 199, 22);
		
		
		
		
		//se cambia el tercer valor a menor
		//power
		g.setColor(Color.red);
		g.fillRect(1050, 432, 199, 22); 
		//agiliti
		g.setColor(Color.green);
		g.fillRect(1050, 455, 199, 22);
		//speed
		g.setColor(Color.blue);
		g.fillRect(1050, 478, 199, 22);
		//def
		g.setColor(Color.darkGray);
		g.fillRect(1050, 501, 199, 22);
		
		//versus
		try {
        	//foto usuario
        	versus = ImageIO.read(new File("./imagenes/versus.jpg"));
            g.drawImage(versus.getScaledInstance(characterimageWidth, charaterimageHeight, Image.SCALE_SMOOTH), 385, 61, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		// IMAGENES CHARACTERS
        try {
        	//foto usuario
        	userImage = ImageIO.read(new File(linkcharacteruser));
            g.drawImage(userImage.getScaledInstance(characterimageWidth, charaterimageHeight, Image.SCALE_SMOOTH), 0, 61, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        	//foto bot
            botImage = ImageIO.read(new File(linkcharacterbot));
            g.drawImage(botImage.getScaledInstance(characterimageWidth, charaterimageHeight, Image.SCALE_SMOOTH), 750, 61, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //IMAGENES WEAPONS
        try {
        	//foto usuario
        	userweaponImage = ImageIO.read(new File(linkweaponuser));
            g.drawImage(userweaponImage.getScaledInstance(weaponimageWidth, weaponimageHeight, Image.SCALE_SMOOTH), 0, 431, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        	//foto bot
        	botweaponImage = ImageIO.read(new File(linkweaponbot));
            g.drawImage(botweaponImage.getScaledInstance(weaponimageWidth, weaponimageHeight, Image.SCALE_SMOOTH), 750, 431, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void hola() {
    	System.out.println("hola");
    }
    
}
