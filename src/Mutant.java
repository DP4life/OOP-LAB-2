public class Mutant {
	private String name;
	private int baseDamage;
	private int health;


	Mutant(String _name, int _baseDamage, int _health){
		name = _name;
		baseDamage = _baseDamage;
		health = _health;
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
		System.out.println("You got " + damage + " radiation");
		_player.TakeRadiation(damage);
		if (_player.GetHealth() <= 0){
			_player.Die();
		}
	}
}
