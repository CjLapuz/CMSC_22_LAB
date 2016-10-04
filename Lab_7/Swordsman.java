package rpgame;


import rpgame.Hero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class Swordsman extends Hero {
    private static final int BASE_DMG = 15;
    private static final int ARMOR = 9;
    private static final int ACCURACY = 80;
    private static final int BASE_HEALTH = 250;
    private static final int MANA = 170;
    
    private int damage;

    public Swordsman(String name, int level) {
        super(name, BASE_HEALTH, level, MANA);
    }
    @Override
    public int attack() {
        if (super.getLevel() > 1){ damage = BASE_DMG + super.getLevel() * 2 ;}
        else { damage = BASE_DMG; }
        return  damage;
    }
    @Override
    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
    @Override
    public int accuracy(){return ACCURACY;}
    @Override
    public String skill1(){ return "Great Slash";}
    @Override
    public int skillDamage(){ return attack() * 2;}
    @Override
    public String skill2(){ return "Stunning Blow"; }
    @Override
    public String skillEffect(){return "Stunned";}
}