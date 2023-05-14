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
			String query="insert into ROUNDS (Round_Number,Battle_id,Warrior_id,Warrior_Weapon_id,Opponent_id,Opponent_Weapon_id,Injuries_Caused,Injuries_Suffered) values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			for (Rounds insert:array) {
				ps.setInt(1, insert.getRounds_id());
				ps.setInt(2, battleId());
				ps.setInt(3, insert.getWarrior_id());
				ps.setInt(4, insert.getWarrior_weapon_id());
				ps.setInt(5, insert.getOpponent_id());
				ps.setInt(6, insert.getOpponent_weapon_id());
				ps.setInt(7, insert.getInjuries_Caused());
				ps.setInt(8, insert.getInjuries_Suffered());
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println(y.getMessage());
			System.out.println("Conexion no creada con exito!!");
		}
	}
	
	public void insertBattle(int player_id,int warrior_id,int Warrior_Weapon_id,int Opponent_id,int Opponent_Weapon_id, int Injuries_Caused, int Injuries_Suffered, int Battle_Points) {
		try {
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
            String query = "insert into BATTLE (Player_id,Warrior_id,Warrior_Weapon_id,Opponent_id,Opponent_Weapon_id,Injuries_Caused,Injuries_Suffered,Battle_Points) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, player_id);
			ps.setInt(2, warrior_id);
			ps.setInt(3, Warrior_Weapon_id);
			ps.setInt(4, Opponent_id);
			ps.setInt(5, Opponent_Weapon_id);
			ps.setInt(6, Injuries_Caused);
			ps.setInt(7, Injuries_Suffered);
			ps.setInt(8, Battle_Points);
			ps.executeUpdate();
		} catch (SQLException y) {
			System.out.println(y.getMessage());
			System.out.println("Conexion no creada con exito!!");
		}
	}
	
	public int battleId() {
		int id=0;
		try {
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
            Statement stmt = conn.createStatement();
            String query = "SELECT max(battle_id) from BATTLE";
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
	
	
	public int cogerId() {
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
			ps.setInt(1,total_points+pointsPlayer());
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println("Conexion no creada con exito!!");
		}
	}
	
	public int pointsPlayer() {
		int points=0;
		
		try {
			int id = cogerId();
			Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
            Statement stmt = conn.createStatement();
            String query = "SELECT total_points from players where player_id ="+id;
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                points = rs.getInt(1);
            }
		} catch (SQLException y) {
			System.out.println(y.getMessage());
			System.out.println("Conexion no creada con exito!!");
		}
		return points;
	}
	
}


