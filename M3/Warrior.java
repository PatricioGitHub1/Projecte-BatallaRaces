
public class Warrior {
	private int id;
	private String name;
	private String image_path;
	private int health;
	private int speed;
	private int agility;
	private int defense;
	private int strength;
	private int initial_health;
	private int points_value;
	
	public Warrior(int id, String name, String image_path) {
		super();
		this.id = id;
		this.name = name;
		this.image_path = image_path;
	}
	
	

	public int getPoints_value() {
		return points_value;
	}



	public void setPoints_value(int points_value) {
		this.points_value = points_value;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void resetStats() {
        setHealth(getInitial_health());
    }

	public int getInitial_health() {
		return initial_health;
	}

	public void setInitial_health(int initial_health) {
		this.initial_health = initial_health;
		this.setHealth(initial_health);
	}
	
	
	
	
	
	

}
