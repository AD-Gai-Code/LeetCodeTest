package leetcodeTest.recurAndBacktrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeTest17 {
    static int count = 0;
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        for(String s : res){
            System.out.println(s + " ");
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(res , phoneMap , digits , 0 , new StringBuffer());
        return res;
    }

    public static void backtrack(List<String> res , Map<Character,String> phoneMap, String digits, int index , StringBuffer combination){
        printIndent(count ++);
        System.out.printf(" %s  :  %s\n" , index , combination);
        if(index == digits.length()){
            res.add(combination.toString());
            printIndent(-- count);
            System.out.printf("get %s , return \n" , combination);
            return;
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for(int i = 0; i < letterCount; i ++){
                combination.append(letters.charAt(i));
                /*for(String s : res){
                    System.out.print( s + " ");
                }*/
                System.out.printf("digits[%d] = %c , use %s\n" , index , digit , letters.charAt(i));
                backtrack(res , phoneMap , digits , index + 1 , combination);
/*                System.out.println(" ");*/
                combination.deleteCharAt(index);
            }
            printIndent(-- count);
            System.out.printf("digits[%d] = %c  complete , return\n" , index , digit);
        }
    }

    public static void printIndent(int n ){
        for(int i = 0; i < n; i ++){
            System.out.print("  ");
        }
    }
}
