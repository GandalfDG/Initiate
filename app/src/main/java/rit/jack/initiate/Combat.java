package rit.jack.initiate;

import java.util.ArrayList;
import java.util.Collections;

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
}
