package leetcodeTest.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCodeTest973 {
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] res = new int[k][2];
        kClosest(res, points, 2);
        System.out.println(Arrays.toString(res));
    }

    public static int[][] kClosest(int[][] res, int[][] points, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
            }
        });
        for(int i = 0; i < k; i++){
            queue.offer(points[i]);
        }
        for(int i = k; i < points.length; i++){
            if(queue.comparator().compare(points[i], queue.peek()) > 0){
                queue.poll();
                queue.offer(points[i]);
            }
        }
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }

    private static double getDistance(int[] nums){
        return Math.pow(nums[0], 2) + Math.pow(nums[1], 2);
    }
}
