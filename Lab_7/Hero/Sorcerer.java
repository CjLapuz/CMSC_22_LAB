/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame;

/**
 *
 * @author Jeremy
 */
public class Sorcerer extends Hero{
    private static final int BASE_DMG = 45;
    private static final int ARMOR = 0;
    private static final int ACCURACY = 75;
    private static final int BASE_HEALTH = 140;
    private static final int MANA = 400;
    
    private int damage;
    public Sorcerer(String name, int level) {
        super(name, BASE_HEALTH, level, MANA);
    }

    public int attack() {
        if (super.getLevel() > 1){ damage = BASE_DMG + super.getLevel() * 2 ;}
        else { damage = BASE_DMG; }
        return damage;
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
    @Override
    public int accuracy(){return ACCURACY;}
    @Override
    public String skill1(){ return "Meteor";}
    @Override
    public int skillDamage(){ return attack() * 3 + 40;}
    @Override
    public String skill2(){ return "Petrification"; }
    @Override
    public String skillEffect(){return "Petrified";}
}
