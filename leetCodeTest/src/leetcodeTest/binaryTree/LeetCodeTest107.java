package leetcodeTest.binaryTree;

import java.util.*;

public class LeetCodeTest107 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = treeNode.createBinaryTree(nums);
        List<List<Integer>> res = levelOrderBottom(root);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; i ++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}
