import org.junit.Test;

/**请你来实现一个 atoi 函数，使其能将字符串转换成整数。

 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

 在任何情况下，若函数不能进行有效的转换时，请返回 0 。

 示例 1:

 输入: "42"
 输出: 42
 示例 2:

 输入: "   -42"
 输出: -42
 解释: 第一个非空白字符为 '-', 它是一个负号。
      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 示例 3:

 输入: "4193 with words"
 输出: 4193
 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 示例 4:

 输入: "words and 987"
 输出: 0
 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 因此无法执行有效的转换。
 示例 5:

 输入: "-91283472332"
 输出: -2147483648
 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
      因此返回 INT_MIN (−231) 。
 * @author chenzk
 * @create 2020-12-09 14:12
 */
public class Q8 {
    private final int INT_MIN = (int) -Math.pow(2,31);
    private final int INT_MAX = (int) Math.pow(2,31)-1;

    @Test
    public void testMyAtoi() {
        int a = myAtoi1("-");
        System.out.println(a);
    }

    @Test
    public void testChar() {
//        System.out.println((int)'9');
        int a = Integer.parseInt("+12");
        System.out.println(a);
    }

    private int myAtoi1(String s) {
        if(s == null || s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int first = 0;
        int second = 0;
        //可能出现超过索引的问题
        while(chars[first] == ' ') {
            first++;
            //寻找第一个非空字符时超出索引
            if(first == s.length()) {return 0;}
            //这样写有问题，万一后面一个又是‘ ’呢
//            if(chars[first] == '-') {
//                int second = first;
//                first++;
//            }
        }
        //跳出while循环，说明first索引此时指向第一个非空字符
        //以下写法是有问题的，因为第一个满足的话，后面就不用看了，就是成立的
//        if(chars[first] < '0' || chars[first] > '9' || chars[first] != '-')
        //因为如果第一个是负号的话，实际上后面可能是没有数字的
        if(chars[first] == '-' || chars[first] == '+') {
            second = first;
            first++;
        }
        //非数字字符，返回0
        if(first == s.length()) return 0;
        if(chars[first] < '0' || chars[first] > '9') {return 0;}
        if(chars[second] != '-') {second = first;}
        //注意：first是索引
        while(first < s.length()) {
            if(first + 1 == s.length()) break;
            if(chars[first + 1] < '0' || chars[first + 1] > '9') break;
            first++;
        }
        //不包含endIndex
        String reStr = s.substring(second, first + 1);
        int reInt = 0;
        try {
            reInt = Integer.parseInt(reStr);
        }catch (NumberFormatException e) {
            if(chars[second] == '-') {
                return INT_MIN;
            }else {return  INT_MAX;}
        }

        return reInt;
    }
}
