package main;

import weapon.AxeBehavior;

public class Troll extends Character {

	public Troll(String name){
		super("Moghul" +" " +name);
		super.setWeapon(new AxeBehavior());
	}
	
	
	@Override
	public void fight() {
		System.out.print(super.name + " ");
		weapon.useWeapon();
	}

}
