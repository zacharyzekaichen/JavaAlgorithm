import org.junit.Test;

import java.beans.beancontext.BeanContext;

/**
 * @author chenzk
 * @create 2020-12-01 8:55
 */
public class Q13 {

    @Test
    public void test(){
        System.out.println(romanToInt2("III"));
        System.out.println(romanToInt2("IV"));
        System.out.println(romanToInt2("IX"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt2("MCMXCIV"));
    }

    public int romanToInt(String s){
        char[] chars = s.toCharArray();
        int length = chars.length;
        int returnInt = 0;
        for(int i = 0;i < length;i++){
            char c = chars[i];
            switch (c){
                case 'I':
                    if(i != length - 1){
                        if(chars[i + 1] == 'V'){
                            i++;
                            returnInt += 4;
                            break;
                        }else if(chars[i + 1] == 'X'){
                            i++;
                            returnInt += 9;
                            break;
                        }
                    }
                    returnInt += 1;
                    break;
                case 'V':
                    returnInt += 5;
                    break;
                case 'X':
                    if(i != length - 1){
                        if(chars[i + 1] == 'L'){
                            i++;
                            returnInt += 40;
                            break;
                        }else if(chars[i + 1] == 'C'){
                            i++;
                            returnInt += 90;
                            break;
                        }
                    }
                    returnInt += 10;
                    break;
                case 'L':
                    returnInt += 50;
                    break;
                case 'C':
                    if(i != length - 1){
                        if(chars[i + 1] == 'D'){
                            i++;
                            returnInt += 400;
                            break;
                        }else if(chars[i + 1] == 'M'){
                            i++;
                            returnInt += 900;
                            break;
                        }
                    }
                    returnInt += 100;
                    break;
                case 'D':
                    returnInt += 500;
                    break;
                case 'M':
                    returnInt += 1000;
                    break;
            }
        }

        return returnInt;
    }

    private int romanToInt2(String s){
        char[] chars = s.toCharArray();
        int preNum = getValue(chars[0]);
        int num = 0;
        int returnValue = 0;
        for(int i = 1;i < s.length();i++){
            num = getValue(chars[i]);
            if(preNum < num){
                returnValue -= preNum;
            }else if(preNum > num){
                returnValue += preNum;
            }
            preNum = num;
        }
        returnValue += preNum;
        return returnValue;
    }

    private int getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
