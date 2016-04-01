package rit.jack.initiate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A combat is a list of characters ordered by their initiative order (not necessarily their
 * initiative roll value).
 * Created by Jack on 4/1/2016.
 */
public class Combat {
    private ArrayList<Character> combatList;
    private Character currentCharacter;

    public Combat(ArrayList<Character> combatList) {
        this.combatList = combatList;
    }

    /**
     * sorts the combat list by initiative roll value and sets currentCharacter to the
     * first character in the list.
     */
    public void startCombat() {
        Collections.sort(combatList);
        currentCharacter = combatList.get(0);
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

    }
}
