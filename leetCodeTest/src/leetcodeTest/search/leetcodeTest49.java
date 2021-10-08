package leetcodeTest.search;

import java.util.*;

public class leetcodeTest49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new ArrayList<>();
        res = groupAnagrams(strs);
        System.out.println(res.toString());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            System.out.println(Arrays.toString(counts));
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println("key = " + key + "   value =" + value);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
