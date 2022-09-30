public class Player {
	private int maxHealth;
	private int health;

	private int attack = 20;

	private int thirst;
	private int maxThirst = 100;

	private int hunger;
	private int maxHunger = 100;

	private int radiation = 0;
	private int maxRadiation = 100;

	private int money = 0;


	Player(int _health){
		health = _health;
	}

	//Inventory
	private Drinkable[] playerInventoryDrinkable = new Drinkable[100];
	private int inventoryFoodIndex = 0;
	private Food[] playerInventoryFood = new Food[100];
	private int inventoryDrinkIndex = 0;
	private Medicine[] playerInventoryMedicine = new Medicine[100];
	private int inventoryMedicineIndex = 0;

	public int PlayerAttack(){
		return attack;
	}

	//Inventory

		//Food
	public void StoreFood(Food _food, int n){
		playerInventoryFood[n] = _food;
		System.out.println("You stored " + _food.GetName() + " HG = " + _food.GetNutrition() + " RAD = " + _food.GetRadioation() + "#"+ inventoryFoodIndex);
		inventoryFoodIndex++;
	}

	public void ConsumeFood(int n){
		hunger += playerInventoryFood[n].GetNutrition();
		radiation += playerInventoryFood[n].GetRadioation();
		if (radiation > maxRadiation){
			Die();
		}

		System.out.println("You ate " + playerInventoryFood[n].GetName());
		System.out.println("Hunger + " + playerInventoryFood[n].GetNutrition());
		System.out.println("Radiation + " + playerInventoryFood[n].GetRadioation());
	}

		//Drinks
	public void StoreDrink(Drinkable _drink, int n){
		playerInventoryDrinkable[n] = _drink;
		System.out.println("You stored " + _drink.GetDrinkName() + " HG = " + _drink.GetQuenchValue() + " RAD = " + _drink.GetRadioation()+ " #" + inventoryDrinkIndex);
		inventoryDrinkIndex++;
	}
	
	public void ConsumeDrinkable(int n){
		thirst += playerInventoryDrinkable[n].GetQuenchValue();
		radiation += playerInventoryDrinkable[n].GetRadioation();
		if (radiation > maxRadiation){
			Die();
		}

		System.out.println("You drank " + playerInventoryDrinkable[n].GetDrinkName());
		System.out.println("Thirst + " + playerInventoryDrinkable[n].GetQuenchValue());
		System.out.println("Radiation + " + playerInventoryDrinkable[n].GetRadioation());
	}

		//Medicine
		public void StoreMedicine(Medicine _medicine, int n){
			playerInventoryMedicine[n] = _medicine;
			System.out.println("You stored " + _medicine.GetName() + " HP = " + _medicine.GetHealing() + " RAD = " + _medicine.GetRadHeal());
		}
		
		public void ConsumeMedicine(int n){
			health += playerInventoryMedicine[n].GetHealing();
			radiation -= playerInventoryMedicine[n].GetRadHeal();
			if (health > maxHealth) health = maxHealth;
			if (radiation < 0) radiation = 0;
	
			System.out.println("You injected " + playerInventoryMedicine[n].GetName());
			System.out.println("Health + " + playerInventoryMedicine[n].GetHealing());
			System.out.println("Radiation - " + playerInventoryMedicine[n].GetRadHeal());
		}	


	

	
	
	public int GetHunger(){
		return hunger;
	}
	public int GetHealth(){
		return health;
	}
	public int GetMaxHealth(){
		return maxHealth;
	}
	public int GetThirst(){
		return thirst;
	}
	public void TakeDamage(int damage){
		health -= damage;
	}
	public void Die(){
		System.out.println("You are dead lol");
	}

}
