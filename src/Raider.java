public class Raider {
	private String name;
	private int baseDamage;
	private int health;

	private int money;

	Raider(String _name, int _baseDamage, int _health, int _money){
		name = _name;
		baseDamage = _baseDamage;
		health = _health;
		money = _money;
	}
	public String GetName(){
		return name;
	}

	public void Combat(Player _player){
		System.out.println("============================================================");
		System.out.println("> You get attacked by a " + name + "!");
		int damageMultiplier;
		if (_player.PlayerAttack()>health) damageMultiplier = 1;
			else damageMultiplier = _player.PlayerAttack()/health;
		System.out.println("============================================================");
		System.out.println("You have defeated the " + name);
		int damage = baseDamage * damageMultiplier;
		System.out.println("You lost " + damage + " health");
		System.out.println("You got " + (money) + " caps" );
		_player.SetMoney(_player.GetMoney()+money);
		_player.TakeDamage(damage);
		if (_player.GetHealth() <= 0){
			_player.Die();
		}
	}
}
