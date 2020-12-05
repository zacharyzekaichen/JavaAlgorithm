import org.junit.Test;

import java.util.*;

/**
 * @author chenzk
 * @create 2020-12-04 14:48
 */
public class Q3 {

    @Test
    public void testQ3() {
        System.out.println(lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
//        if(s == null || s.isEmpty()) return 0;
//        char[] chars = s.toCharArray();
//        Collection<Character> set = new HashSet<>();
//        int sum = 0;
//        for(char c : chars) {
//            if(! set.contains(c)) {
//                set.add(c);
//                sum++;
//            }
//        }
//
//        return sum;
        if(s == null || s.isEmpty()) return 0;
        int maxLength = 0;
        int curLength = 0;
        Collection<Character> map = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            //逻辑混乱
//            if(! map.contains(c)) {
//                map.add(c);
//                curLength++;
//            }else {
//                if(curLength > maxLength) maxLength = curLength;
//                map.clear();
//                map.add(c);
//                curLength = 1;
//            }
            if(map.contains(c)) {
                if(curLength > maxLength) maxLength = curLength;
                map.clear();
                curLength = 0;
            }

            map.add(c);
            curLength++;
        }

        if(maxLength < curLength) return curLength;
        return maxLength;
    }

//    public int lengthOflengthOfLongestSubstring2(String s) {
//
//    }
}
