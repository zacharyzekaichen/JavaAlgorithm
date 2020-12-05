import org.junit.Test;

/**
 * @author chenzk
 * @create 2020-12-04 17:06
 */
public class Q4 {

    @Test
    public void testQ4() {
        int[] arr1 = new int[]{1,3,6,8};
        int[] arr2 = new int[]{2,3,4,7,9,10,11,23};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    @Test
    public void testCal() {
        int[] newNums = new int[]{1,2,3,4};

        //索引
        int len = newNums.length;
        if(len % 2 != 0) {
            System.out.println(newNums[len / 2]);
        }else {
            System.out.println((double) (newNums[len / 2] + newNums[len / 2 - 1]) / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0;
        if(nums1.length == 0 && nums2.length == 0) return 0;
        int[] newNums = new int[nums1.length + nums2.length];
        //首先应该合并数组
//        if(nums1.length == 0 || nums2.length == 0) {
//            newNums = (nums1.length == 0)? nums2 : nums1;
//        }

        int first = 0, second = 0, count = 0;
        while(first < nums1.length || second < nums2.length) {
            //特殊情况，当某一个数组遍历完成
            if(first == nums1.length) {
                newNums[count++] = nums2[second];
                second++;
                //continue还挺精髓的
                continue;
            }
            if(second == nums2.length) {
                newNums[count++] = nums1[first];
                first++;
                continue;
            }

            //常规主体
            if(nums1[first] >= nums2[second]) {
                newNums[count++] = nums2[second];
                second++;
            }else {
                newNums[count++] = nums1[first];
                first++;
            }

        }

        //计算出中位数并输出
        int len = newNums.length;
        if(len % 2 != 0) {
            return newNums[len / 2];
        }else {
            return (double) (newNums[len / 2] + newNums[len / 2 - 1]) / 2;
        }
    }
}


class Node {
    private int id;
    private String name;
    private int age;
    private Node next; //null
}
