// Last updated: 22/05/2026, 11:23:41
class Solution {
    public String nearestPalindromic(String n) {
        int idx = n.length() / 2;
        boolean isEven = n.length() % 2 == 0;
        if (isEven) {
            idx--;
        }

        long leftPart = Long.parseLong(n.substring(0, idx+1));

        List<Long> cases = new ArrayList<>();

        cases.add(getPalindrome(leftPart, isEven));

        cases.add(getPalindrome(leftPart+1, isEven));

        cases.add(getPalindrome(leftPart-1, isEven));

        cases.add((long) Math.pow(10, n.length())+1);

        cases.add((long) Math.pow(10, n.length()-1)-1);

        long result = 0, diff = Integer.MAX_VALUE, num = Long.parseLong(n);
        for (long c: cases) {
            if (c == num) {
                continue;
            }

            long currDiff = Math.abs(num - c);
            if (currDiff < diff) {
                diff = currDiff;
                result = c;
            } else if (diff == currDiff) {
                result = Math.min(result, c);
            }
        }
        
        return String.valueOf(result);
    }
    private long getPalindrome(long leftPart, boolean isEven) {
        long result = leftPart;
        if (!isEven) {
            leftPart /= 10;
        }

        while (leftPart > 0) {
            result = result*10 + leftPart%10;
            leftPart /= 10;
        }

        return result;
    }
}