class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> hash = new HashMap<>();
        int[] a = new int[200];
        int st, ed=-1, i;
        String temp = "";
        for(i=0; i<pattern.length() && ed < s.length(); i++) {
            st = ed = ed + 1;
            while(ed < s.length() && s.charAt(ed) != ' ') ed++;
            temp = s.substring(st, ed);
            if(a[(int)pattern.charAt(i)] > 0 && hash.containsKey(temp)){
                if(pattern.charAt(i) != hash.get(temp)) return false;
            }
            else if(a[(int)pattern.charAt(i)] == 0 && !hash.containsKey(temp)){
                a[(int)pattern.charAt(i)] = 1;
                hash.put(temp, pattern.charAt(i));
            }
            else return false;
        }
        if(s.length() != ed || i < pattern.length()) return false;
        return true;
    }
}