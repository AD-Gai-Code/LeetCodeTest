package leetcodeTest.binarySearch;

public class LeetCodeTest540 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int res = singleNonDuplicate(nums);
        System.out.println(res);
    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int pre = 0, last = 1;
        while (last < nums.length) {
            if (nums[pre] == nums[last]) {
                pre += 2;
                last += 2;
            } else {
                return nums[pre];
            }
        }
        return nums[n - 1] != nums[n - 2] ? nums[n - 1] : -1;
    }
}
