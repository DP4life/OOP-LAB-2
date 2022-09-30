public class Main {
    public static void main(String[] args){
        Player player = new Player(100);

        Enemy raider = new Enemy("Raider", 10, 100);
        Food cookedRadscorpion = new Food("Cooked Radscorpion", 40, 10);
        Drinkable dirtyWater = new Drinkable("Dirty Water", 15, 5);
        Medicine stimpack = new Medicine("Stimpack", 40, 0);
        Place store = new Place("Abandoned Convinience Store", raider, cookedRadscorpion, dirtyWater, stimpack);

        store.Discover(player);

    }
}
