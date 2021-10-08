package leetcodeTest.search;

import java.util.Arrays;

public class LeetcodeTest16 {
    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        int target = 1;
        int res = threeSumClosest(nums,target);
        System.out.println(res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSumCloest = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for(int i = 0; i < len; i ++){
            int l = i + 1;
            int r = len - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - sum) < Math.abs(target - minSumCloest)){
                    minSumCloest = sum;
                }
                if(sum > target){
                    r --;
                } else if(sum < target){
                    l ++;
                } else {
                    return minSumCloest;
                }
            }
        }
        return minSumCloest;
    }
}
