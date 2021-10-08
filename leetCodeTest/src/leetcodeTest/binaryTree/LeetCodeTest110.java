package leetcodeTest.binaryTree;

public class LeetCodeTest110 {
    static int count = 0;
    public static void printIndent(int n ){
        for(int i = 0; i < n; i ++){
            System.out.print("   ");
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode root = new TreeNode(nums[0]);
        root = root.createBinaryTree(nums);
        boolean b = isBalanced(root);
        System.out.println(b);
    }

    public static boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public static int recur(TreeNode root){
        if(root == null){
            printIndent(count ++);
            System.out.println("return 0\n");
            return 0;
        }

        int left = recur(root.left);
        System.out.printf(" left = %d\n",left);
        if(left == -1){
            System.out.println("return -1\n");
            return -1;
        }
        int right = recur(root.right);
        System.out.printf(" right = %d\n",right);
        if(right == -1){
            System.out.println("return -1\n");
            return -1;
        }
        int ans = Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
        printIndent( -- count);
        System.out.printf(" return %d\n ",ans);
        return ans;
    }
}
