package classes;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Boolean isPlaying = true;
		System.out.print("Escoge nombre: ");
		String user_name = sc.next();
		
		Player[] players_ingame = new Player[2];
		
		//AQUI SE BAJA LA INFORMACION DE LA BASE DE DATOS WARRIORS Y WEAPONS
		//
		////
		
		
		//ESTO ES EL WHILE DE USO DE LA APLICACION
		while (isPlaying) {
			//ESTO ES PARA CREAR VALORES CON LOS QUE JUGAR AHORA!!!
			boolean ishuman = false;
			Boolean isFighting = true;
			for (int i = 0; i < 2; i++) {
				int random_id = (int) (1 + (Math.random()*101));
				int random_value = (int) (1 + (Math.random()*5));
				players_ingame[i] = new Player(ishuman, 
						
						new Warrior(random_id, "Warrior "+i, random_value*10, 
						random_value, random_value+2, random_value+1, (int)random_value/2, 
						user_name), 
						
						new Weapon(random_value, random_value), 
						0);
				
				ishuman = true;
			}
			//Decidimos quien ataca
			//FALSO = POSICION 0, VERDADERO = POSICION 1
			boolean turno = MyFunctions.getFasterWarrior(players_ingame);	
			for (Player pl: players_ingame) {
				System.out.println(pl.getWarrior().toString());
			}
			
			//ESTO ES EL WHILE DE LAS RONDAS
			int ronda = 0;
			do {
				ronda = ronda + 1;
				//FALSO = POSICION 0, VERDADERO = POSICION 1
				int percentageAtkHits = 1 + (int) (Math.random() * 101);
				System.out.println("=============================================================================");
				if (turno) {
					System.out.println("Round number "+ronda+" | Turn of "+players_ingame[1].getWarrior().getName());
					turno = MyFunctions.roundFight(players_ingame[1], players_ingame[0], percentageAtkHits, turno);
				} else if (!turno) {
					System.out.println("Round number "+ronda+" | Turn of "+players_ingame[0].getWarrior().getName());	
					turno = MyFunctions.roundFight(players_ingame[0], players_ingame[1], percentageAtkHits, turno);
				}
				
				for (Player pl: players_ingame) {
					System.out.println(pl.getWarrior().toString());
					if (pl.getWarrior().getVida() <= 0) {
						isFighting = false;
					}
				}
				
			} while(isFighting);
			Player winner = null;
			for (Player pl: players_ingame) {
				if (pl.getWarrior().getVida() > 0) {
					winner = pl;
					break;
				}
			}
			System.out.println("The winner of the fight is "+winner.getWarrior().getName());
			System.out.print("Do you want to play again?: ");
			sc.next();
			//Esto es para acabar de jugar en una batalla
			isPlaying = false;
		}
	}

}

class Player {
	private boolean isHuman;
	private Warrior warrior;
	private Weapon weapon;
	private int total_points;
	public Player(boolean isHuman, Warrior warrior, Weapon weapon, int total_points) {
		super();
		this.isHuman = isHuman;
		this.warrior = warrior;
		this.weapon = weapon;
		this.total_points = total_points;
	}
	public boolean isHuman() {
		return isHuman;
	}
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
	public Warrior getWarrior() {
		return warrior;
	}
	public void setWarrior(Warrior warrior) {
		this.warrior = warrior;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public int getTotal_points() {
		return total_points;
	}
	public void setTotal_points(int total_points) {
		this.total_points = total_points;
	}
	
}
