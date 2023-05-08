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
	
}
