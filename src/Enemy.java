public class Enemy {
	private String name;
	private int baseDamage;
	private int damage;
	private int health;

	private Food enemyFood;
	private Drinkable placeDrink;
	private Medicine placeMedicine;

	Enemy(String _name, int _baseDamage, int _health){
		name = _name;
		baseDamage = _baseDamage;
		health = _health;
	}
	public String GetName(){
		return name;
	}
	public int EnemyAttack(){
		return damage;
	}

	public void StartCombat(Player _player){
		System.out.println("You have defeated the " + name);
		System.out.println("You lost " + baseDamage + " health");
		_player.TakeDamage(baseDamage);
		if (_player.GetHealth() <= 0){
			_player.Die();
		}
	}

	public void TakeDamage(){
		
	}
}
