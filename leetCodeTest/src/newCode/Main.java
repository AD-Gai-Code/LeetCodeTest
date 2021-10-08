package newCode;

public class Main {
    public static void main(String args[]){
        String s = "asfadfs a";
        int res = getMaxSubStrLen(s);
        System.out.println(res);
    }

    public static int getMaxSubStrLen(String s){
        String[] subStr = s.split(" ");
        int maxLen = 0;
        return subStr[subStr.length - 1].length();
    }
}
