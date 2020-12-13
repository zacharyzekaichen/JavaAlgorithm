import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author chenzk
 * @create 2020-12-13 15:49
 */
public class Q40 {

    @Test
    public void testQ40() {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum1(candidates, target);
        System.out.println(lists);
    }

    private List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            returnList.add(new ArrayList<>());
            return returnList;
        }
        //先做一个排序
        Arrays.sort(candidates);
        List<Integer> pathList = new ArrayList<>();
//        int depth = 0;
//        HashSet<Integer> usedIndex = new HashSet<>();
        recursion(returnList, pathList, candidates, target, 0);

        return returnList;
    }

    private void recursion(List<List<Integer>> returnList, List<Integer> pathList, int[] candidates, int target, int startIndex) {
        //找到点了，添加，回溯
        if (target == 0) {
            returnList.add(new ArrayList<>(pathList));
            return;
        }
        //不等于0，且到底了，说明没找到，拜拜，
//        if(usedIndex.size() == candidates.length) return;

        for (int i = startIndex; i < candidates.length; i++) {
            //这里可以考虑更高效的剪枝条件
            //当前点，实际上是除了已经遍历过的点的最小的点了
            //该点都比target大，后面的点也没有遍历的必要了。
            if (target < candidates[i]) break;
            if(i > startIndex && candidates[i] == candidates[i - 1]) continue;

            pathList.add(candidates[i]);
            //usedIndex.add(i);
            //有变化的是：pathList, usedIndex, target
            recursion(returnList, pathList, candidates, target - candidates[i], i + 1);
            //还原现场
            pathList.remove(pathList.size() - 1);
            //usedIndex.remove(i);

        }
    }
}
