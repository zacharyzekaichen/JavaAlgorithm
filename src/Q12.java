import java.util.HashMap;

/**
 示例 1:
 输入: 3
 输出: "III"

 示例 2:
 输入: 4
 输出: "IV"

 示例 3:
 输入: 9
 输出: "IX"

 示例 4:
 输入: 58
 输出: "LVIII"
 解释: L = 50, V = 5, III = 3.

 示例 5:
 输入: 1994
 输出: "MCMXCIV"
 解释: M = 1000, CM = 900, XC = 90, IV = 4.

 * @author chenzk
 * @create 2020-12-09 17:00
 */
public class Q12 {
    private String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        while(num != 0) {
            count = num / 1000;
            if(count > 0 && count <= 3) {
                while(count-- > 0) str.append('M');
            }
            num = num - count * 1000;
        }

        return new String(str);
    }
}
