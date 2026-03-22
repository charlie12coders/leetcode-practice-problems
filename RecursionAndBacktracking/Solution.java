package RecursionAndBacktracking;

import java.util.*;
// In this solution, I've implemented a backtracking algorithm designed to handle constraints 
// where each input element can be used only once and the input itself may contain duplicates. 
// By sorting the array initially, I can efficiently manage these duplicates. 
// The core logic follows a 'pick-or-skip' pattern: for every element, 
// the algorithm first tries to include it in the sum. After backtracking, 
// it uses a pointer-skipping technique to bypass any identical values before making the
//  next recursive call. This 'skipping' logic is vital because it prevents the algorithm 
// from generating the same combination multiple times through different paths. 
// This results in a clean, unique set of results without the overhead of using a 
// HashSet for post-processing
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        comb(candidates, target, 0, 0, ans, res);

        return res;
    }

    public static void comb(int[] candidates, int target, int idx, int total,List<Integer> ans, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(ans));
            return;
        }

        if (idx >= candidates.length || total > target) {
            return;
        }

        ans.add(candidates[idx]);
        comb(candidates, target, idx + 1, total + candidates[idx], ans, res);
        ans.remove(ans.size() - 1);

        int next = idx + 1;
        while (next < candidates.length && candidates[next] == candidates[idx]) {
            next++;
        }

        comb(candidates, target, next, total, ans, res);
    }
}
