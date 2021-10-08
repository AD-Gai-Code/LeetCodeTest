package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LeetCodeTest503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int[] res = nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for(int i = 0; i < 2 * n; i++){
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]){
                System.out.println("pop:" + stack.pop());
            }
            System.out.println(stack.isEmpty());
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
            System.out.println("push:" + nums[i % n]);
        }
        return res;
    }
}
