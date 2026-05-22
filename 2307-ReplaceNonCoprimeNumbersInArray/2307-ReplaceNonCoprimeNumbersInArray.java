// Last updated: 22/05/2026, 11:20:14
import java.util.*;

class Solution {

    public int gcd(int a, int b){
        while(b != 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> lst = new ArrayList<>();

        for (int num : nums) {
            lst.add(num);

            while (lst.size() >= 2) {
                int b = lst.remove(lst.size() - 1);
                int a = lst.remove(lst.size() - 1);

                int g = gcd(a, b);

                if (g == 1) {
                    lst.add(a);
                    lst.add(b);
                    break;
                } else {
                    int merged = lcm(a, b);
                    lst.add(merged);
                }
            }
        }

        return lst;
    }
}
