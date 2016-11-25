package main;

import weapon.WeaponBehavior;

public abstract class Character {
	String name;
	WeaponBehavior weapon;
	
	public Character(String name){
		this.name = name;
	}
	
	public abstract void fight();
	
	public void setWeapon(WeaponBehavior weapon){
		this.weapon = weapon;
	}
}
