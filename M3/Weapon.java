package classes;

public class Weapon {
	private int velocidad;
	private int plus_strenght;
	
	public Weapon(int velocidad, int plus_strenght) {
		super();
		this.velocidad = velocidad;
		this.plus_strenght = plus_strenght;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPlus_strenght() {
		return plus_strenght;
	}

	public void setPlus_strenght(int plus_strenght) {
		this.plus_strenght = plus_strenght;
	}

	@Override
	public String toString() {
		return "Weapon [velocidad=" + velocidad + ", plus_strenght=" + plus_strenght + "]";
	}
	
}
