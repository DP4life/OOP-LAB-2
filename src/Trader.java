import java.util.Scanner;

public class Trader {
	private Food traderFood;
	private Drinkable traderDrink;
	private Medicine traderMedicine;

	Trader(Food _food, Drinkable _drink, Medicine _medicine){
		traderFood = _food;
		traderDrink = _drink;
		traderMedicine = _medicine;
	}


	public void Meet(Player _player){
		System.out.println("============================================================");
		System.out.println(" > You meet a trader!");
		System.out.println(" [1] Continue on your trail\n [2] Barter ");
		System.out.print(" > ");
		Scanner scanner = new Scanner(System.in);
		byte choice = 0;

		choice = scanner.nextByte();

		switch(choice){
			case 1:
				System.out.println("You continue on your journey");
				break;
			case 2:
				Barter(_player);
				break;
			default:
				break;
		}
	}

	public void Barter(Player _player){
		System.out.println("============================================================");
		System.out.println(" > \"Here's what I have to offer\"");
		System.out.println(" [1] " + traderFood.GetName() + " " + ConsoleColors.CYAN + traderFood.GetNutrition() + " " + ConsoleColors.RED + traderFood.GetRadioation() + " " + ConsoleColors.YELLOW + traderFood.GetPrice() + ConsoleColors.RESET);
		System.out.println(" [2] " + traderDrink.GetDrinkName() +  " " +ConsoleColors.BLUE + traderDrink.GetQuenchValue() + " " + ConsoleColors.RED + traderDrink.GetRadioation() + " " + ConsoleColors.YELLOW + traderDrink.GetPrice() + ConsoleColors.RESET);
		System.out.println(" [3] " + traderMedicine.GetName() +  " " +ConsoleColors.GREEN + traderMedicine.GetHealing() +" " + ConsoleColors.PURPLE + traderMedicine.GetRadHeal() +" " + ConsoleColors.YELLOW + traderMedicine.GetPrice() + ConsoleColors.RESET);
		System.out.println(" [4] Nothing");
		System.out.println(" > You have " + _player.GetMoney() + " caps");
		Scanner scanner = new Scanner(System.in);

		byte choice = 0;
		choice = scanner.nextByte();

		switch (choice){
			case 1:
				_player.StoreFood(traderFood, _player.GetFoodIndex());
				if (_player.GetMoney() - traderFood.GetPrice() < 0){
					System.out.println("You don't have enough money");
					break;
				} 
				_player.SetMoney(_player.GetMoney() - traderFood.GetPrice());
				break;
			case 2:
				_player.StoreDrink(traderDrink, _player.GetDrinkIndex());
				if (_player.GetMoney() - traderDrink.GetPrice() < 0){
					System.out.println("You don't have enough money");
					break;
				} 
				_player.SetMoney(_player.GetMoney() - traderDrink.GetPrice());
				break;
			case 3:
				_player.StoreMedicine(traderMedicine, _player.GetMedicineIndex());
				if (_player.GetMoney() - traderMedicine.GetPrice() < 0){
					System.out.println("You don't have enough money");
					break;
				} 
				_player.SetMoney(_player.GetMoney() - traderMedicine.GetPrice());
				break;
			default:
				break;
		}
	}
}
