import org.junit.Test;

import java.util.*;

/**
 * @author chenzk
 * @create 2020-12-02 9:16
 */
public class Q26 {

    @Test
    public void testQ26(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates3(nums);
        System.out.println("数组长度为：" + len);
        for(int i = 0;i < len;i++){
            System.out.print(nums[i] + "\t");
        }
    }

    //采用哈希表
    public int removeDuplicates1(int[] nums){
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if( ! map.containsValue(nums[i]) ){
                map.put(count, nums[i]);
                nums[count++] = nums[i];
            }
        }

        return count;
    }

    //实际上感觉用不上哈希表，用Set应该就可以了。
    public int removeDuplicates2(int[] nums){
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;

        Collection<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if( ! set.contains(nums[i]) ){
                set.add(nums[i]);
                nums[count++] = nums[i];
            }
        }

        return count;
    }

    //看了下题目，好像跟我理解的有偏差，重新用动态数组做一下。
    public int removeDuplicates3(int[] nums){
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int count = 1;
        for(int i = 1;i < nums.length;i++){
            if( nums[i] != list.get(count - 1) ){
                list.add(nums[i]);
                nums[count++] = nums[i];
            }
        }

        return count;
    }

    //上一种方法的优化，实际上就是双指针法。
    public int removeDuplicates4(int[] nums){
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;

        int index = 0;
        for(int i = 1;i < nums.length;i++){
            if( nums[i] != nums[index] ){
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}
