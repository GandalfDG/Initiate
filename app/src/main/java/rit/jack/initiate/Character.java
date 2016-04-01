package rit.jack.initiate;

import java.util.ArrayList;

/**
 * The character class defines a character with a name, an initiative roll,
 * and a list of active status effects.
 * Created by Jack on 4/1/2016.
 */
public class Character {
    private String characterName;
    //the value of the initiative roll is stored regardless of current initiative position
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
