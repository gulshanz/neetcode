class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i))>=1){
                    map.put(t.charAt(i), map.get(t.charAt(i))-1);
                    if(map.get(t.charAt(i))==0){map.remove(t.charAt(i));}
                }else{
                    map.remove(t.charAt(i));
                }
            }else return false;
        }
        return map.isEmpty();
    }
}
