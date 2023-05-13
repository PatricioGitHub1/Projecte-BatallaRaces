import java.util.ArrayList;

public class Fight extends PlayersImage{
	private int enemy_health;
	private int player_health;
	private int total_points=0;
	private boolean turn;
	private boolean win;
	private int rounds;
	private ArrayList<Rounds> roundsarray;
	private int totalDamage;
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Rounds> getRoundsarray() {
		return roundsarray;
	}

	public int getTotalDamage() {
		return totalDamage;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public boolean isWin() {
		return win;
	}

	
	
	public Fight(String userimg, String userweapon, String botimg, String botweapon) {
		super(userimg, userweapon, botimg, botweapon);
		roundsarray = new ArrayList<Rounds>();
		
	}

	public void lucha (String username,Warrior warrior_enemy, Weapons weapons_enemy,Warrior user_warrior,Weapons user_weapon) {
		BBDD bd = new BBDD();
		VentanaLucha vn = VentanaLucha.getInstance();
		rounds++;
		if (rounds == 1) {
			turn = getFasterWarrior(user_warrior, warrior_enemy, user_weapon, weapons_enemy);
		}
		
		//FALSO = BOT, VERDADERO = HUMANO
		int percentageAtkHits = 1 + (int) (Math.random() * 101);
		vn.consoleText("=============================================================================");
		if (turn) {
			vn.consoleText("Round number "+rounds+" | Turn of "+username);
			turn = roundFight(user_warrior, warrior_enemy,user_weapon,weapons_enemy,turn);
			roundsarray.add(new Rounds(bd.cogerId(username),user_warrior.getId(),user_weapon.getId(),warrior_enemy.getId(),weapons_enemy.getId(),getTotalDamage(),0));
		} else if (!turn) {
			vn.consoleText("Round number "+rounds+" | Turn of bot");	
			turn = roundFight(warrior_enemy, user_warrior,weapons_enemy,user_weapon,turn);
			roundsarray.add(new Rounds(bd.cogerId(username),user_warrior.getId(),user_weapon.getId(),warrior_enemy.getId(),weapons_enemy.getId(),0,getTotalDamage()));
		}
		
		if (warrior_enemy.getHealth()==0 || user_warrior.getHealth()==0) {
			rounds=0;
			total_points=warrior_enemy.getPoints_value()+weapons_enemy.getPoints_value();
		}
		
		
		
	}
	
	
	
	
	boolean roundFight(Warrior attacker, Warrior defender,Weapons weapon_attacker,Weapons weapon_defender,boolean turno) {
		VentanaLucha vn = VentanaLucha.getInstance();
		vn.consoleText("=============================================================================");
		int percentageAtkHits = 1 + (int) (Math.random() * 101);
		if ((attacker.getAgility()) * 10 > percentageAtkHits) {
			vn.consoleText("El atac ha tingut exit");
			int percentageDodge = 1 + (int) (Math.random() * 51);
			
			if ((defender.getAgility()) > percentageDodge) {
				vn.consoleText(defender.getName()+" ha esquivat l'atac");
				vn.consoleText("Se cambian los roles");
				return changeTurn(turno);
			} else {
				//EN ESTE CASO EL ATAQUE HA TENIDO EXITO Y EL DEFENSOR NO HA PODIDO DEFENDERSE
				totalDamage = attacker.getStrength() + weapon_attacker.getStrength() - defender.getDefense();
				int updatedDefHealth = defender.getHealth() - totalDamage;
				defender.setHealth(updatedDefHealth);
				vn.consoleText(defender.getName() + " ha rebut "+totalDamage+ " punts de dany per part de "+attacker.getName());
				//AQUI MODIFICAR LA BARRITA DE SALUD DEL DEFENSOR
				//
				///
				
				//Ver si atacante puede repetir turnp
				if (attacker.getSpeed() + weapon_attacker.getSpeed() <= defender.getSpeed()+weapon_defender.getSpeed()) {
					vn.consoleText("Se cambian los roles");
					return changeTurn(turno);
					
				}
				
				//En el caso que la velocidad del defensor no sea mayor al atacante
				int changeToSwap = 1 + (int) (Math.random() * 101);
				if ((attacker.getSpeed() + weapon_attacker.getSpeed() - defender.getSpeed() - weapon_defender.getSpeed())*10 > changeToSwap) {
					vn.consoleText("El atacante vuelve a atacar");
					return turno;
				}
				vn.consoleText("Se cambian los roles");
				return changeTurn(turno);
				}
			
		} else {
			vn.consoleText("El atac no ha tingut exit");
			vn.consoleText("Se cambian los roles");	
			return changeTurn(turno);
		}
	}
	
	 boolean changeTurn(boolean current) {
			if (current) {
				return false;
			} else {
				return true;
			}
	}
	 
	 boolean getFasterWarrior(Warrior user,Warrior bot,Weapons user1, Weapons bot1) {
			//True es humano y False es el bot
			if (user.getSpeed()+user1.getSpeed() == bot.getSpeed()+bot1.getSpeed()) {
				if (user.getAgility() == bot.getAgility()) {
					int random_index = (int) Math.random()*2;
					if (random_index == 0) {
						return false;
					} else {
						return true;
					}
				} else if (user.getAgility() > bot.getAgility()) {
					return true;
				} else {
					return false;
				}
			} else if (user.getSpeed()+user1.getSpeed() > bot.getSpeed()+bot1.getSpeed()) {
				return true;
			} else {
				return false;
			}
	}
	
	
	public int getEnemy_health() {
		return enemy_health;
	}


	public void setEnemy_health(int enemy_health) {
		this.enemy_health = enemy_health;
	}


	public int getPlayer_health() {
		return player_health;
	}


	public void setPlayer_health(int player_health) {
		this.player_health = player_health;
	}


	public int getTotal_points() {
		return total_points;
	}


	public void setTotal_points(int total_points) {
		this.total_points = total_points;
	}


	public static void main(String[] args) {

	}

}
