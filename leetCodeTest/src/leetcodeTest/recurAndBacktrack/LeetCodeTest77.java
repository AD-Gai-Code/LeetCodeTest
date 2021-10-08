package leetcodeTest.recurAndBacktrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest77 {
    public static void main(String[] args) {
        int[] nums = createNums(4);
        res = combine(4 ,2);
        System.out.println(res.toString());
    }

    static List<Integer> track = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static int count = 0;
    public static List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 ){
            return res;
        }

        backtrack(n , k , track , 1);

        return res;
    }

    public static void backtrack(int n , int k , List<Integer> track , int start){
        printIndent(count++);
        System.out.printf("start %d\n" , start);
        if(k == track.size()){
            res.add(new ArrayList<Integer>(track));
            printIndent(--count);
            System.out.println("get" + track.toString() + ",return");
            return;
        }

        for(int i = start; i <= n - (k - track.size()) + 1; i++){
            track.add(i);
            backtrack(n , k , track , i + 1);
            track.remove(track.size() - 1);
        }
        //printIndent(--count);
        System.out.printf("start %d  complete,return\n" , start);
    }

    public static int[] createNums(int n ) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        return nums;
    }

    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }
}
