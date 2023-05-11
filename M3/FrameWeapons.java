import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameWeapons extends JFrame{
	
	private JPanel p0,p1;
	private ArrayList<JLabel> arraylabels;
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	
	FrameWeapons(int id,String warriorpath,String username,String botimg, String botweapon,Warrior warrior_enemy, Weapons weapons_enemy,Warrior user_warrior,Weapons user_weapon){
		ArrayList<Integer> arrayid = new ArrayList<Integer>();
		arraylabels = new ArrayList<JLabel>();
		WeaponsContainer w1 = new WeaponsContainer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "select Weapon_id from WEAPONS_AVAILABLE where Warrior_id="+id;
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrayid.add(rs.getInt(1));
			}
			for (int i=0;i<w1.getWeaponsarray().size();i++) {
				for (int x = 0;x<arrayid.size() ;x++) {
					if (w1.getWeaponsarray().get(i).getId()==arrayid.get(x)) {
						ImageIcon icono = new ImageIcon(w1.getWeaponsarray().get(i).getWeapon_image_path());
						Image imagenOriginal = icono.getImage();
				        Image imagenRedimensionada = imagenOriginal.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
				        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
				        JLabel label = new JLabel(iconoRedimensionado);
				        arraylabels.add(label);
					}
					
				}
			}
			
			for (int i = 0; i<arraylabels.size();i++) {
				JLabel label = arraylabels.get(i);
				arraylabels.get(i).addMouseListener(new MouseAdapter() {
				
					public void mouseClicked(MouseEvent e) {
						int z = 0;
						int index = arraylabels.indexOf(label);
						for (int x = 0;x<w1.getWeaponsarray().size();x++) {
							if (w1.getWeaponsarray().get(x).getId()==arrayid.get(index)) {
								z = x;
								break;
							}
						}
						dispose();
						new VentanaLucha(warriorpath,w1.getWeaponsarray().get(z).getWeapon_image_path(),botimg,botweapon,id,username,warrior_enemy,weapons_enemy,user_warrior,w1.getWeaponsarray().get(z));
						
					}
					
				});
			}
			
			
			p0 = new JPanel();
			p1 = new JPanel();
			p1.setLayout(new GridLayout(3,3,20,20));
			
			for (int i = 0;i<arraylabels.size();i++) {
				p1.add(arraylabels.get(i));
			}
			
			p0.add(p1);
			add(p0);
			setSize(700,550);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setVisible(true);
		} catch (ClassNotFoundException e) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException e) {
			System.out.println("Conexion no creada con exito!!");
		}
	}
	
	
	public static void main(String[] args) {

	}

}
