package leetcodeTest.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeTest257 {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,null,5};
        TreeNode root = new TreeNode(nums[0]);
        root = root.createBinaryTree(nums);
        List<String> res = binaryTreePaths(root);
        for(String s : res){
            System.out.println(s);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPath(root,"",res);
        return res;
    }

    public static void constructPath(TreeNode root,String path,List<String> res){

        if(root != null){
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if(root.left == null && root.right == null){
                res.add(pathSB.toString());
            } else {
                pathSB.append("——>");
                constructPath(root.left,pathSB.toString(),res);
                constructPath(root.right,pathSB.toString(),res);
            }
        }
    }
}
