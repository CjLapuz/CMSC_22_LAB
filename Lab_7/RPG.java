package rpgame;



import rpgame.UnremarkableSlime;
import rpgame.RPGCharacter;
import java.util.Random;
import javax.swing.JOptionPane;

//editable UI from Game
import static rpgame.GameMaster.monsterHP;
import static rpgame.GameMaster.heroHP;
import static rpgame.GameMaster.heroMP;
import static rpgame.GameMaster.message;
import static rpgame.GameMaster.disabled;
import static rpgame.GameMaster.attack;
import static rpgame.GameMaster.dieded;
import static rpgame.GameMaster.skill;
import static rpgame.GameMaster.item;
import static rpgame.GameMaster.type;
import static rpgame.GameMaster.run;
/**
 * Created by ...
 */
public class RPG {
    private Random rand = new Random();
    // constructor
    public RPG() {
        this.rand = new Random();
    }
    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    // hit chance
    public boolean hit(int accuracy) {
        int percent = randInt(0, 100);
        return (percent <= accuracy)? true : false;
    }    
    //Confirmation
    public boolean confirm(){
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure?");
        return choice == 0? true : false;
        
    }
    // Excpected player interaction
    public void playerEvent(){
        message.setText(null);
        attack.setText("NORMAL ATTACK");
        skill.setText("USE SKILL");
        item.setText("INVENTORY");
        run.setText("RUN AWAY");
    }
    // Player interaction not needed
    public void nonPlayerEvent(){
        attack.setText(null);
        skill.setText(null);
        item.setText(null);
        run.setText(null);
    }
    // Player skill select
    public void skillTree(Hero hero){
        attack.setText(hero.skill1());
        skill.setText(hero.skill2());
        item.setText(null);
        run.setText("BACK");
    }
    // battle start..
    public void normal(RPGCharacter hero, RPGCharacter monster){
        attack(hero, monster, 0);
        if (dieded.getText().equals("0")){
        attack(monster, hero , 1);
        }
        type.setText("0");
    }
    //Hero attacks 
    //returns true if monster dies
    public void attack(RPGCharacter attacker, RPGCharacter defender, int who) {
        int damage;
        if (type.getText().equals("1") && who == 0){
            damage = attacker.skillDamage();
        }else {
            damage = attacker.attack();
        }
        nonPlayerEvent();
        if (!(disabled.getText().equals("0")) && who == 1){
            int turns = Integer.parseInt(disabled.getText());
            String status = String.format("%s is %s for %d turn/s", attacker.getName(), defender.skillEffect(), turns);
            JOptionPane.showMessageDialog(null, status, "DISABLED!", 1);
            turns--;
            String newTurns = Integer.toString(turns);
            disabled.setText(newTurns);
            
        } else {
            String event;
            if (hit(attacker.accuracy()) || (type.getText().equals("1") && who == 0)){
                int remHp = defender.takeDamage(damage);
                //Update health
                if (who == 1){ 
                    heroHP.setValue(remHp);
                } else { 
                    monsterHP.setValue(remHp); 
                }
                event = String.format("%s dealt %d damage", attacker.getName(), damage);
                JOptionPane.showMessageDialog(null, event);
                if (remHp <= 0 && who == 0) {
                    dieded.setText("1");
                } else if (remHp <= 0 && who == 1){
                    dieded.setText("-1");
                }
            } else {
                event = String.format("%s missed %s", attacker.getName(), defender.getName());
                JOptionPane.showMessageDialog(null, event);
            }
        }
        playerEvent();
    }
    
}