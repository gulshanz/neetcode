class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // keep a set to have items which were already considered 
        // even if its a duplicate still we'll be applying uniqness on first pass itself 

        HashSet<String> set = new HashSet<>();

        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<strs.length;i++){
            String curr = strs[i];
            String hash = curr+i;
            if(set.contains(hash)) continue;
            set.add(hash);
            List<String> currList = new ArrayList();
            currList.add(curr);
            String iSorted = sortStr(curr);
            for(int j=i+1;j<strs.length;j++){
                if(strs[j].length()!=curr.length()) continue;
                if(set.contains(strs[j]+j)) continue;

                String jSorted = sortStr(strs[j]);

                if(iSorted.equals(jSorted)){
                    currList.add(strs[j]);
                    set.add(strs[j]+j);
                }
            }

            res.add(currList);
        }
        return res;
    }

    public String sortStr(String str){
        char[] chars = str.toCharArray();
        
        // 2. Sort the array
        Arrays.sort(chars);
        
        // 3. Convert back to string
        return new String(chars);
    }      
}
