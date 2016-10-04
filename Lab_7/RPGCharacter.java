package rpgame;

/**
 * Created by ... 
 */
public abstract class RPGCharacter {

    private String name;
    private int baseHp;
    private int baseMp;
    private int hp;
    private int lvl;
    private int mp;

    public RPGCharacter(String name, int hp, int lvl, int mp) {
        this.name = name;
        this.lvl = lvl;
        baseHp = hp;
        baseMp = mp;
        setHp(hp);
        setMP(mp);
    }

    // implement in subclass
    public abstract int attack();
    
    // implement in subclass
    public abstract int accuracy();
    
    //damage done by skills
    public abstract int skillDamage();
    
     //damage done by skills
    public abstract String skillEffect();
    
    //Checks if the unit is poisoned, stunned, etc.
    public abstract String status();
    
    //Health update after levelling 
    public void updateHealth(){
        int newHP = baseHp * lvl - 20;
        setHp(newHP);
    }
    //Health update after levelling 
    public void updateMana(){
        int newMP = baseMp * lvl - 40;
        setMP(newMP);
    }
    // checks to see if character is still alive
    public boolean isAlive() {
        return hp > 0 ? true : false;
    }
    
    // may be overriden in subclass, damage is dependent on hero type
    public int takeDamage(int damage) {
        if (damage > 0){ hp -= damage; }
        return hp;
    }
    // may be overriden in subclass, mp usage is dependent on hero type
    public int takeMP(int manaCost) {
        if (manaCost > 0){ mp -= manaCost; }
        return mp;
    }
    // getters setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getLevel() { return lvl; }
    public int getMP(){ return mp; } 
    public void setMP(int mp) {this.mp = mp;}
    public void levelUp(int level) { this.lvl += level;}
    @Override
    public String toString(){
        String out = String.format("Name: %s\n"
                        + "Level %d\n"
                        + "HP %d\n"
                        + "MP: %d", name, lvl, hp, mp);
        return out;
    }
}