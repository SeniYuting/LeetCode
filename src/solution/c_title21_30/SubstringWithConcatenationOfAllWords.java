package solution.c_title21_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters.
 * <p>
 * 思路：滑动窗口，字符串处理中，将复杂度降低到线性的有效算法
 * <p>
 * 这题太烧脑~
 */
public class SubstringWithConcatenationOfAllWords {


    // Time Limit Exceeded
    public static List<Integer> findSubstringTry(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }

        // 使用hashMap存储words中String的个数，因为可能包含相同字符串
        Map<String, Integer> map = initMap(words);

        int len = words[0].length(); // 等长str的长度设为len

        for (int i = 0; i <= s.length() - words.length * len; i++) {
            int from = i;
            String str = s.substring(from, from + len);

            int count = 0; // 用于计算每个单词是否出现一次
            while (map.containsKey(str) && map.get(str) != 0) {
                count++;
                map.put(str, map.get(str) - 1);
                from += len;

                // 处理越界
                if (from + len > s.length()) {
                    break;
                }
                str = s.substring(from, from + len);
            }

            if (count == words.length) {
                list.add(i);
            }

            if (count > 0) {
                // 重新初始化map
                map = initMap(words);
            }

        }

        return list;
    }

    public static Map<String, Integer> initMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        return map;
    }

    // Accepted
    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }

        // 使用hashMap存储words中String的个数，因为可能包含相同字符串
        Map<String, Integer> map = initMap(words);

        int len = words[0].length(); // 等长str的长度设为len

        for (int i = 0; i < len; i++) {

            // 得到单词 i, i+len, i+2*len ...

            int count = 0; // 用于计算每个单词是否出现一次
            int left = i;
            Map<String, Integer> currMap = new HashMap<>();

            for (int j = i; j <= s.length() - len; j += len) {
                String str = s.substring(j, j + len);

                if (map.containsKey(str)) {
                    if (currMap.containsKey(str)) {
                        currMap.put(str, currMap.get(str) + 1);
                    } else {
                        currMap.put(str, 1);
                    }
                    if (currMap.get(str) <= map.get(str)) {
                        count++;
                    } else {
                        while (currMap.get(str) > map.get(str)) {
                            String tmp = s.substring(left, left + len);
                            if (currMap.containsKey(tmp)) {
                                currMap.put(tmp, currMap.get(tmp) - 1);
                                if (currMap.get(tmp) < map.get(tmp)) {
                                    count--;
                                }
                            }
                            left += len;
                        }
                    }
                    if (count == words.length) {
                        list.add(left);
                        String tmp = s.substring(left, left + len);
                        if (currMap.containsKey(tmp)) {
                            currMap.put(tmp, currMap.get(tmp) - 1);
                        }
                        count--;
                        left += len;
                    }
                } else {
                    currMap.clear();
                    count = 0;
                    left = j + len;
                }
            }

        }

        return list;
    }

    public static void main(String[] args) {
        String[] words = {"foo", "bar"};
//        List<Integer> result = findSubstringTry("barfoothefoobarman", words);
        List<Integer> result = findSubstring("barfoothefoobarman", words);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

        System.out.println();

        String[] words1 = {"bar", "foo", "the"};
//        List<Integer> result1 = findSubstringTry("barfoofoobarthefoobarman", words1);
        List<Integer> result1 = findSubstring("barfoofoobarthefoobarman", words1);
        for (int i = 0; i < result1.size(); i++) {
            System.out.print(result1.get(i) + " ");
        }

        System.out.println();

        String[] words2 = {"word", "good", "best", "good"};
//        List<Integer> result2 = findSubstringTry("wordgoodgoodgoodbestword", words2);
        List<Integer> result2 = findSubstring("wordgoodgoodgoodbestword", words2);
        for (int i = 0; i < result2.size(); i++) {
            System.out.print(result2.get(i) + " ");
        }

    }

}
