/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgame;

import java.util.Random;

/**
 *
 * @author Jeremy
 */
public class Assassin extends Hero{
    private static final int BASE_DMG = 29;
    private static final int ARMOR = 3;
    private static final int ACCURACY = 88;
    private static final int BASE_HEALTH = 200;
    private static final int MANA = 170;
    private static final int CRIT_CHANCE = 60;
    
    private Random rand = new Random();
    
    private int damage;
    public Assassin(String name, int level) {
        super(name, BASE_HEALTH, level, MANA);
        this.rand = new Random();
    }

    public int attack() {
        if (super.getLevel() > 1){ damage = BASE_DMG + super.getLevel() * 2 ;}
        else { damage = BASE_DMG; }
        if(crit(CRIT_CHANCE)) { damage *= 2; }
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
    public String skill1(){ return "Assassinate";}
    @Override
    public int skillDamage(){ return attack() * 3;}
    @Override
    public String skill2(){ return "Blinding Light"; }
    @Override
    public String skillEffect(){return "Blind";}
    
    
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    // hit chance
    public boolean crit(int accuracy) {
        int percent = randInt(0, 100);
        return (percent <= accuracy)? true : false;
    } 
}
