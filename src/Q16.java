import java.util.Arrays;

/**
 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 示例：
 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

 * @author chenzk
 * @create 2020-12-12 15:24
 */
public class Q16 {
    private int threeSumCloset(int[] nums, int target) {
        //升序排列
        Arrays.sort(nums);
        int minSum = nums[0] + nums[1] + nums[2];

        for(int first = 0;first < nums.length - 1;first++) {
            //指针的移动
            if(first > 0 && nums[first] == nums[first - 1]) continue;
            if(first + 1 > nums.length) break;

            int second = first + 1;
            int third = nums.length - 1;
            int threeSum;
            while(second < third) {
                threeSum = nums[first] + nums[second] + nums[third];
                //加起来的和与target相等
                if(threeSum - target == 0) return target;
                //更接近的便刷新
                if(Math.abs(threeSum - target) < Math.abs(minSum - target)) minSum = threeSum;
                if(threeSum < target) {
                    second++;
                }else if(threeSum > target) {
                    third--;
                }
            }
        }

        return minSum;
    }
}
