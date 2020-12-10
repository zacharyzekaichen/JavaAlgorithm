import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 示例:
 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 * @author chenzk
 * @create 2020-12-10 15:10
 */
public class Q17 {

    @Test
    public void testQ17() {
        String digits = "12";
        List<String> list = letterCombinations1(digits);
        System.out.println(list);
    }

    private List<String> letterCombinations1(String digits) {
        List<String> returnList = new ArrayList<>();
        if(digits == null || digits.isEmpty()) return returnList;

        if(digits.length() == 1) {
            List<String> list = getCharFromDigit(digits.charAt(0));
            if(list == null) return returnList;
            else return list;
        }
        else {
            char firstChar = digits.charAt(0);
            String secondSubString = digits.substring(1);
            //这里返回的firstList可能是null
            List<String> firstList = getCharFromDigit(firstChar);
            if(firstList == null) firstList = new ArrayList<>();
            List<String> secondList = letterCombinations1(secondSubString);
            for(String str1 : firstList) {
                for(String str2 : secondList) {
                    returnList.add(str1+str2);
                }
            }
            return returnList;
        }
    }

    private List<String> getCharFromDigit(char c) {
        HashMap<Character,List<String>> map = new HashMap<>();
        List<String> list2 = Arrays.asList("a","b","c");
        List<String> list3 = Arrays.asList("d","e","f");
        List<String> list4 = Arrays.asList("g","h","i");
        List<String> list5 = Arrays.asList("j","k","l");
        List<String> list6 = Arrays.asList("m","n","o");
        List<String> list7 = Arrays.asList("p","q","r","s");
        List<String> list8 = Arrays.asList("t","u","v");
        List<String> list9 = Arrays.asList("w","x","y","z");
        map.put('2',list2);
        map.put('3',list3);
        map.put('4',list4);
        map.put('5',list5);
        map.put('6',list6);
        map.put('7',list7);
        map.put('8',list8);
        map.put('9',list9);

        return map.get(c);
    }
}
