package P0205_IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    /**
     * LeetCode Problem: 205. Isomorphic Strings
     *
     * Approach:
     * Use two integer arrays of size 256 (assuming extended ASCII) to simulate character mapping:
     * - mapST[chS] stores the mapped character from s to t
     * - mapTS[chT] stores the mapped character from t to s
     * If a mapping already exists, verify it matches the current character;
     * otherwise, store the new mapping.
     *
     * This method avoids HashMap overhead and improves performance for fixed-size character sets.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) - constant space, since array size is fixed (256)
     */
    public boolean isIsomorphicWithArray(String s, String t) {

        int[] mapST = new int[256];  // s → t
        int[] mapTS = new int[256];  // t → s

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mapST[chS] == 0 && mapTS[chT] == 0) {
                mapST[chS] = chT;
                mapTS[chT] = chS;
            } else {
                if (mapST[chS] != chT || mapTS[chT] != chS) return false;
            }
        }

        return true;
    }

    /**
     * LeetCode Problem: 205. Isomorphic Strings
     *
     * Approach:
     * Use two HashMaps to create a bidirectional mapping from characters in string s to t and from t to s.
     * For each character pair (s[i], t[i]), we ensure the mapping is consistent both ways:
     * - If s[i] is already mapped to a character, it must match t[i]
     * - If t[i] is already mapped to a character, it must match s[i]
     *
     * This avoids the "many-to-one" and "one-to-many" mapping conflicts.
     *
     * Time Complexity: O(n) - where n is the length of the strings
     * Space Complexity: O(n) - for the two HashMaps
     */
    public boolean isIsomorphicWithMap(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for(int i = 0; i < sArr.length; i++) {

            if(tMap.containsKey(tArr[i])) {
                if(tMap.get(tArr[i]) != sArr[i]) {
                    return false;
                }
            } else {
                tMap.put(tArr[i], sArr[i]);
            }

            if(sMap.containsKey(sArr[i])) {
                if(sMap.get(sArr[i]) != tArr[i]) {
                    return false;
                }
            } else {
                sMap.put(sArr[i], tArr[i]);
            }

        }

        return true;

    }

}
