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
public class FireElemental extends Monster{
    private static final int BASE_DAMAGE = 35;
    private static final int BASE_HP = 120;
    
    private int damage;
    
    public FireElemental(int lvl){
        super("Ifrit", BASE_HP, BASE_HP, lvl);
        if (lvl > 1){ damage = BASE_DAMAGE * lvl / 2; }
        else { damage = BASE_DAMAGE; }
    }
    @Override
    public int attack(){
        return damage;
    }
    @Override 
    public int skillDamage(){return 0;}
    @Override
    public String skillEffect(){return "";}
    
}
