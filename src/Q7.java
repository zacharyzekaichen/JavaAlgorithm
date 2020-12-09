import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 示例 1:
 输入: 123
 输出: 321
 示例 2:
 输入: -123
 输出: -321
 示例 3:
 输入: 120
 输出: 21
 * @author chenzk
 * @create 2020-12-09 13:27
 */
public class Q7 {

    @Test
    public void testFlow() {
        //溢出的话就循环回负数了
        //原理？
        int a = (int) (Math.pow(2,31) - 1);
        a = a + 1;
        System.out.println(a);
    }

    @Test
    public void testQ7() {
        int a = reverse2(-12);
        System.out.println(a);
    }

    @Test
    public void testNegative() {
        System.out.println(-100 / 3);
    }

    //有问题：先进去的是最低位的数
    private int reverse1(int x) {
        long returnInt = 0L;
        int cur = 0;
        Stack<Integer> intStack = new Stack<>();
        //用栈做？因为次序相反
        while(x / 10 != 0) {
            cur = x % 10; //negative
            intStack.push(cur);
            x = x / 10;
        }
        //跳出循环，说明x/10==0，说明已经到个位数了，此时将个位数压入栈
        intStack.push(x);
        //接下来是反转操作，
        while(! intStack.isEmpty()) {
            returnInt = returnInt * 10 + intStack.pop();
        }

        //反转后整数溢出则返回0
        if(returnInt > Math.pow(2,31)-1 || returnInt < -Math.pow(2,31)) {return 0;}
        return (int)returnInt;
    }

    //就不需要用栈了，用数组应该就可以了。//动态数组
    private int reverse2(int x) {
        long returnInt = 0L;
        int cur = 0;
        ArrayList<Integer> intList = new ArrayList<>();
        //用栈做？因为次序相反
        while(x / 10 != 0) {
            cur = x % 10; //negative
            intList.add(cur);
            x = x / 10;
        }
        //跳出循环，说明x/10==0，说明已经到个位数了，此时将个位数压入栈
        intList.add(x);
        //接下来是反转操作，
        for(int i : intList) {
            returnInt = returnInt * 10 + i;
        }

        //反转后整数溢出则返回0
        if(returnInt > Math.pow(2,31)-1 || returnInt < -Math.pow(2,31)) {return 0;}
        return (int)returnInt;
    }

    private int reverseStandard(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //是否溢出的判断
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
