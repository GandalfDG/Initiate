package rit.jack.initiate;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The character class defines a character with a name, an initiative roll,
 * and a list of active status effects.
 * Created by Jack on 4/1/2016.
 */
public class Character implements Comparable<Character> {
    private String characterName;
    /* the value of the initiative roll is stored regardless of current initiative position */
    private int initiativeRoll;
    private ArrayList<StatusEffect> statusEffects;  //TODO build status effect class

    public Character(String characterName, int initiativeRoll) {
        this.characterName = characterName;
        this.initiativeRoll = initiativeRoll;
        statusEffects = new ArrayList<StatusEffect>();
    }

    public Character(String characterName, int initiativeRoll, ArrayList<StatusEffect> statusEffects) {
        this.characterName = characterName;
        this.initiativeRoll = initiativeRoll;
        this.statusEffects = statusEffects;
    }

    /* after a character's turn is taken, the duration of status effects is decremented by 1 */
    public void updateStatusDuration() {
        Iterator<StatusEffect> statusIterator = statusEffects.iterator();
        /* iterate through the list of status effects */
        while(statusIterator.hasNext()) {
            StatusEffect status = statusIterator.next();
            status.decrementDuration();
            /* if the status effect duration hits 0, remove it from the list */
            if(status.getDuration() <= 0) statusIterator.remove();
        }
    }

    /* this will allow a list of characters to be sorted by initiative */
    public int compareTo(Character c) {
        Integer roll = initiativeRoll;
        return roll.compareTo(c.getInitiativeRoll());
    }

    public String getCharacterName() {
        return characterName;
    }

    //this may be useful for appending numbers to duplicate characters
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getInitiativeRoll() {
        return initiativeRoll;
    }

    //this may be unnecessary, but I'll leave it
    public void setInitiativeRoll(int initiativeRoll) {
        this.initiativeRoll = initiativeRoll;
    }

    public void addStatusEffect(StatusEffect effect) {
        statusEffects.add(effect);
    }
}
