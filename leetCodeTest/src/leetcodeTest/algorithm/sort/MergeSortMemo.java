package leetcodeTest.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSortMemo {
    public static void main(String[] args) {
        int n = 10000;
        int[] nums = new int[n];

        for(int i = 0; i < n; i ++){
            Random r = new Random();
            nums[i] = r.nextInt(n);
        }

        merge(nums,0, nums.length - 1);
        for(int i = 0; i < n - 1; i++){
            if(nums[i] > nums[i + 1]){
                throw new RuntimeException("排序出错");
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void merge(int[] nums, int l, int r){
        while(l >= r) return;
        int mid = l + r >> 1;
        merge(nums, l , mid);
        merge(nums, mid + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r){
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= r ){
            temp[k++] = nums[j++];
        }
        for(int m = l, n = 0; n < temp.length; m++, n++){
            nums[m] = temp[n];
        }
        //System.out.println(Arrays.toString(nums));
    }
}
