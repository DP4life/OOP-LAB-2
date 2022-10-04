public class Drinkable {
	private String drinkableName;
	private int quenchValue;
	private int drinkableRadiationValue;
	private int price;

	Drinkable(String _drinkableName, int _quenchValue, int _drinkableRadiationValue, int _price){
		drinkableName = _drinkableName;
		quenchValue = _quenchValue;
		drinkableRadiationValue = _drinkableRadiationValue;
		price = _price;
	}

	public String GetDrinkName(){
		return drinkableName;
	}

	public int GetQuenchValue(){
		return quenchValue;
	}

	public int GetRadioation(){
		return drinkableRadiationValue;
	}

	public int GetPrice(){
		return price;
	}
}
