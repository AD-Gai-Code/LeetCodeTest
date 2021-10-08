package leetcodeTest.dp;

public class LeetCodeTest518 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int res = change(5,coins);
        System.out.println(res);
    }
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][amount + 1];
        dp[0][0] = 1;
        for(int i = coins[0]; i <= amount; i += coins[0]){
            dp[0][i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= coins[i]){
                    dp[i][j] +=  dp[i][j - coins[i]];
                }
            }
        }
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println(" ");
        }
        return dp[n - 1][amount];
    }
}
