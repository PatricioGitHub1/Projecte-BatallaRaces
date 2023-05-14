
public class Elf extends Warrior{
	private int agility = 7;
	private int defense = 2;
	private int strength = 4;
	private int speed = 7;
	private int points_value = 19;
	
	public Elf(int id, String name, String image_path) {
		super(id, name, image_path);
		setInitial_health(40);
		setStrength(strength);
		setAgility(agility);
		setDefense(defense);
		setSpeed(speed);
		setHealth(40);
		setPoints_value(points_value);
	}
	
	
}
