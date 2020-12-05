import org.junit.Test;

/**
 * @author chenzk
 * @create 2020-12-04 16:08
 */
public class Q209 {

    @Test
    public void testQ209() {
        int[] arr = new int[]{};
        System.out.println(minSubArrayLen(16, arr));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums[0] >= s) return 1;

        int left = 0, right = 1;
        int sum = nums[0];
        int minL = nums.length;
        //如果只有一个元素的话，由于right<length不成立，不进入下面的循环
        //边界条件是什么有待商榷
        for(;right < nums.length;) {
            //当加上right之后sum还不满足条件，说明还需要继续加。
            //这里的理解是有问题的
            if(nums[right] + sum < s/*会出现多加的情况，有意思的是，判断条件是加，但是是一种预测*/) {
                sum += nums[right];
                right++;
            }
            //当加上right之后sum满足条件，说明
            else {
                if(nums[right] >= s) return 1;

                minL = Math.min(minL, right-left+1);
                sum -= nums[left];
                left++;
            }
        }

        //感觉也不对，确实不对，万一整串加起来满足条件呢
        //这样修改应该就是对的
        if(left == 0) {
            System.out.println("没有满足条件的子数组");
            return 0;
        }
        return minL;
    }
}
