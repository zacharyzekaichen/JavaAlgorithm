import org.junit.Test;

import javax.sound.midi.MidiChannel;

/**
 * @author chenzk
 * @create 2020-12-02 11:09
 */
public class Q35 {

    @Test
    public void testQ35(){
        System.out.println(searchInsert1(new int[]{1,3,5,6},2));
    }

    private int searchInsert1(int[] nums, int target){
        if(nums.length == 0 || target <= nums[0]) {return 0;}
        else if(target >= nums[nums.length - 1]) {return (target > nums[nums.length-1])? nums.length : nums.length - 1;}

        int mIndex;
        //i<j-1 给前索引和后索引中间留出至少一个可以做判断的数组位置。
        //i代表前指针对应的索引，j代表后指针对应的索引。
        int i = 0;
        int j = nums.length - 1;
        for(;i < j - 1;){
            mIndex = (j + i) / 2; //(j - i)/2 + i;
            if(nums[mIndex] == target) {
                return mIndex;
            } else if(target < nums[mIndex]) {
                j = mIndex;
            } else if(target > nums[mIndex]) {
                i = mIndex;
            }

        }

        return j;
    }
}
