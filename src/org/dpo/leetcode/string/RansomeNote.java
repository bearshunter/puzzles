package org.dpo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {


    public boolean ransomNote(String ransomNote, String magazine) {

        Map<Character, Integer> magazineChars = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineChars.put(c, magazineChars.getOrDefault(c, 0) + 1);
        }

        for(char letter: ransomNote.toCharArray()){
            if(magazineChars.containsKey(letter) && magazineChars.get(letter) > 0){
                int newCount = magazineChars.get(letter) - 1;
                magazineChars.put(letter, newCount);
            } else {
                return false;
            }
        }

        return true;


    }
}
