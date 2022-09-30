public class Food {
	private String foodName;
	private int nutritionalValue;
	private int foodRadiationValue;


	Food(String _foodName, int _nutritionalValue, int _foodRadiationValue){
		foodName = _foodName;
		nutritionalValue = _nutritionalValue;
		foodRadiationValue = _foodRadiationValue;
	}

	public String GetName(){
		return foodName;
	}
	public int GetNutrition(){
		return nutritionalValue;
	}
	public int GetRadioation(){
		return foodRadiationValue;
	}
}
