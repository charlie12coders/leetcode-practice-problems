package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// I first sorted the array, which is a key optimization. 
// Sorting allows me to 'prune' the search space: if a candidate is larger than the
//  remaining target, I can break the loop immediately because all following 
// candidates will also be too large.

// The core of the logic is in the recursion. 
// I pass the current index i into the next call to allow for element reuse, and once that branch
//  is fully explored, I backtrack by removing the last element. This 'undo' step lets me
//  reset the state and try the next candidate. When the target hits zero, I've found a valid 
// combination and add a copy of it to my results
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        comb(candidates, 0, candidates.length, target, new ArrayList<>(), res);
        return res;
    }

    static void comb(int[] candidates, int ind, int n, int target, List<Integer> list, List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind; i < n && candidates[i] <= target; i++)
        {
            list.add(candidates[i]);
                
            comb(candidates, i, n, target - candidates[i], list, res);

            list.removeLast();
        }
    }
}
