import java.util.*;

public class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        char[] c = s.toCharArray();
        int result = 1;
        for (int i = 1; i < c.length; ) {
            int step = Math.abs(c[i] - c[i - 1]);
            if (step > 1 && c.length - i >= n && n != 0) {
                result += 2 * n;
                i = i + n;
                continue;
            } else {
                result += (step + 1);
            }
            i++;
        }
        System.out.print(result);
    }
}
