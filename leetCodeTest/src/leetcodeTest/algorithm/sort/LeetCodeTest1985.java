package leetcodeTest.algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCodeTest1985 {
    public static void main(String[] args) {
        String[] nums = {"3","6","7","10"};
        int k = 2;
        String res = kthLargestNumber(nums, k);
        System.out.println(res);
    }

    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;
                else
                    return o1.compareTo(o2);
            }
        });
        for(int i = 0; i < k; i++){
            queue.offer(nums[i]);
        }

        int len = nums.length;
        for(int i = k; i < len; i++){
            if(queue.comparator().compare(nums[i], queue.peek()) >= 0){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
