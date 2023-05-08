
public class Weapons {
	private int id;
	private String name_weapon;
	private String weapon_image_path;
	
	public Weapons(int id, String name_weapon, String weapon_image_path) {
		super();
		this.id = id;
		this.name_weapon = name_weapon;
		this.weapon_image_path = weapon_image_path;
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
