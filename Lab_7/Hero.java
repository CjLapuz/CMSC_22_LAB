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
public abstract class Hero extends RPGCharacter{
    public Hero(String name, int hp, int lvl, int mp) {
        super(name, hp, lvl, mp);
    }
    //Implemented by each monster
    public abstract int attack();
    //Implemented by each monster
    public abstract String skill1();
    //Implemented by each monster
    public abstract int skillDamage();
    //Implemented by each monster
    public abstract String skillEffect();
    //Implemented by each monster
    public abstract String skill2();
    @Override
    public String status(){
        return "AAAA";
    } 
    @Override
    public abstract int accuracy();
}
