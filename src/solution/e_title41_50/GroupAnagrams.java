package solution.e_title41_50;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * 思路：
 * 维持一个Map<String, List>, key是有序的String，value是无序String组成的list
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(str);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(strs);
        for (List li : list) {
            for (Object l : li) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
