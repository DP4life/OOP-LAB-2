public class Medicine {
	private String medicineName;
	private int healingPoints;
	private int radHeal;
	private int price;
	
	Medicine(String _name, int _healing, int _radHeal, int _price){
		medicineName = _name;
		healingPoints = _healing;
		radHeal = _radHeal;
		price = _price;
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

	public int GetPrice(){
		return price;
	}
}
