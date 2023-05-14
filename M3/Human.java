
public class Human extends Warrior{
	private int agility = 6;
	private int defense = 3;
	private int strength = 5;
	private int speed = 5;
	private int points_value = 20;
	
	public Human(int id, String name, String image_path) {
		super(id, name, image_path);
		setInitial_health(50);
		setStrength(strength);
		setAgility(agility);
		setDefense(defense);
		setSpeed(speed);
		setHealth(50);
		setPoints_value(points_value);
	}
}
