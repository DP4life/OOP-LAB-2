public class Medicine {
	private String medicineName;
	private int healingPoints;
	private int radHeal;
	
	Medicine(String _name, int _healing, int _radHeal){
		medicineName = _name;
		healingPoints = _healing;
		radHeal = _radHeal;
	}
	public String GetName(){
		return medicineName;
	}

	public int GetHealing(){
		return healingPoints;
	}

	public int GetRadHeal(){
		return radHeal;
	}
}
