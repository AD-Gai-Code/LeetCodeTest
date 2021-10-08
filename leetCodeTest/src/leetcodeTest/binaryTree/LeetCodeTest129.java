package leetcodeTest.binaryTree;

public class LeetCodeTest129 {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3};
        TreeNode root = new TreeNode(nums[0]);
        root = root.createBinaryTree(nums);
        int res = sumNumbers(root);
        System.out.println(res);
    }

    static int res = 0;
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,0);
        return res;
    }

    private static void dfs(TreeNode root,int num){
        if(root == null){
            return;
        }

        num = num * 10 + root.val;
        if(root.left == null && root.right == null){
            res += num;
            return;
        }
        dfs(root.left,num);
        dfs(root.right,num);
    }
}
