

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
        if(user_warrior instanceof Elf) {
			playimage.userMaximum(40);
		}else if (user_warrior instanceof Human) {
			playimage.userMaximum(50);
		}else if (user_warrior instanceof Dwarf){
			playimage.userMaximum(60);
		}
		if(warrior_enemy instanceof Elf) {
			playimage.botMaximum(40);
		}else if (warrior_enemy instanceof Human) {
			playimage.botMaximum(50);
		}else if (warrior_enemy instanceof Dwarf){
			playimage.botMaximum(60);
		}
        
        
        
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
		f=new Fight();
		
		
		

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
					f.setTotal_points(0);
					f.getRoundsarray().clear();
					
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
					new FrameWeapons(id,userimg,username,botimg,botweapon,warrior_enemy,weapons_enemy,user_warrior);
				}else {
					consoleText("Tienes que elegir primer un guerrero");
				}
				
				
			}
		});
        
        fight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (userimg!="./imagenes/-.jpg" && userweapon!="./imagenes/-.jpg") {
					if (warrior_enemy.getHealth()<=0 || user_warrior.getHealth()<=0) {
						f.setRounds(0);
						
						if (warrior_enemy.getHealth()<=0) {
							f.setTotal_points(warrior_enemy.getPoints_value()+weapons_enemy.getPoints_value());
							bd.insertBattle(bd.cogerId(),user_warrior.getId(),user_weapon.getId(),warrior_enemy.getId(),weapons_enemy.getId(), warrior_enemy.getInitial_health()-warrior_enemy.getHealth(), user_warrior.getInitial_health()-user_warrior.getHealth(),f.getTotal_points());
							bd.addRounds(f.getRoundsarray());
							f.getRoundsarray().clear();
						}else if(user_warrior.getHealth()<=0) {
							bd.insertBattle(bd.cogerId(),user_warrior.getId(),user_weapon.getId(),warrior_enemy.getId(),weapons_enemy.getId(), warrior_enemy.getInitial_health()-warrior_enemy.getHealth(), user_warrior.getInitial_health()-user_warrior.getHealth(),0);
							bd.addRounds(f.getRoundsarray());
							f.getRoundsarray().clear();
						}
						new EndFightWindow(user_warrior,warrior_enemy,username,f.getTotal_points(),user_weapon);
					}else {
						f.lucha(username, warrior_enemy, weapons_enemy, user_warrior, user_weapon);
						playimage.userProgBar(user_warrior.getHealth());
						playimage.botProgBar(warrior_enemy.getHealth());
						playimage.userAgilitiBar(user_warrior.getAgility()*10);
						playimage.userDefBar(user_warrior.getDefense()*10);
						playimage.userPowerBar(user_warrior.getStrength()+user_weapon.getStrength()*10);
						playimage.userSpeedBar(user_warrior.getSpeed()+user_weapon.getSpeed()*10);
						playimage.botAgilitiBar(warrior_enemy.getAgility()*10);
						playimage.botDefBar(warrior_enemy.getDefense()*10);
						playimage.botPowerBar(warrior_enemy.getStrength()+weapons_enemy.getStrength()*10);
						playimage.botSpeedBar(warrior_enemy.getSpeed()+weapons_enemy.getSpeed()*10);

					}
					
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
    
    private JProgressBar barrabot,barrauser,barrausupower,barrausuagility,barraususpeed,barrausudefense,bbrrabotpower,bbrrabotagility,bbrrabotspeed,bbrrabotdefense;
	private String userimg1,userweapon1,botimg1,botweapon1;
	
	
    
    public PlayersImage(String userimg, String userweapon, String botimg, String botweapon) {
    	userimg1 = userimg;
    	userweapon1 = userweapon;
    	botimg1 = botimg;
    	botweapon1 = botweapon;
		setPreferredSize(new Dimension(1250,525));
		setOpaque(false);
		
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
		usupower = new JLabel("Power");
		usuagility = new JLabel("Agility");
		ususpeed = new JLabel("Speed");
		usudefense = new JLabel("Defense");
		
		usupower.setFont(new Font("Arial", Font.BOLD, 20));
		usuagility.setFont(new Font("Arial", Font.BOLD, 20));
		ususpeed.setFont(new Font("Arial", Font.BOLD, 20));
		usudefense.setFont(new Font("Arial", Font.BOLD, 20));
		
		botpower = new JLabel("Power");
		botagility = new JLabel("Agility");
		botspeed = new JLabel("Speed");
		botdefense = new JLabel("Defense");
		
		botpower.setFont(new Font("Arial", Font.BOLD, 20));
		botagility.setFont(new Font("Arial", Font.BOLD, 20));
		botspeed.setFont(new Font("Arial", Font.BOLD, 20));
		botdefense.setFont(new Font("Arial", Font.BOLD, 20));
		Font font = new Font("Arial", Font.BOLD, 15);
		
		// BARRA PROGRESION ARMA
		barrausupower = new JProgressBar();
		barrausuagility = new JProgressBar();
		barraususpeed = new JProgressBar();
		barrausudefense = new JProgressBar();
		
		bbrrabotpower = new JProgressBar();
		bbrrabotagility = new JProgressBar();
		bbrrabotspeed = new JProgressBar();
		bbrrabotdefense = new JProgressBar();
		
		barrausupower.setMinimum(0);
		barrausupower.setMaximum(100);
		barrausupower.setValue(0);
		barrausupower.setForeground(Color.red);
		barrausupower.setBackground(Color.white);

		barrausuagility.setMinimum(0);
		barrausuagility.setMaximum(100);
		barrausuagility.setValue(0);
		barrausuagility.setForeground(Color.green);
		barrausuagility.setBackground(Color.white);

		barraususpeed.setMinimum(0);
		barraususpeed.setMaximum(100);
		barraususpeed.setValue(0);
		barraususpeed.setForeground(Color.blue);
		barraususpeed.setBackground(Color.white);

		barrausudefense.setMinimum(0);
		barrausudefense.setMaximum(100);
		barrausudefense.setValue(0);
		barrausudefense.setForeground(Color.darkGray);
		barrausudefense.setBackground(Color.white);
		//----------------------------------------------------------------------
		bbrrabotpower.setMinimum(0);
		bbrrabotpower.setMaximum(100);
		bbrrabotpower.setValue(0);
		bbrrabotpower.setForeground(Color.red);
		bbrrabotpower.setBackground(Color.white);
		
		bbrrabotagility.setMinimum(0);
		bbrrabotagility.setMaximum(100);
		bbrrabotagility.setValue(0);
		bbrrabotagility.setForeground(Color.green);
		bbrrabotagility.setBackground(Color.white);

		bbrrabotspeed.setMinimum(0);
		bbrrabotspeed.setMaximum(100);
		bbrrabotspeed.setValue(0);
		bbrrabotspeed.setForeground(Color.blue);
		bbrrabotspeed.setBackground(Color.white);

		bbrrabotdefense.setMinimum(0);
		bbrrabotdefense.setMaximum(100);
		bbrrabotdefense.setValue(0);
		bbrrabotdefense.setForeground(Color.darkGray);
		bbrrabotdefense.setBackground(Color.white);

		panel2.add(usupower);
		panel2.add(usuagility);
		panel2.add(ususpeed);
		panel2.add(usudefense);
		
		panel3.add(botpower);
		panel3.add(botagility);
		panel3.add(botspeed);
		panel3.add(botdefense);
		
		this.add(barrausupower);
		this.add(barrausuagility);
		this.add(barraususpeed);
		this.add(barrausudefense);
		
		this.add(bbrrabotpower);
		this.add(bbrrabotagility);
		this.add(bbrrabotspeed);
		this.add(bbrrabotdefense);


		barrausupower.setBounds(300, 431, 201, 22); 
		barrausuagility.setBounds(300, 453, 201, 22);
		barraususpeed.setBounds(300, 474, 201, 22);
		barrausudefense.setBounds(300, 496, 201, 22);
		
		bbrrabotpower.setBounds(1049, 431, 201, 22); 
		bbrrabotagility.setBounds(1049, 453, 201, 22);
		bbrrabotspeed.setBounds(1049, 474, 201, 22);
		bbrrabotdefense.setBounds(1049, 496, 201, 22);
		

		
		// BARRA PROGRESION USUARIOS
		barrabot = new JProgressBar();
		barrabot.setMinimum(0);
		barrabot.setMaximum(0);
		barrabot.setStringPainted(true);
		barrabot.setValue(0);
		barrabot.setForeground(Color.green);
		barrabot.setBackground(Color.RED);
		barrabot.setFont(font);
		
		barrauser = new JProgressBar();
		barrauser.setMinimum(0);
		barrauser.setMaximum(0);
		barrauser.setStringPainted(true);
		barrauser.setValue(0);
		barrauser.setStringPainted(true);
		barrauser.setValue(0);
		barrauser.setForeground(Color.green);
		barrauser.setBackground(Color.RED);
		barrauser.setFont(font);
		
		this.add(barrabot);
		this.add(barrauser);
		barrauser.setBounds(0, 1, 501, 60);
		barrabot.setBounds(750, 1, 500, 60);
		this.setLayout(null);
		panel2.setBounds(150, 431, 100, 95);
		panel3.setBounds(900, 431, 100, 95);
		this.add(panel2);
		this.add(panel3);
		
		
	}
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		// Link de la foto character
		String linkcharacteruser = userimg1;
		String linkcharacterbot = botimg1;
		// Link de la foto weapon
		String linkweaponuser = userweapon1;
		String linkweaponbot = botweapon1;
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
    
    /*---------------------------------------------------*/
    public void userProgBar(Integer total) {
        barrauser.setValue(total);
    }
    public void botProgBar(Integer total) {
        barrabot.setValue(total);
    }
    public void userMaximum(Integer total) {
    	barrauser.setMaximum(total);
    }
    public void botMaximum(Integer total) {
    	barrabot.setMaximum(total);
    }
    /*----------------------------------------------------*/
    public void userPowerBar(Integer total) {
    	barrausupower.setValue(total);
    }
    public void userSpeedBar(Integer total) {
    	barrausuagility.setValue(total);
    }
    public void userAgilitiBar(Integer total) {
    	barraususpeed.setValue(total);
    }
    public void userDefBar(Integer total) {
    	barrausudefense.setValue(total);
    }
    /*----------------------------------------------------*/
    public void botPowerBar(Integer total) {
    	bbrrabotpower.setValue(total);
    }
    public void botSpeedBar(Integer total) {
    	bbrrabotagility.setValue(total);
    }
    public void botAgilitiBar(Integer total) {
    	bbrrabotspeed.setValue(total);
    }
    public void botDefBar(Integer total) {
    	bbrrabotdefense.setValue(total);
    }
    
}
