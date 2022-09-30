import java.util.Scanner;

public class Place {
	private String placeName;
	private Enemy placeEnemy;
	private Food placeFoodStash;
	private Drinkable placeDrinkStash;
	private Medicine placeMedicineStash;


	Place(String _name, Enemy _enemy, Food _food, Drinkable _drink, Medicine _medicine){
		placeName = _name;
		placeEnemy = _enemy;
		placeFoodStash = _food;
		placeDrinkStash = _drink;
		placeMedicineStash = _medicine;

	}
	public String GetName(){
		return placeName;
	}
	public void Discover(Player _player){
		Scanner scanner = new Scanner(System.in);

		System.out.println("You have discovered " + placeName);
		System.out.println("What do you want to do?");
		System.out.println(" [1] Look around \n [2] Keep going");
		
		byte choice = scanner.nextByte();
		scanner.close();
		switch (choice) {
			case 1:
			if (placeEnemy != null){
				System.out.println("> You get attacked by a " + placeEnemy.GetName() + "!");
				placeEnemy.StartCombat(_player);
			}		
			System.out.println("> You see " + placeFoodStash.GetName() + ", " + placeDrinkStash.GetDrinkName() + ", " + placeMedicineStash.GetName());
			_player.StoreFood(placeFoodStash, 0);
			_player.StoreDrink(placeDrinkStash, 0);
			_player.StoreMedicine(placeMedicineStash, 0);
				break;
			case 2:
				System.out.println("You go past the " + placeName + " and continue on your trail");
				break;
			default:
				break;
		}
	}
}
