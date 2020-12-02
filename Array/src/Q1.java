import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**Q1主要思路：1.暴力求解 2.哈希映射
 * @author chenzk
 * @create 2020-12-02 8:36
 */
public class Q1 {

    @Test
    public void testQ1(){
        int[] result = twoSum1(new int[]{2, 7, 11, 15},9);
        System.out.println(Arrays.toString(result));
    }

    private int[] twoSum(int[] nums, int target){
        //考虑输入数组的情况，显然当输入数组元素个数小于2时不存在两数之和的说法。
        if(nums == null || nums.length < 2) {return null;}

        int[] returnIndex = new int[]{0, 0};
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i + 1;j < nums.length;j++){
                if((nums[i] + nums[j]) == target){
                    returnIndex[0] = i;
                    returnIndex[1] = j;
                    return returnIndex;
                }
            }
        }

        return null;
    }

    //通过哈希表是实现
    private int[] twoSum1(int[] nums, int target){
        //考虑输入数组的情况，显然当输入数组元素个数小于2时不存在两数之和的说法。
        if(nums == null || nums.length < 2) {return null;}

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }

        return null;
    }
}
