// Last updated: 22/05/2026, 11:22:54
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int FiveCount = 0;
        int TenCount = 0;

        for(int money: bills){
            if(money == 5){
                FiveCount += 1;
            }
            else if(money == 10){
                if(FiveCount > 0){
                    FiveCount -= 1;
                    TenCount += 1;
                }
                else return false;
            }
            else if(money == 20){
                if(TenCount > 0 && FiveCount > 0){
                    TenCount -= 1;
                    FiveCount -= 1;
                }
                else if(FiveCount >= 3){
                    FiveCount -= 3;
                }
                else return false;
            }
        }

        return true;
    }
}