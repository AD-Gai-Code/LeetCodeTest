package leetcodeTest.recurAndBacktrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        res = permute(nums);
        System.out.println(res.toString());
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static int count = 0;
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return res;
        }
        backtrack(nums, path);
        return res;
    }

    public static void backtrack(int[] nums, List<Integer> path){
        count++;
        //System.out.printf("进入第 %d 次回溯\n",count);
        if(path.size() == nums.length ){
            res.add(new ArrayList<Integer>(path));
            System.out.println("get " + path.toString() + ",return");
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path);
            path.remove(path.size() - 1);
        }
        System.out.println("return\n");
    }
}