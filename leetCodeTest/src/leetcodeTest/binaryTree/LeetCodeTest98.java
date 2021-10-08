package leetcodeTest.binaryTree;

public class LeetCodeTest98 {
    public static void main(String[] args) {
        Integer[] nums = {5,1,4,null,null,6,7};
        TreeNode root = new TreeNode(nums[0]);
        root = root.createBinaryTree(nums);
        boolean b = isValidBST(root);
        System.out.println(b);
    }

    static int count = 0;
    static long pre = Long.MIN_VALUE;
    private static boolean isValidBST(TreeNode root) {

        printIndent( count ++);
        if(root != null){
            System.out.printf("root.val = %d , pre = %d\n" , root.val , pre);
        }


        if(root == null){
            printIndent( -- count);
            System.out.println("return true");
            return true;
        }

        if(!isValidBST(root.left)) {
            printIndent( -- count);
            System.out.println("return false");
            return false;
        }

        if(root.val <= pre){
            printIndent( -- count);
            System.out.println("return false");
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }

    public static void printIndent(int n ){
        for(int i = 0; i < n; i ++){
            System.out.print("  ");
        }
    }
}
