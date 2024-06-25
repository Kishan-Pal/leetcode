class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int n = s.length(), m = t.length(), count = m;
        int j=0, i, min=Integer.MAX_VALUE;
        int i2=0, j2=0;
        Character c;
        for(i=0; i<m; i++) {
            hash.put(t.charAt(i), hash.getOrDefault(t.charAt(i), 0)+1);
        }
        i=0;
        while(j<n) {
            while(j<n && count != 0) {
                c = s.charAt(j);
                //System.out.println("char at j " + c);
                if(hash.containsKey(c)){
                    hash.put(c, hash.get(c) -1);
                    //System.out.println(c + " " + hash.get(c));
                    if(hash.get(c) >= 0) {
                        count = count - 1;
                    }
                }
                j = j + 1;
            }
            if(j == n && count != 0) break;
            if(min > j-i) {
                min = j-i;
                i2 = i;
                j2 = j;
            }
            min = (min < j-i? min: j-i);
            //System.out.println(i + " " + j);
            while(i<j){
                c = s.charAt(i);
                //System.out.println("char at i " + c);

                if(hash.containsKey(c)){
                    hash.put(c, hash.get(c) + 1);
                    if(hash.get(c) > 0) {
                        count = count + 1;
                        i = i + 1;
                        break;
                    }
                }
                i = i + 1;
            }
            if(min > j-i+1) {
                min = j-i+1;
                i2 = i-1;
                j2 = j;
            }
            min = (min < j-i+1? min: j-i+1);
            //System.out.println(i + " " + j);
        }
        //System.out.println(min);
        if(min == Integer.MAX_VALUE) return "";
        return s.substring(i2, j2);
    }
}