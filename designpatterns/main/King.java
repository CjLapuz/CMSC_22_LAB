package main;
import weapon.KnifeBehavior;

public class King extends Character {

	public King(String name){
		super("Knight" +" " +name);
		super.setWeapon(new KnifeBehavior());
	}
	
	
	@Override
	public void fight() {
		System.out.print(super.name + " ");
		weapon.useWeapon();
	}
}
