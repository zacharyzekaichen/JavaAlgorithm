import org.junit.Test;

/**
 * @author chenzk
 * @create 2020-12-01 10:06
 */
public class Q14 {

    @Test
    public void testLongestCommonPrefix(){
        String[] strs = new String[]{"fl","flower"};
        System.out.println(longestCommonPrefix1(strs));
    }

    private String longestCommonPrefix1(String[] strs){
        if(strs.length == 0) {return "";}
        String prefix = strs[0];
        for(int i = 1;i < strs.length;i++){
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) {return "";}
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String[] strs){
        int minL = minLength(strs);
        if(minL == 0) {return "";}
        if(strs.length == 1) {return strs[0];}

        StringBuilder returnStr = new StringBuilder("");
        StringBuilder strTemp = new StringBuilder("");

        int count = 0;
        while(true){
            strTemp.append(strs[0].charAt(count));
            for(String str : strs){
                if(! str.startsWith(new String(strTemp))) {return new String(returnStr);}
            }
            returnStr.append(strs[0].charAt(count));

            if(count == minL - 1) {return new String(returnStr);}
            count++;
        }

//        return String.valueOf(returnStr);
    }

    private int minLength(String[] strs){
        if(strs.length == 0) {return 0;}

        int minL = strs[0].length();
        for(String s : strs){
            minL = (s.length() < minL) ? s.length() : minL;
        }
        return minL;
    }
}
