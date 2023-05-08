import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeaponsContainer {
	private ArrayList<Weapons> weaponsarray;
	String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	String usuario = "root";
	String pass = "1234";
	
	WeaponsContainer() {
		weaponsarray = new ArrayList<Weapons>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "select * from WEAPONS";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				weaponsarray.add(new Weapons(rs.getInt(1),rs.getString(2) , rs.getString(3)));
			}
			
			for (Weapons a : weaponsarray) {
				 System.out.println(a.getName_weapon()+", "+a.getId());
			 }
			
		} catch (ClassNotFoundException e) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException e) {
			System.out.println("Conexion no creada con exito!!");
		}
	}

	public static void main(String[] args) {
		new WeaponsContainer();

	}

}
