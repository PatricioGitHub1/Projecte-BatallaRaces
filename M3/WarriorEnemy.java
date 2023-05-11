import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class WarriorEnemy {
	private String urlDatos = "jdbc:mysql://localhost/RacesPAC?serverTimezone=UTC";
	private String usuario = "root";
	private String pass = "1234";
	private ArrayList<Integer> arrayids;
	private int num1,num2;  
	private Warrior warrior_enemy;
	private Weapons weapon;
	WarriorEnemy(){
		try {
			Random random = new Random();
			
			arrayids = new ArrayList<Integer>();
			WarriorContainer w1 = new WarriorContainer();
			WeaponsContainer w2 = new WeaponsContainer();
			num2 = random.nextInt(w1.getWarriorarray().size());
			warrior_enemy = w1.getWarriorarray().get(num2);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDatos,usuario,pass);
			String query = "select * from WEAPONS_AVAILABLE where Warrior_id ="+w1.getWarriorarray().get(2).getId();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arrayids.add(rs.getInt(2));
			}
			num1 = random.nextInt(arrayids.size());
			weapon = w2.getWeaponsarray().get(num1);
			
			
			
			
		} catch (ClassNotFoundException x) {
			System.out.println("EL driver no se a cargado con exito");
		} catch (SQLException y) {
			System.out.println(y.getMessage());
			System.out.println("Conexion no creada con exito!!");
		}
		
		
		
	}
	
	public Warrior getWarrior_enemy() {
		return warrior_enemy;
	}

	public void setWarrior_enemy(Warrior warrior_enemy) {
		this.warrior_enemy = warrior_enemy;
	}

	public Weapons getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	public static void main(String[] args) {
        new WarriorEnemy();
    }
}
