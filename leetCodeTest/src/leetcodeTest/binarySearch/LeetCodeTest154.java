package leetcodeTest.binarySearch;

public class LeetCodeTest154 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        int res = findMin(nums);
        System.out.println(res);
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            System.out.printf("l = %d, mid = %d, r = %d",l, mid, r);
            System.out.println();
            if (nums[l] == nums[mid]) {
                l++;
            }
            if (nums[l] > nums[mid]) {
                r = mid;
            } else {
                if (nums[l] < nums[r]) {
                    return nums[l];
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }
}
