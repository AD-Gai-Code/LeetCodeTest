package leetcodeTest.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcodeTest15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,0,0,0};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <nums.length; i ++){
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            // 不能是 i + 1 而是 i - 1 是因为如果是i + 1 就会跳过前面的值直接去算后面，就会导致漏掉（-1，-1，2）的解，因为直接跳过了
            if(i > 0 && nums[i] == nums[i+1]) continue; // 去重
            int l = i + 1;
            int r = len - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l] == nums[l+1]) l++; // 去重
                    while (l<r && nums[r] == nums[r-1]) r--; // 去重
                    l++;
                    r--;
                } else if(sum < 0){
                    l ++;
                } else if(sum > 0){
                    r --;
                }
            }
        }
        return res;
    }
}
