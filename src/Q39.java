import org.junit.Test;

import java.util.*;

/**
 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 candidates 中的数字可以无限制重复被选取。

 说明：
 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。 

 示例 1：
 输入：candidates = [2,3,6,7], target = 7,
 所求解集为：
 [
 [7],
 [2,2,3]
 ]

 示例 2：
 输入：candidates = [2,3,5], target = 8,
 所求解集为：
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]

 * @author chenzk
 * @create 2020-12-12 20:05
 */
public class Q39 {

    @Test
    public void testQ39() {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        //这个list肯定要传进去的
        List<List<Integer>> returnList = new ArrayList<>();
        //从小到大的排序，这里是必需的  吗？其实也不是
        Arrays.sort(candidates);

        recursion(returnList, null, 0, candidates, target);

        return returnList;
    }

    private void recursion(List<List<Integer>> list1, List<Integer> list2, int startIndex, int[] candidates, int target) {
        for(int i = startIndex;i < candidates.length;i++) {
//            if(list2 == null) list2 = new ArrayList<>();
            //如果相匹配，则找到完成组成等式的最后一个数，回溯
            if(candidates[i] == target) {
                List<Integer> list3 = null;
                if(list2 == null) {
                    list3 = new ArrayList<>();
                }else {
                    list3 = new ArrayList<>(list2);
                }
                list3.add(candidates[i]);
                list1.add(list3);
                //return跳出
                return;
            }//说明还有往下搜寻的可能
            else if(candidates[i] < target){
                List<Integer> list3 = null;
                if(list2 == null) {
                    list3 = new ArrayList<>();
                }else {
                    list3 = new ArrayList<>(list2);
                }
                list3.add(candidates[i]);
                recursion(list1, list3, i, candidates, target - candidates[i]);
            }//没有往下搜寻的可能，也无法完成匹配，那么直接返回。
            else {
                return;
            }

            //这里有个问题，如果一直没找到呢？
        }
    }

    private List<List<Integer>> combinationSumStandard(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     *
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len
     * @param target     每次减去一个元素，目标值减小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }
}
