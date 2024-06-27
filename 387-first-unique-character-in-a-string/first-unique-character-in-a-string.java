class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[200];
        int n = s.length();
        for(int i=0; i<n; i++) {
            count[s.charAt(i)] += 1;
        }
        for(int i=0; i<n; i++) {
            if(count[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}