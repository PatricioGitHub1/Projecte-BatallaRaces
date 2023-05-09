import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeaponsContainer {
	private ArrayList<Weapons> weaponsarray;
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	
	
	public ArrayList<Weapons> getWeaponsarray() {
		return weaponsarray;
	}

	WeaponsContainer() {
		weaponsarray = new ArrayList<Weapons>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "select * from WEAPONS";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				weaponsarray.add(new Weapons(rs.getInt(1),rs.getString(2) , rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException e) {
			System.out.println("Conexion no creada con exito!!");
		}
	}

	public static void main(String[] args) {
		}
		
	}


