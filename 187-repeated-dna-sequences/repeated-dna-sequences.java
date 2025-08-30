class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for(int i=0; i<s.length()-9; i++) {
            String temp = s.substring(i, i+10);
            if(seen.contains(temp)) {
                repeated.add(temp);
            }
            else {
                seen.add(temp);
            }
        }

        List<String> res = new ArrayList<String>(repeated);
        return res;
    }
}