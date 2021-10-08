package leetcodeTest.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int n = 10000;
        int[] nums = new int[n];

        for(int i = 0; i < n; i ++){
            Random r = new Random();
            nums[i] = r.nextInt(n);
        }

        quick_sort(nums,0, nums.length - 1);
        for(int i = 0; i < n - 1; i++){
            if(nums[i] > nums[i + 1]){
                throw new RuntimeException("排序出错");
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void quick_sort(int[] arr, int l, int r){
        // 递归结束条件
        if (l >= r) return;

        // 逻辑部分
        // 确定分界点
        int p = arr[l + r >> 1];

        // 两个边界
        int i = l - 1, j = r + 1;

        // 调整区间
        while (i < j) {
            do i++; while (arr[i] < p); // 注意这里没有 =, 如果有 =会导致栈溢出
            do j--; while (arr[j] > p);
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        // 进行递归, 注意取 j时, p不能够取 arr[r],否则会有边界问题
        quick_sort(arr, l, j);
        quick_sort(arr, j + 1, r);
    }
}
