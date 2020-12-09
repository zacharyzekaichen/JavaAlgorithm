import org.junit.Test;

/**
 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器。
 * @author chenzk
 * @create 2020-12-09 16:06
 */
public class Q11 {

    @Test
    public void testQ11() {
        int[] arr = new int[]{2};
        System.out.println(maxArea1(arr));
    }

    private int maxArea1(int[] height) {
        if(height == null || height.length <= 1) return 0;
        int maxVal = 0;
        int temp;
        for(int i = 0;i < height.length - 1;i++) {
            for(int j = i + 1;j < height.length;j++) {
                temp = Math.min(height[i], height[j]) * (j - i);
                maxVal = Math.max(temp, maxVal);
            }
        }

        return maxVal;
    }

    private int maxAreaStandard(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
