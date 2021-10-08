package leetcodeTest.algorithm.sort;

import java.util.*;

public class Offer_60 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] nums = new int[k];
        for(int i = 0; i < k; i++){
            nums[i] = sc.nextInt();
        }
        topKFrequent(nums, k);
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(entry);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll().getKey();
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
