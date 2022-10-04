import java.util.Scanner;

public class Player {
	private int maxHealth;
	private int health;

	private int attack;

	private int thirst;
	private int maxThirst = 100;

	private int hunger;
	private int maxHunger = 100;

	private int radiation = 0;
	private int maxRadiation = 100;

	private int money = 0;


	Player(int _health, int _money, int _attack){
		attack = _attack;
		health = _health;
		money = _money;
		hunger = maxHunger;
		thirst = maxThirst;
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

	//Inventory methods

	public void SetMoney(int newMoney){
		money = newMoney;
	}

	public void DisplayInventory(){
		System.out.println("============================================================");
		System.out.println("Caps: " + money);
		System.out.println("> What bag would you like to check? \n [1] The Food Sack\n [2] The Drinks Sack\n [3] The Medicine Bag\n [4] Back");
		System.out.print(" > ");
		Scanner playerScanner = new Scanner(System.in);
		byte choice = 0; 
		choice = playerScanner.nextByte();
		 
		switch (choice) {
			case 1:
				for (int i = 0; i < inventoryFoodIndex; i++){
					System.out.println("["+i+"] "+ playerInventoryFood[i].GetName() + " HUNGER: " + playerInventoryFood[i].GetNutrition() + " RAD: " + playerInventoryFood[i].GetRadioation());
				}
				System.out.println("["+(inventoryFoodIndex)+"] Nothing" );
				System.out.println("What would you like to consume ?");
				choice = playerScanner.nextByte();
				if (choice != inventoryFoodIndex)
					ConsumeFood(choice);
					else DisplayInventory();
				break;
	
			case 2:
				for (int i = 0; i < inventoryDrinkIndex; i++){
					System.out.println("["+i+"] "+ playerInventoryDrinkable[i].GetDrinkName() + " THIRST: " + playerInventoryDrinkable[i].GetQuenchValue() + " RAD: " + playerInventoryDrinkable[i].GetRadioation());
				}
				System.out.println("["+(inventoryDrinkIndex)+"] Nothing" );
				System.out.println("What would you like to consume ?");
				choice = playerScanner.nextByte();
				if (choice != inventoryDrinkIndex)
					ConsumeDrinkable(choice);
					else DisplayInventory();
				break; 
			
			case 3:
				for (int i = 0; i < inventoryMedicineIndex; i++){
					System.out.println("["+i+"] "+ playerInventoryMedicine[i].GetName() + " HP: +" + playerInventoryMedicine[i].GetHealing() + " RAD: -" + playerInventoryMedicine[i].GetRadHeal());
				}
				System.out.println("["+(inventoryMedicineIndex)+"] Nothing" );
				System.out.println("What would you like to consume ?");
				choice = playerScanner.nextByte();
				if (choice != inventoryMedicineIndex)
					ConsumeMedicine(choice);
					else DisplayInventory();
				break; 
				
			case 4: 
				TakeBreak();
			default:
				
				break;
		}
	}

		//Food
	public void StoreFood(Food _food, int n){
		playerInventoryFood[n] = _food;
		System.out.println("============================================================");
		System.out.println("You stored " + _food.GetName() + " HG = " + _food.GetNutrition() + " RAD = " + _food.GetRadioation());
		inventoryFoodIndex++;
	}

	public void ConsumeFood(int n){
		hunger += playerInventoryFood[n].GetNutrition();
		if (hunger > maxHunger) {
			hunger = maxHunger;
		}
		radiation += playerInventoryFood[n].GetRadioation();
		if (radiation > maxRadiation){
			Die();
		}
		System.out.println("============================================================");
		System.out.println("You ate " + playerInventoryFood[n].GetName());
		System.out.println("Hunger + " + playerInventoryFood[n].GetNutrition());
		System.out.println("Radiation + " + playerInventoryFood[n].GetRadioation());
	}
	public int GetFoodIndex(){
		return inventoryFoodIndex;
	}
		//Drinks
	public void StoreDrink(Drinkable _drink, int n){
		System.out.println("============================================================");
		playerInventoryDrinkable[n] = _drink;
		System.out.println("You stored " + _drink.GetDrinkName() + " HG = " + _drink.GetQuenchValue() + " RAD = " + _drink.GetRadioation());
		inventoryDrinkIndex++;
	}
	
	public void ConsumeDrinkable(int n){
		thirst += playerInventoryDrinkable[n].GetQuenchValue();
		if (thirst > maxThirst){
			thirst = maxThirst;
		}
		radiation += playerInventoryDrinkable[n].GetRadioation();
		if (radiation > maxRadiation){
			Die();
		}
		System.out.println("============================================================");
		System.out.println("You drank " + playerInventoryDrinkable[n].GetDrinkName());
		System.out.println("Thirst + " + playerInventoryDrinkable[n].GetQuenchValue());
		System.out.println("Radiation + " + playerInventoryDrinkable[n].GetRadioation());
	}
	
	public int GetDrinkIndex(){
		return inventoryDrinkIndex;
	}

		//Medicine
	public void StoreMedicine(Medicine _medicine, int n){
		System.out.println("============================================================");
		playerInventoryMedicine[n] = _medicine;
		System.out.println("You stored " + _medicine.GetName() + " HP = " + _medicine.GetHealing() + " RAD = " + _medicine.GetRadHeal());
		inventoryMedicineIndex++;
	}
	
	public void ConsumeMedicine(int n){
		health += playerInventoryMedicine[n].GetHealing();
		radiation -= playerInventoryMedicine[n].GetRadHeal();
		if (health > maxHealth) health = maxHealth;
		if (radiation < 0) radiation = 0;

		System.out.println("============================================================");
		System.out.println("You injected " + playerInventoryMedicine[n].GetName());
		System.out.println("Health + " + playerInventoryMedicine[n].GetHealing());
		System.out.println("Radiation - " + playerInventoryMedicine[n].GetRadHeal());
	}	

	public int GetMedicineIndex(){
		return inventoryMedicineIndex;
	}


	//gameplay
	public void TakeBreak(){
		Scanner scanner = new Scanner(System.in);
        byte mainChoice = 0;
        
		System.out.println("============================================================");
		System.out.println(" > What would you like to do?\n [1] Continue on the trail\n [2] Open Inventory \n [3] Check Stats");
		System.out.print(" > ");
		mainChoice = scanner.nextByte();

		switch (mainChoice) {
			case 1:
				System.out.println("You continue your jorney");
				break;
			case 2:
			DisplayInventory();
				break;
			case 3:
			DisplayStats();
				break;
		
			default:
				break;
		}

	}

	//stats
	public void DisplayStats(){
		System.out.println("============================================================");
		System.out.println("HP: " + health+"/"+maxHealth);
		System.out.println("RAD: " + radiation+"/"+maxRadiation);	
		System.out.println("Thirst: " + thirst+"/"+maxThirst);
		System.out.println("Hunger: " + hunger+"/"+maxHunger);
		TakeBreak();
	}
	public int GetMoney(){
		return money;
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
	public void TakeRadiation(int damage){
		radiation += damage;
	}
	public void Die(){
		System.out.println("You are dead lol");
	}

}
