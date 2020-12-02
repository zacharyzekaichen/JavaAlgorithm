import org.junit.Test;
import sun.plugin2.message.StopAppletAckMessage;

import java.util.*;

/**
 * @author chenzk
 * @create 2020-12-01 13:16
 */
public class Q20 {

    @Test
    public void test1(){
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put('(',')');
        }};

        System.out.println(pairs.get('('));
    }

    public boolean isValid1(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }

    private final int LEFT = 1;
    private final int RIGHT = 2;
    private final int GROUP1 = 1;
    private final int GROUP2 = 2;
    private final int GROUP3 = 3;

    public boolean isValid(String s){
        if(s == null) return false;
        if(s.isEmpty()) return true;
        if(s.length() % 2 != 0) return false;

        int count = 0;
        while(true){
            if(count == s.length() - 1) {return false;}

            if(getDirection(s.charAt(count)) == LEFT && getDirection(s.charAt(count + 1)) == RIGHT){
                if(getGroup(s.charAt(count)) == getGroup(s.charAt(count + 1))){
                    s = s.substring(0,count) + s.substring(count + 2,s.length());
                    if(s.isEmpty()) {return true;}
                    count = 0;
                }else{
                    return false;
                }

            }else{
                count ++;
            }
        }
    }

    private int getDirection(char c){
        switch(c){
            case '(': case '{': case '[': return LEFT;
            case ')': case '}': case ']': return RIGHT;
            default: return 0;
        }
    }

    private int getGroup(char c){
        switch(c){
            case '(': case ')': return GROUP1;
            case '{': case '}': return GROUP2;
            case '[': case ']': return GROUP3;
            default: return 0;
        }
    }
}
