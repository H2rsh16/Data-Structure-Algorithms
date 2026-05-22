// Last updated: 22/05/2026, 11:25:30
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();

            list.add(1);

            for(int j = 1; j < i; j++){
                int val = lst.get(i - 1).get(j - 1) + lst.get(i - 1).get(j);

                list.add(val);
            }

            if(i > 0){
                list.add(1);
            }

            lst.add(list);
        }

        return lst;
    }
}