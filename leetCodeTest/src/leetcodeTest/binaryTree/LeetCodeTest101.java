package leetcodeTest.binaryTree;

public class LeetCodeTest101 {
    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,4,4,3};
        TreeNode root = new TreeNode(nums[0]);
        root = root.createBinaryTree(nums);
        boolean b = isSymmetric(root);
        System.out.println(b);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    public static boolean dfs(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return dfs(left.left,right.right) && dfs(right.left,left.right);
    }
}
