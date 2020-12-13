import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 示例:
 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 * @author chenzk
 * @create 2020-12-13 14:40
 */
public class Q46 {

    @Test
    public void testQ46() {
        int[] nums = new int[]{1,2};
        List<List<Integer>> lists = permute1(nums);
        System.out.println(lists);
    }

    private List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(nums == null || nums.length == 0) return returnList;

        //排列，需要used
        List<Integer> pathList = new ArrayList<>();
        HashSet<Integer> usedIndex = new HashSet<>();
        recursion(returnList, pathList, nums, usedIndex);

        return returnList;
    }

    private void recursion(List<List<Integer>> resultList, List<Integer> pathList, int[] nums, HashSet<Integer> usedIndex) {
        //回溯点：当数组内已经没有数可以给我选的时候，说明都选完了，添加，回溯。
        if(usedIndex.size() == nums.length) {
            //这里有值传递的问题
            resultList.add(new ArrayList<>(pathList));
//            return;
        }//当数组内还有数可以给我选的时候，继续选
        else {
            for(int i = 0;i < nums.length;i++) {
                //如果当点已经被选过了，说明这条路走不通了，回去（这里的理解有问题，走不通不是回去，而是不往下走）
//                if(usedIndex.contains(i)) {
                    //这里要return吗？
                    //这里return实际上是有问题的
//                }
                if(! usedIndex.contains(i)) {
                    pathList.add(nums[i]);
                    usedIndex.add(i);
                    //主要刷新位置：usedIndex
                    recursion(resultList, pathList, nums, usedIndex);
                    //状态重置
                    pathList.remove(pathList.size() - 1);
                    usedIndex.remove(i);
                }
            }
        }
    }
}
