package leetcodeTest.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest114 {
    public static void main(String[] args) {
        Integer[] nums = {1,2,5,3,4,null,6};
        TreeNode root = new TreeNode(nums[0]);
        root = root.createBinaryTree(nums);
        flatten(root);

    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root,list);
        int size = list.size();
        for(int i = 1; i < size; i ++){
            TreeNode pre = list.get(i - 1),curr = list.get(i);
            pre.left = null;
            pre.right = curr;
        }
        for(TreeNode node : list){
            System.out.print(node.val + "  ");
        }
    }

    public static void preorder(TreeNode root, List<TreeNode> list){
        if(root != null){
            list.add(root);
            preorder(root.left,list);
            preorder(root.right,list);
        }
    }
}
