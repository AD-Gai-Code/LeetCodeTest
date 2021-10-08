package leetcodeTest.recurAndBacktrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for(List<Integer> r : res){
            System.out.print(r + " ");
        }
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> track = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {

        backtrack(nums , 0 , track);
        return res;
    }

    public static void backtrack(int[] nums , int start , List<Integer> track){
        System.out.printf("start = %d " , start);
        System.out.println("");
        System.out.println(track.toString());
        res.add(new ArrayList<>(track));

        for(int i = start; i < nums.length; i ++){
            track.add(nums[i]);
            backtrack(nums , i + 1 , track);
            track.remove(track.size() - 1);
        }
        System.out.println("添加了" + track.toString() + " return");
    }
}
