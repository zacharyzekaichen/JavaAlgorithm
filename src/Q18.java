import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 注意：
 答案中不可以包含重复的四元组。

 示例：
 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 满足要求的四元组集合为：
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]

 * @author chenzk
 * @create 2020-12-10 16:18
 */
public class Q18 {

    @Test
    public void testQ18() {
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        List<List<Integer>> list = fourSum1(nums, target);
        System.out.println(list);
    }

    private List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        if(nums == null || nums.length < 4) return returnList;
        Arrays.sort(nums);
        //四指针
        int third = 0;
        int fourth = 0;
        //两个移动指针对应的数之和
        int twoSum = 0;
        //temp
        List<Integer> tempList = null;
        for(int first = 0;first < nums.length;first++) {
            //边界情况
//            if(nums[first] > target) break;
            if(first > 0 && nums[first] == nums[first - 1]) continue;
            if(first + 1 == nums.length) break;

            for(int second = first+1;second < nums.length;second++){
                if(second > first+1 && nums[second] == nums[second - 1]) continue;
                if(second + 1 == nums.length) break;

                third = second + 1;
                fourth = nums.length - 1;
                twoSum = target - nums[first] - nums[second];
                while(third < fourth) {
                    if(twoSum == nums[third] + nums[fourth]) {
                        tempList = new ArrayList<>();
                        tempList.add(nums[first]);
                        tempList.add(nums[second]);
                        tempList.add(nums[third]);
                        tempList.add(nums[fourth]);
                        returnList.add(tempList);
                        while(third < fourth && nums[third] == nums[third + 1]) third++;
                        third++;
                    }else if(twoSum > nums[third] + nums[fourth]) {
                        while(third < fourth && nums[third] == nums[third + 1]) third++;
                        third++;
                    }else {
                        while(third < fourth && nums[fourth] == nums[fourth - 1]) fourth--;
                        fourth--;
                    }
                }
            }
        }

        return returnList;
    }
}
