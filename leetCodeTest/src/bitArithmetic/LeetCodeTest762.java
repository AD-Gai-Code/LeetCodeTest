package bitArithmetic;

import java.util.HashSet;
import java.util.Set;

public class LeetCodeTest762 {
    public static void main(String[] args) {

    }

    public static int countPrimeSetBits(int left, int right) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i = left; i <= right; i++){
            if(set.contains(Integer.bitCount(i))){
                res++;
            }
        }
        return res;
    }
}
