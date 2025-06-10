package P0049_GroupAnagrams;

import java.util.*;

public class GroupAnagrams {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();

            for(String str : strs) {
                char[] curr = str.toCharArray();
                Arrays.sort(curr);
                String sortStr = new String(curr);

                if(map.containsKey(sortStr)) {
                    map.get(sortStr).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(sortStr, list);
                }
            }

            return new ArrayList<>(map.values());
        }
    }

}
