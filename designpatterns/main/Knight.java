package main;

import weapon.SwordBehavior;

public class Knight extends Character {

	public Knight(String name){
		super("Paladin" +" " +name);
		super.setWeapon(new SwordBehavior());
	}
	
	
	@Override
	public void fight() {
		System.out.print(super.name + " ");
		weapon.useWeapon();
	}

}
