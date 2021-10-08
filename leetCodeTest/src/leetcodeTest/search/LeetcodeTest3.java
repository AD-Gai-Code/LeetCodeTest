package leetcodeTest.search;

import java.util.HashMap;
import java.util.Map;

public class LeetcodeTest3 {
    public static void main(String[] args) {
        String s = "abbba";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 1;
        Map<Character,Integer> map = new HashMap<>();
        while(l < s.length() && r < s.length()){
            if( map.containsKey(s.charAt(r))){
                // 注意这里 l 要取两者间的最大值，否则对于 “abbba” 这种情况来说，取索引加一后 l 就会回到字符串的开头，所以要避免这种情况的发生
                l = Math.max(l,map.get(s.charAt(r)) + 1);
            }
            map.put(s.charAt(r),r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
