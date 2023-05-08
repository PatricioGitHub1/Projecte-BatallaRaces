import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class WarriorContainer {
	private ArrayList<Warrior> warriorarray;
	String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	String usuario = "root";
	String pass = "1234";
	WarriorContainer(){
		warriorarray = new ArrayList<Warrior>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "select * from WARRIORS";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				warriorarray.add(new Warrior(rs.getInt(1),rs.getString(2) , rs.getString(3)));
			}
			
			for (Warrior nombrecito : warriorarray) {
				 System.out.println(nombrecito.getWarrior_name()+", "+nombrecito.getId());
			 }
			
		} catch (ClassNotFoundException e) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException e) {
			System.out.println("Conexion no creada con exito!!");
		}
		
			
	}
	
	public static void main(String[] args) {
		new WarriorContainer();
	}
}
