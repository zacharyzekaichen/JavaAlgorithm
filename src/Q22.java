import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 示例：
 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 * @author chenzk
 * @create 2020-12-10 17:09
 */
public class Q22 {

    @Test
    public void testQ22() {
        List<String> list = generateParenthesis1(4);
        System.out.println(list);
    }

    private List<String> generateParenthesis1(int n) {
//        List<String> returnList = new ArrayList<>();
        Set<String> tempSet = new HashSet<>();
        if(n <= 0) return new ArrayList<>();

        if(n == 1) {
            tempSet.add("()");
        }else {
            List<String> tempList = generateParenthesis1(n - 1);
            for(String str : tempList) {
                tempSet.add("()" + str);
                tempSet.add(str + "()");
                tempSet.add("(" + str + ")");
            }
        }

//        List<String> returnList = new ArrayList<>(tempSet);

        return new ArrayList<>(tempSet);
    }


}
