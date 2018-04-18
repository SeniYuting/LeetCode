package solution.d_title31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 */
public class CombinationSumTwo {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, 0, new ArrayList<>(), list);
        return list;
    }

    public static void findSum(int[] candidates, int target, int sum, int index, List<Integer> tmp, List<List<Integer>> list) {
        if (target == sum) {
            list.add(new ArrayList<>(tmp)); // 注意：new ArrayList<>()
            return;
        } else if (target < sum) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tmp.add(candidates[i]);
                // 注意：index为i+1，不重复
                findSum(candidates, target, sum + candidates[i], i + 1, tmp, list);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(candidates, 8);

        for (List<Integer> r : result) {
            for (Integer num : r) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
