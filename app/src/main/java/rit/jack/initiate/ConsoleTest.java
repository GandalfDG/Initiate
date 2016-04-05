package rit.jack.initiate;


import java.util.ArrayList;

/**
 * Created by Jack on 4/4/2016.
 */
public class ConsoleTest {
    public static void main(String[] args) {
        StatusEffect poison = new StatusEffect("Con damage", 3, false);
        StatusEffect stun = new StatusEffect("-2 to Attack Rolls", 2, false);
        StatusEffect buff = new StatusEffect("+1 to attack and damage rolls", 0, true);
        ArrayList<StatusEffect> statusEffects = new ArrayList<>();
        statusEffects.add(poison);
        statusEffects.add(buff);
        Character char1 = new Character("Bob", 20);
        Character char2 = new Character("Steve", 18, statusEffects);

        System.out.println(char1.toString());
        System.out.println(char2.toString());

    }
}
