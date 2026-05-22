// Last updated: 22/05/2026, 11:19:47
class Solution {
    public int distMoney(int money, int children) {
        money -= children;
        if (money < 0) return -1;

        int maxEight = Math.min(money / 7, children);
        int remaining = money - maxEight * 7;

        if (maxEight == children && remaining > 0)
            return children - 1;

        if (remaining == 3 && (children - maxEight) == 1)
            return maxEight - 1;
        return maxEight;
    }
}