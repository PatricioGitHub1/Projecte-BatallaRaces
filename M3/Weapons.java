
public class Weapons {
	private int id;
	private String name_weapon;
	private String weapon_image_path;
	private int speed;
	private int strength;
	private int points_value;
	
	public Weapons(int id, String name_weapon, String weapon_image_path,int speed,int strength,int points_value) {
		super();
		this.id = id;
		this.name_weapon = name_weapon;
		this.weapon_image_path = weapon_image_path;
		this.speed = speed;
		this.strength = strength;
		this.points_value = points_value;
	}
	
	
	
	public int getPoints_value() {
		return points_value;
	}



	public void setPoints_value(int points_value) {
		this.points_value = points_value;
	}



	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_weapon() {
		return name_weapon;
	}
	public void setName_weapon(String name_weapon) {
		this.name_weapon = name_weapon;
	}
	public String getWeapon_image_path() {
		return weapon_image_path;
	}
	public void setWeapon_image_path(String weapon_image_path) {
		this.weapon_image_path = weapon_image_path;
	}
	
	
}
