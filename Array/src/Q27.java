import org.junit.Test;

/**
 * @author chenzk
 * @create 2020-12-02 10:06
 */
public class Q27 {

    @Test
    public void testQ27(){
        int[] nums = new int[]{1,2,3,4,5,1};
        int len = removeElement2(nums,1);
        System.out.println("数组长度为：" + len);
        for(int i = 0;i < len;i++){
            System.out.print(nums[i] + "\t");
        }
    }

    private int removeElement1(int[] nums, int val){
        if( nums == null || nums.length == 0 ) {return 0;}

        //对符号的含义要非常清楚
        int len = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != val){
                nums[len++] = nums[i];
            }
        }

        return len;
    }

    //当需要移除的个数比较少的时候，用以上的方法交换的次数比较多。
    //所以当遇到需要移除的元素时，把它挪到最后即可。
    private int removeElement2(int[] nums, int val){
        if( nums == null || nums.length == 0 ) {return 0;}

        //对符号的含义要非常清楚
        int len = nums.length;
        //可以这么写
        for(int i = 0;i < len;){
            if(nums[i] == val){
                nums[i] = nums[--len];
            }else{
                i++;
            }
        }

        return len;
    }
}
