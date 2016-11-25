package main;

import weapon.KnifeBehavior;

public class Queen extends Character {

	public Queen(String name){
		super("Queen" +" " +name);
		super.setWeapon(new KnifeBehavior());
	}
	
	
	@Override
	public void fight() {
		System.out.print(super.name + " ");
		weapon.useWeapon();
	}

}
