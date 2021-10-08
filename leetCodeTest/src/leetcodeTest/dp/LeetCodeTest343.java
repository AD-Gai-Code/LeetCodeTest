package leetcodeTest.dp;

public class LeetCodeTest343 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int res = rob(nums);
        System.out.println(res);
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(tryRob(nums, 0, n - 2), tryRob(nums, 1, n - 1));
    }

    public static int tryRob(int[] nums, int start, int end){
        int n = nums.length;
        int[] dp = new int[n];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i <= end; i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        for(int num : dp){
            System.out.print(num + " ");
        }
        System.out.println(" ");
        System.out.println(dp[end]);
        return dp[end];
    }
}
