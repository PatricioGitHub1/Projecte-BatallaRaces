import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BBDD {
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	public void addRounds(ArrayList<Rounds> array) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query="insert into ROUNDS (Player_id,Warrior_id,Warrior_Weapon_id,Opponent_id,Opponent_Weapon_id,Injuries_Caused,Injuries_Suffered) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			for (Rounds insert:array) {
				ps.setInt(1, insert.getPlayer_id());
				ps.setInt(2, insert.getWarrior_id());
				ps.setInt(3, insert.getWarrior_weapon_id());
				ps.setInt(4, insert.getOpponent_id());
				ps.setInt(5, insert.getOpponent_weapon_id());
				ps.setInt(6, insert.getInjuries_Caused());
				ps.setInt(7, insert.getInjuries_Suffered());
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println("Conexion no creada con exito!!");
		}
	}
	
	
	public int cogerId(String username) {
		int id=0;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query="select player_id from PLAYERS where player_name = "+username;
			PreparedStatement ps = conn.prepareStatement(query);
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println("Conexion no creada con exito!!");
		}
		return id;
	}
	
}


