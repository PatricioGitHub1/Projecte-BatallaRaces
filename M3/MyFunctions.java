package classes;

public class MyFunctions {
	//Decidimos quien ataca
	//FALSO = POSICION 0, VERDADERO = POSICION 1
	static boolean getFasterWarrior(Player[] players) {
		if (players[0].getWarrior().getSpeed()+players[0].getWeapon().getVelocidad() == players[1].getWarrior().getSpeed()+players[1].getWeapon().getVelocidad()) {
			if (players[0].getWarrior().getAgility() == players[1].getWarrior().getAgility()) {
				int random_index = (int) Math.random()*2;
				if (random_index == 0) {
					return false;
				} else {
					return true;
				}
			} else if (players[0].getWarrior().getAgility() > players[1].getWarrior().getAgility()) {
				return false;
			} else {
				return true;
			}
		} else if (players[0].getWarrior().getSpeed()+players[0].getWeapon().getVelocidad() > players[1].getWarrior().getSpeed()+players[1].getWeapon().getVelocidad()) {
			return false;
		} else {
			return true;
		}
	}
	
	//ESTO ES EL DESARROLLO DE LA PELEA
	static boolean roundFight(Player atacante, Player defensor, int chanceHit, boolean turno) {
		System.out.println("=============================================================================");
		if ((atacante.getWarrior().getAgility()) * 10 > chanceHit) {
			System.out.println("El atac ha tingut exit");
			int percentageDodge = 1 + (int) (Math.random() * 51);
			
			if ((defensor.getWarrior().getAgility()) > percentageDodge) {
				System.out.println(defensor.getWarrior().getName()+" ha esquivat l'atac");
				System.out.println("Se cambian los roles");
				return changeTurn(turno);
			} else {
				//EN ESTE CASO EL ATAQUE HA TENIDO EXITO Y EL DEFENSOR NO HA PODIDO DEFENDERSE
				int totalDamage = atacante.getWarrior().getStrenght() + atacante.getWeapon().getPlus_strenght() - defensor.getWarrior().getDefense();
				int updatedDefHealth = defensor.getWarrior().getVida() - totalDamage;
				defensor.getWarrior().setVida(updatedDefHealth);
				System.out.println(defensor.getWarrior().getName() + " ha rebut "+totalDamage+ " punts de dany per part de "+atacante.getWarrior().getName());
				//AQUI MODIFICAR LA BARRITA DE SALUD DEL DEFENSOR
				//
				///
				
				//Ver si atacante puede repetir turnp
				if (atacante.getWarrior().getSpeed() + atacante.getWeapon().getVelocidad() <= defensor.getWarrior().getSpeed()+defensor.getWeapon().getVelocidad()) {
					System.out.println("Se cambian los roles");
					return changeTurn(turno);
					
				}
				
				//En el caso que la velocidad del defensor no sea mayor al atacante
				int changeToSwap = 1 + (int) (Math.random() * 101);
				if ((atacante.getWarrior().getSpeed() + atacante.getWeapon().getVelocidad() - defensor.getWarrior().getSpeed() - defensor.getWeapon().getVelocidad())*10 > changeToSwap) {
					System.out.println("El atacante vuelve a atacar");
					return turno;
				}
				System.out.println("Se cambian los roles");	
				return changeTurn(turno);
				}
			
		} else {
			System.out.println("El atac no ha tingut exit");
			System.out.println("Se cambian los roles");	
			return changeTurn(turno);
		}
	}
	
	static boolean changeTurn(boolean current) {
		if (current) {
			return false;
		} else {
			return true;
		}
	}
}
