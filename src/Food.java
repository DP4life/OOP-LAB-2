public class Food {
	private String foodName;
	private int nutritionalValue;
	private int foodRadiationValue;
	private int price;


	Food(String _foodName, int _nutritionalValue, int _foodRadiationValue, int _price){
		foodName = _foodName;
		nutritionalValue = _nutritionalValue;
		foodRadiationValue = _foodRadiationValue;
		price = _price;
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
	public int GetPrice(){
		return price;
	}
}
