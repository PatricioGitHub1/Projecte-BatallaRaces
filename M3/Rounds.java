
public class Rounds {
	private int player_id;
	private int warrior_id;
	private int warrior_weapon_id;
	private int opponent_id;
	private int opponent_weapon_id;
	private int injuries_Caused;
	private int injuries_Suffered;
	
	public Rounds(int player_id, int warrior_id, int warrior_weapon_id, int opponent_id, int opponent_weapon_id,
			int injuries_Caused, int injuries_Suffered) {
		super();
		this.player_id = player_id;
		this.warrior_id = warrior_id;
		this.warrior_weapon_id = warrior_weapon_id;
		this.opponent_id = opponent_id;
		this.opponent_weapon_id = opponent_weapon_id;
		this.injuries_Caused = injuries_Caused;
		this.injuries_Suffered = injuries_Suffered;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public int getWarrior_id() {
		return warrior_id;
	}

	public void setWarrior_id(int warrior_id) {
		this.warrior_id = warrior_id;
	}

	public int getWarrior_weapon_id() {
		return warrior_weapon_id;
	}

	public void setWarrior_weapon_id(int warrior_weapon_id) {
		this.warrior_weapon_id = warrior_weapon_id;
	}

	public int getOpponent_id() {
		return opponent_id;
	}

	public void setOpponent_id(int opponent_id) {
		this.opponent_id = opponent_id;
	}

	public int getOpponent_weapon_id() {
		return opponent_weapon_id;
	}

	public void setOpponent_weapon_id(int opponent_weapon_id) {
		this.opponent_weapon_id = opponent_weapon_id;
	}

	public int getInjuries_Caused() {
		return injuries_Caused;
	}

	public void setInjuries_Caused(int injuries_Caused) {
		this.injuries_Caused = injuries_Caused;
	}

	public int getInjuries_Suffered() {
		return injuries_Suffered;
	}

	public void setInjuries_Suffered(int injuries_Suffered) {
		this.injuries_Suffered = injuries_Suffered;
	}
	
	
	
	
}
