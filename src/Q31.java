import org.junit.Test;

import java.util.Arrays;

/**
 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 必须 原地 修改，只允许使用额外常数空间。

 示例 1：
 输入：nums = [1,2,3]
 输出：[1,3,2]

 示例 2：
 输入：nums = [3,2,1]
 输出：[1,2,3]

 示例 3：
 输入：nums = [1,1,5]
 输出：[1,5,1]

 示例 4：
 输入：nums = [1]
 输出：[1]

 * @author chenzk
 * @create 2020-12-12 14:14
 */
public class Q31 {

    @Test
    public void testQ31() {
        int[] nums = new int[]{5,2,3,6,1,7,4};
        System.out.println(Arrays.toString(nums));
        nextPermutation2(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void nextPermutation1(int[] nums) {
        if(nums == null || nums.length <= 1) return;

//        int count = nums.length;

    }

    //完全没思路的一道题
    //但这道题的解题来源更倾向于来自数学的思维
    private void nextPermutation2(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        int small = nums.length - 2;
        //如果指针所对的数大于后一个数，那么指针往前移动
        while(small >= 0 && nums[small] >= nums[small + 1]) {
            small--;
        }
        //跳出while循环：两种情况
        //count==-1了，说明到达最大序列，回归最小序列
        int temp;
        if(small >= 0) {
            //找到比它大的较小的那个数
            int big = nums.length - 1;
            while(big > small+1 && nums[big] <= nums[small]) {
                big--;
            }
            //swap
            temp = nums[big];
            nums[big] = nums[small];
            nums[small] = temp;
        }
        //reverse
        int left = small + 1, right = nums.length - 1;
        while(left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
