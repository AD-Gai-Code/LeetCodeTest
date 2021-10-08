package leetcodeTest.search;

import java.util.HashSet;
import java.util.Set;

public class leetcodeTest349 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int res[] = intersection(nums1,nums2);
        for(int num : res){
            System.out.println(num);;
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        int index = 0;
        for(int i = 0; i < nums1.length; i ++){
            parentSet.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length;i ++){
            if(parentSet.contains(nums2[i])){
                childSet.add(nums2[i]);
            }
        }

        int[] res = new int[childSet.size()];
        for(int num : childSet){

            res[index] = num;
            index ++;
        }
        return res;
    }
}
