import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class WarriorContainer {
	private ArrayList<Warrior> warriorarray;
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	public ArrayList<Warrior> getWarriorarray() {
		return warriorarray;
	}
	WarriorContainer(){
		warriorarray = new ArrayList<Warrior>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "select * from WARRIORS";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				if (rs.getString(3).substring(11,rs.getString(3).lastIndexOf('.')-1).equals("elfo")) {
					warriorarray.add(new Elf(rs.getInt(1),rs.getString(2) , rs.getString(3)));
				}else if (rs.getString(3).substring(11,rs.getString(3).lastIndexOf('.')-1).equals("enano")) {
					warriorarray.add(new Dwarf(rs.getInt(1),rs.getString(2) , rs.getString(3)));
				}else {
					warriorarray.add(new Human(rs.getInt(1),rs.getString(2) , rs.getString(3)));
				}
					
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException e) {
			System.out.println("Conexion no creada con exito!!");
		}
		
			
	}
	
	public static void main(String[] args) {
		WarriorContainer c1 = new  WarriorContainer();
		for (Warrior w :c1.getWarriorarray()) {
			System.out.println(w.getImage_path());
			
		}
	}
}
