package rpgame;


import rpgame.RPGCharacter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public abstract class Monster extends RPGCharacter{
    private int attackDamage;
    private final int ACCURACY = 90;
    
    public Monster(String name, int hp, int attackDamage, int lvl) {
        super(name, hp, lvl, 0);
        this.attackDamage = attackDamage;
    }
    //Implemented by each monster
    public abstract int attack();
    //Implemented by each monster
    public abstract int skillDamage();
    //Implemented by each monster
    public abstract String skillEffect();
    @Override
    public String status(){
        return "AAAAAHHH";
    }
    @Override
    public int accuracy(){return ACCURACY;}
    //Drop Item when dead
    public void dropItem(){
        if (!isAlive()){
        //drop something
        }
    }

}
