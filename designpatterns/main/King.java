package main;

import weapon.BowAndArrowBehavior;

public class King extends Character {

	public King(String name){
		super("Knight" +" " +name);
		super.setWeapon(new BowAndArrowBehavior());
	}
	
	
	@Override
	public void fight() {
		System.out.print(super.name + " ");
		weapon.useWeapon();
	}
}
