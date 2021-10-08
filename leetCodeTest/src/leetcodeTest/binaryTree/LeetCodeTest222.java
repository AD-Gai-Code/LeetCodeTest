package leetcodeTest.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCodeTest222 {
    static int count = 0;
    public static void main(String[] args) {
        Integer[] nums = {1};
        TreeNode root = new TreeNode(nums[0]);
        root = root.createBinaryTree(nums);
        int res = countNodes(root);
        System.out.println(res);
    }

    public static int countNodes(TreeNode root) {
        if(root == null){
            printIndent(count++);
            System.out.printf("return 0\n");
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i < n; i ++){
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res += n;
        }
        printIndent(--count);
        System.out.printf("return %d\n",res);
        return res;
    }

    public static void printIndent(int n ){
        for(int i = 0; i < n; i ++){
            System.out.print(" ");
        }
    }
}
