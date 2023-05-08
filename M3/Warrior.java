
public class Warrior {
	private int id;
	private String warrior_name;
	private String warrior_image_path;
	
	public Warrior(int id, String warrior_name, String warrior_image_path) {
		super();
		this.id = id;
		this.warrior_name = warrior_name;
		this.warrior_image_path = warrior_image_path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWarrior_name() {
		return warrior_name;
	}
	public void setWarrior_name(String warrior_name) {
		this.warrior_name = warrior_name;
	}
	public String getWarrior_image_path() {
		return warrior_image_path;
	}
	public void setWarrior_image_path(String warrior_image_path) {
		this.warrior_image_path = warrior_image_path;
	}
	
	

}
