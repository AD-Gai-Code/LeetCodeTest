package leetcodeTest.recurAndBacktrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest131 {
    public static void main(String[] args) {
        String s = "aab";
        res = partition(s);
        for (List<String> list : res) {
            System.out.println(list.toString());
        }
    }

    static List<List<String>> res = new ArrayList<>();
    static List<String> path = new ArrayList<>();
    static int count = 0;

    public static List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }

        char[] charS = s.toCharArray();
        backtrack(charS, 0, len, path, res);
        return res;
    }

    public static void backtrack(char[] charS, int index, int len, List<String> path, List<List<String>> res) {
        printIndent(count++);
        System.out.printf("index = %d " + path.toString() + "\n", index);
        if (index == len) {
            res.add(new ArrayList<String>(path));
        }

        for (int i = index; i < len; i++) {
            if (!isHuiWen(charS, index, i)) {
                continue;
            }
            path.add(new String(charS, index, i + 1 - index));
            backtrack(charS, i + 1, len, path, res);
            path.remove(path.size() - 1);
        }
        printIndent(--count);
        System.out.print("get " + path.toString() + "return   ");
        System.out.println("now res : " + res.toString());
    }

    public static boolean isHuiWen(char[] charS, int l, int r) {
        while (l < r) {
            if (charS[l] != charS[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }
}
