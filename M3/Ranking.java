import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ranking  extends JFrame{
	private JPanel p1;
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	
	Ranking(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "select * from PLAYERS order by Total_Points desc limit 10;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3));
			}
			
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println(y.getMessage());
			System.out.println("Conexion no creada con exito!!");
		}
	}
	
}
