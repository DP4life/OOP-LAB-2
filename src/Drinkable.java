public class Drinkable {
	private String drinkableName;
	private int quenchValue;
	private int drinkableRadiationValue;

	Drinkable(String _drinkableName, int _quenchValue, int _drinkableRadiationValue){
		drinkableName = _drinkableName;
		quenchValue = _quenchValue;
		drinkableRadiationValue = _drinkableRadiationValue;
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
}
