import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzk
 * @create 2020-12-01 9:57
 */
public class Q6 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",1));
    }

    public static String convert(String s, int numRows){
        List<StringBuilder> strArr = new ArrayList<>();
        for(int i = 0;i < Math.min(numRows, s.length());i++){
            strArr.add(new StringBuilder());
        }

        int orderRow = 0;
        int orderChar = 0;
        boolean downFlag = true;

        while(true){
            //添加这一步是正确的。
            strArr.get(orderRow).append(s.charAt(orderChar));
            //分情况讨论
            if(numRows != 1){
                if(downFlag) {orderRow++;}
                else if(!downFlag) {orderRow--;}

                if(orderRow == numRows - 1) { downFlag = false;}
                else if(orderRow == 0) { downFlag = true;}
            }
            orderChar++;
            if(orderChar == s.length()) {break;}
        }

        StringBuilder returnValue = new StringBuilder();
        for(StringBuilder str : strArr){
            returnValue.append(str);
        }

        return new String(returnValue);
    }
}
