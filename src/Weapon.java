public class Weapon {
	private String weaponName;
	private int weaponDamage;

	Weapon(){

	}
	Weapon(String _name, int _damage){
		weaponName = _name;
		weaponDamage = _damage;
	}
	public String GetWeaponName(){
		return weaponName;
	}
	public int GetWeaponDamage(){
		return weaponDamage;
	}
}
