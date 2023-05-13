import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BBDD {
	private String urlDatos = "jdbc:mysql://localhost/racespac?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	
	BBDD(){
		
	}
	
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
		int id=-1;
		try {
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
            Statement stmt = conn.createStatement();
            String query = "SELECT max(player_id) from players";
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                id = rs.getInt(1);
            }
		} catch (SQLException y) {
			System.out.println(y.getMessage());
			System.out.println("Conexion no creada con exito!!");
		}
		return id;
	}
	
	public void insertPlayer(String username) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "insert into PLAYERS (Player_name,Total_Points) values (?,?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setInt(2, 0);
			ps.executeUpdate();
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println("Conexion no creada con exito!!");
		}
		
	}
	
	public void updatePlayer(String username,int total_points) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "update PLAYERS set Total_Points = ? where Player_name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,total_points);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println("Conexion no creada con exito!!");
		}
	}
	
}


