// Last updated: 22/05/2026, 11:22:46
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> lst = new ArrayList<>();
        Map<String, Integer> arr1 = new HashMap<>();
        Map<String, Integer> arr2 = new HashMap<>();


        for(String s: s1.split(" ")){
            arr1.put(s, arr1.getOrDefault(s, 0) + 1);
        }
        
        for(String s: s2.split(" ")){
            arr2.put(s, arr2.getOrDefault(s, 0) + 1);
        }


        for(Map.Entry<String, Integer> entry: arr1.entrySet()){
            String w = entry.getKey();
            int c = entry.getValue();

            if(c == 1 && !arr2.containsKey(w)){
                lst.add(w);
            }

        }
        
        for(Map.Entry<String, Integer> entry: arr2.entrySet()){
            String w = entry.getKey();
            int c = entry.getValue();

            if(c == 1 && !arr1.containsKey(w)){
                lst.add(w);
            }

        }

        return lst.stream().toArray(String[]::new);
    }
}