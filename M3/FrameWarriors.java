import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameWarriors extends JFrame{

	private JPanel p0,p1,p2,p3;
	private ArrayList<JLabel> arraylabels;
	private int id;
	
	
	
	FrameWarriors(int cont,String username){
		arraylabels = new ArrayList<JLabel>();
		WarriorContainer w1 = new WarriorContainer();
		w1.addWArrior();
		for (int i=0;i<w1.getWarriorarray().size();i++) {
			ImageIcon icono = new ImageIcon(w1.getWarriorarray().get(i).getImage_path());
			Image imagenOriginal = icono.getImage();
	        Image imagenRedimensionada = imagenOriginal.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
	        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
	        JLabel label = new JLabel(iconoRedimensionado);
	        arraylabels.add(label);
		}
		
		for (int i = 0; i<arraylabels.size();i++) {
			JLabel label = arraylabels.get(i);
			arraylabels.get(i).addMouseListener(new MouseAdapter() {
			
				public void mouseClicked(MouseEvent e) {
					int index = arraylabels.indexOf(label);

					dispose();
					WarriorEnemy we = new WarriorEnemy();
					int id_warrior = w1.getWarriorarray().get(index).getId();
					we.Enemy_Random();
					Warrior warrior_enemy = we.getWarrior_enemy();
					Weapons weapon_enemy = we.getWeapon();
					new VentanaLucha(w1.getWarriorarray().get(index).getImage_path(), "./imagenes/?.jpg", we.getWarrior_enemy().getImage_path(),we.getWeapon().getWeapon_image_path() ,id_warrior,username,warrior_enemy,weapon_enemy,w1.getWarriorarray().get(index),null);
					
					
				}
				
			});
		}
		
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		for (int i = 0;i<4;i++) {
			p1.add(arraylabels.get(i));
		}
		for (int i = 4;i<8;i++) {
			p2.add(arraylabels.get(i));
		}
		for (int i = 8;i<12;i++) {
			p3.add(arraylabels.get(i));
		}
		
		p0.add(p1);
		p0.add(p2);
		p0.add(p3);
		add(p0);
		setSize(850,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
			
		}
	public static void main(String[] args) {

	}

}
