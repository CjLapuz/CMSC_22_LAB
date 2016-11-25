package main;
import weapon.BowAndArrowBehavior;

public class Queen extends Character {

	public Queen(String name){
		super("Queen" +" " +name);
		super.setWeapon(new BowAndArrowBehavior());
	}
	
	
	@Override
	public void fight() {
		System.out.print(super.name + " ");
		weapon.useWeapon();
	}

}
