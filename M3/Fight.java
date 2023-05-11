
public class Fight {
	private int enemy_health;
	private int player_health;
	private int total_points=0;
	private boolean turno;
	
	
	
	Fight(String userimg, String userweapon, String botimg, String botweapon,int id,String username,Warrior warrior_enemy, Weapons weapons_enemy,Warrior user_warrior,Weapons user_weapon,int round){
		VentanaLucha vn = VentanaLucha.getInstance();
		if (round == 1) {
			turno = getFasterWarrior(user_warrior, warrior_enemy, user_weapon, weapons_enemy);
		}
		
		vn.consoleText(String.valueOf(turno));
		//FALSO = BOT, VERDADERO = HUMANO
		int percentageAtkHits = 1 + (int) (Math.random() * 101);
		vn.consoleText("=============================================================================");
		if (turno) {
			vn.consoleText("Round number "+round+" | Turn of "+username);
			turno = roundFight(user_warrior, warrior_enemy,user_weapon,weapons_enemy,turno);
		} else if (!turno) {
			vn.consoleText("Round number "+round+" | Turn of bot");	
			turno = roundFight(warrior_enemy, user_warrior,weapons_enemy,user_weapon,turno);
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
				int totalDamage = attacker.getStrength() + weapon_attacker.getStrength() - defender.getDefense();
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
