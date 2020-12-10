import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 注意：答案中不可以包含重复的三元组。

 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 * @author chenzk
 * @create 2020-12-10 9:34
 */
public class Q15 {

    @Test
    public void testQ15() {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0,0};
        List<List<Integer>> list = threeSumStandard(nums);
        System.out.println(list);
    }

    private List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return null;
        List<Integer> tempS = null;
        List<List<Integer>> tempB = null;
        List<Integer> returnValS = null;
        List<List<Integer>> returnValB = new ArrayList<>();
        List<List<Integer>> indexList = null;
        //想法是Hashmap
        HashMap<Integer,List<List<Integer>>> map = new HashMap<>();
        //前两个数相加的结果先放入map中
        tempS = new ArrayList<>();
        tempS.add(0);
        tempS.add(1);
        tempB = new ArrayList<>();
        tempB.add(tempS);
        map.put(nums[0]-nums[1], tempB);
        for(int i = 2;i < nums.length;i++) {
            if(map.containsKey(0 - nums[i])) {
                indexList = map.get(0 - nums[i]);
                for(List<Integer> index : indexList) {
                    returnValS = new ArrayList<>();
                    returnValS.add(nums[index.get(0)]);
                    returnValS.add(nums[index.get(1)]);
                    returnValS.add(nums[i]);
                    returnValB.add(returnValS);
                }
            }
            //两数之和添加进入map
            for(int j = i - 1;j >= 0;j--) {
                int twoSum = nums[i] + nums[j];
                if(! map.containsKey(twoSum)) {
                    tempS = new ArrayList<>();
                    tempS.add(j);
                    tempS.add(i);
                    tempB = new ArrayList<>();
                    tempB.add(tempS);
                    map.put(twoSum, tempB);
                }else {
                    tempS = new ArrayList<>();
                    tempS.add(j);
                    tempS.add(i);
                    tempB = map.get(twoSum);
                    tempB.add(tempS);
                }
            }
        }

        return returnValB;
    }

    private List<List<Integer>> threeSumStandard(int[] nums) {
        List<List<Integer>> returnValB = new ArrayList<>();
        if(nums == null || nums.length < 3) return returnValB;
        List<Integer> addTempList = null;
        //左右两个指针
        int L = 0;
        int R = 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++) {
            //几种边界情况，退出的条件或者指针往后移动的条件
            //最小的数都大于零，退出
            if(nums[i] > 0) break;
            //指针当前指的数与之前的相同，继续向前
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            //指针的后一位越界了，退出
            if(i + 1 == nums.length) break;

            L = i + 1;
            R = nums.length - 1;
            while(L < R) {
                if(L > i+1 && nums[L] == nums[L - 1]) {
                    L++;
                    continue;
                }
                if(R < nums.length - 1 && nums[R] == nums[R + 1]) {
                    R--;
                    continue;
                }

                int threeSum = nums[i] + nums[L] + nums[R];
                if(threeSum == 0) {
                    addTempList = new ArrayList<>();
                    addTempList.add(nums[i]);
                    addTempList.add(nums[L]);
                    addTempList.add(nums[R]);
                    returnValB.add(addTempList);
                    L++;
                }else if(threeSum < 0) {
                    L++;
                }else {
                    R--;
                }
            }

        }

        return returnValB;
    }
}
