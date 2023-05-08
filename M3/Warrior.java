package classes;

public class Warrior {
	private int id;
	private String name;
	private int vida;
	private int strenght;
	private int speed;
	private int agility;
	private int defense;
	private String url_image;
	
	public Warrior(int id, String name, int vida, int strenght, int speed, int agility, int defense, String url_image) {
		this.id = id;
		this.name = name;
		this.vida = vida;
		this.strenght = strenght;
		this.speed = speed;
		this.agility = agility;
		this.defense = defense;
		this.url_image = url_image;
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
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getStrenght() {
		return strenght;
	}
	public void setStrenght(int strenght) {
		this.strenght = strenght;
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
	public String getUrl_image() {
		return url_image;
	}
	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}


	@Override
	public String toString() {
		return "Warrior [id=" + id + ", name=" + name + ", vida=" + vida + ", strenght=" + strenght + ", speed=" + speed
				+ ", agility=" + agility + ", defense=" + defense + ", url_image=" + url_image + "]";
	}
	
}
