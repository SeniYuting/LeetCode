package solution.d_title31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * 递归
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, 0, tmp, list);
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
                tmp.add(candidates[i]);
                findSum(candidates, target, sum + candidates[i], i, tmp, list);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(candidates, 7);

        for (List<Integer> r : result) {
            for (Integer num : r) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
