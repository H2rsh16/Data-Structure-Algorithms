// Last updated: 22/05/2026, 11:18:40
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        // Declare Required Variables
        int m = grid.length;
        int n = grid[0].length;


        // Calculate total Sum of grid
        long totalSum = 0;
        for(int[] row: grid){
            for(int num: row){
                totalSum += num;
            }
        }

        // Calculate sum of top part
        long topSum = 0;
        for(int i = 0; i < m - 1; i++){
            for(int j = 0; j < n; j++){
                topSum += grid[i][j];
            }

            // Check is sum of two part is equal
            // row 1 ~  1, 4 -> 5
            // row 2 ~  2, 3 -> 5
            if(topSum == totalSum - topSum) return true;
        }

        // Calculate sum of bottom part
        long bottomSum = 0;
        for(int j = 0; j < n - 1; j++){
            for(int i = 0; i < m; i++){
                bottomSum += grid[i][j];
            }


            // Check is sum of two part is equal
            // col 1 ~  1, 2 -> 3
            // col 2 ~  4, 3 -> 7
            // condition falls here and exits because sum is not equal

            if(bottomSum == totalSum - bottomSum) return true;
        }


        // If anwer not found exit and return false
        return false;
    }
}