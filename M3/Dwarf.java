
public class Dwarf extends Warrior{
	private int agility = 5;
	private int defense = 4;
	private int strength = 6;
	private int speed = 3;
	private int points_value = 21;
	
	public Dwarf(int id, String name, String image_path) {
		super(id, name, image_path);
		setInitial_health(60);
		setStrength(strength);
		setAgility(agility);
		setDefense(defense);
		setSpeed(speed);
		setHealth(60);
		setPoints_value(points_value);
	}
	
	
}
