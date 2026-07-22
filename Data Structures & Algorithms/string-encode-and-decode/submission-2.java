class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            String str = strs.get(i);
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int slash = str.indexOf('#', i);
            int size = Integer.parseInt(str.substring(i, slash));
            i = slash + 1;
            res.add(str.substring(i, i + size));
            i += size;
        }
        return res;
    }
}
