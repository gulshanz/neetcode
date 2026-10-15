class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();


        for(int i=0;i<strs.length;i++){
            char [] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String sorted = new String(curr);
            List<String> currList = new ArrayList<>();
            if(map.containsKey(sorted)){
                currList = map.get(sorted);
            }
            currList.add(strs[i]);
            map.put(sorted, currList);
        }

        for(Map.Entry<String, List<String>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

}