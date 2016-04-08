package rit.jack.initiate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * A combat is a list of characters ordered by their initiative order (not necessarily their
 * initiative roll value).
 * Created by Jack on 4/1/2016.
 */
public class Combat {
    private ArrayList<Character> combatList;
    private ArrayList<Character> readiedActions;
    private Character currentCharacter;
    private Iterator<Character> combatIterator;
    private int currentCharacterPos; // a pointer to the current character in the list
    private int roundEndPos; // a pointer to the character after which a new round begins
    private int roundNum;

    public Combat(ArrayList<Character> combatList) {
        this.combatList = combatList;
        combatIterator = this.combatList.iterator();
        startCombat();
    }

    /**
     * sorts the combat list by initiative roll value and sets currentCharacter to the
     * first character in the list.
     */
    public void startCombat() {
        Collections.sort(combatList);
        assignInitiativeNumbers();
        currentCharacterPos = 0;
        currentCharacter = getCurrentCharacter();
        roundNum = 0;
        roundEndPos = combatList.size() - 1;
    }

    public void nextTurn() {
        // when a character's turn ends, decrement his status effect durations
        currentCharacter.updateStatusDuration();
        currentCharacterPos++;

        /** if the next character is the first character in the new round
         * increment the round number counter.
         */
        if(currentCharacterPos == roundEndPos + 1) {
            roundNum++;
        }

        /* if the end of the combat list is reached, reset the pointer to the
         * first character in the list.
         */
        if(currentCharacterPos >= combatList.size()) {
            currentCharacterPos = 0;
        }

        currentCharacter = getCurrentCharacter();
    }

    public void readyAction() { //TODO figure this out
    }

    public void delayAction(int position) {
        combatList.add(position, currentCharacter);
        combatList.remove(currentCharacterPos);
        assignInitiativeNumbers();
    }

    private Character getCurrentCharacter() {
        return combatList.get(currentCharacterPos);
    }

    /**
     * traverses the combatList sorted by initiative roll and assigns turn numbers
     */
    private void assignInitiativeNumbers() {
        for(int i = 0; i < combatList.size(); i++) {
            combatList.get(i).setInitiativeNumber(i + 1);
        }
    }

    /**
     * sorts the combat list by initiative number rather than by initiative roll
     */
    private void sortCombat() {
        Collections.sort(combatList, Character.getInitiativeNumberComparator());
    }

    /** adds a character to the initiative order at the position indicated
     *  I think initiative roll is just going to be used for the initial sort, and initiative
     *  number will be used after that. That will accommodate for delays and readied actions
     * @param c the character object to be added to the turn order
     * @param position the position where the character will be inserted
     */
    public void addCharacter(Character c, int position) {
        combatList.add(position, c);
        assignInitiativeNumbers();
        roundEndPos++;
    }
}
