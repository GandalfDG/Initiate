package rit.jack.initiate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * The character class defines a character with a name, an initiative roll,
 * and a list of active status effects.
 * Created by Jack on 4/1/2016.
 */
public class Character implements Comparable<Character>, Comparator<Character> {
    private String characterName;
    /* the value of the initiative roll is stored regardless of current initiative position */
    private int initiativeRoll;
    private int initiativeNumber; //this is the number in the list of characters. This can change.
    private ArrayList<StatusEffect> statusEffects;
    private Iterator<StatusEffect> statusIterator;

    public Character(String characterName, int initiativeRoll) {
        this.characterName = characterName;
        this.initiativeRoll = initiativeRoll;
        statusEffects = new ArrayList<StatusEffect>();
        statusIterator =  statusEffects.iterator();
    }

    public Character(String characterName, int initiativeRoll, ArrayList<StatusEffect> statusEffects) {
        this.characterName = characterName;
        this.initiativeRoll = initiativeRoll;
        this.statusEffects = statusEffects;
        statusIterator = statusEffects.iterator();
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

    /**
     * prints out all of the character object's information in a human-readable format
     * @return a human-readable string
     */
    public String toString() {
        return "name: " + characterName + "; initiativeRoll: "  + initiativeRoll
                + "; initiativeNumber: " + initiativeNumber + System.lineSeparator()
                + "statusEffects: " + System.lineSeparator() + statusEffectsString()
                + System.lineSeparator();
    }


    public ArrayList<StatusEffect> getStatusEffects() {
        return statusEffects;
    }

    private String statusEffectsString() {
        String statusEffectsString = System.lineSeparator();
        if(statusEffects.size() == 0) return "none";
        while(statusIterator.hasNext()) {
            statusEffectsString += statusIterator.next().toString() + System.lineSeparator();
        }
        return statusEffectsString;
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

    public int getInitiativeNumber() {
        return initiativeNumber;
    }

    public void setInitiativeNumber(int initiativeNumber) {
        this.initiativeNumber = initiativeNumber;
    }

    /* this will allow a list of characters to be sorted by initiative */
    @Override
    public int compareTo(Character c) {
        Integer roll = initiativeRoll;
        return roll.compareTo(c.getInitiativeRoll());
    }

    private static Comparator<Character> initiativeNumberComparator = new Comparator<Character>() {
        @Override
        public int compare(Character lhs, Character rhs) {
            Integer lhNumber = lhs.getInitiativeNumber();
            Integer rhNumber = rhs.getInitiativeNumber();
            return lhNumber.compareTo(rhNumber);
        }
    };

    public static Comparator<Character> getInitiativeNumberComparator() {
        return initiativeNumberComparator;
    }

    @Override
    public int compare(Character lhs, Character rhs) {
        return 0;
    }
}
