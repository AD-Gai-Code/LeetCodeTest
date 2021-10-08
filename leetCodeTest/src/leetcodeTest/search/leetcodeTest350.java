package leetcodeTest.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcodeTest350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,4};
        int[] nums2 = {9,4,9,8,4};
        int[] res = intersect(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }

    // 本题要学会使用 map 的一个方法 getOrDefault(key,defaultValue) 即如果 map 集合中存在该键则返回对应的值，否则的话就返回默认的值
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        int res[] = new int[nums1.length];
        for(int num : nums1){
            int count = map1.getOrDefault(num, 0) + 1;
            map1.put(num,count);
        }

        int index = 0;
        for(int num : nums2){
            int count = map1.getOrDefault(num,0);
            if(count > 0){
                res[index] = num;
                index ++;
                count --;
                // 更新 map 中相应的键所对应的值，不然的话 count-- 就没有了任何意义
                if(count > 0 ){
                    map1.put(num,count);
                } else {
                    map1.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
