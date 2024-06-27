class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        int[] rcount = new int[200];
        int[] mcount = new int[200];
        for(int i=0; i<n; i++) {
            rcount[ransomNote.charAt(i)] += 1;
        }
        for(int j=0; j<m; j++) {
            mcount[magazine.charAt(j)] += 1;
        }
        for(int i=0; i<n; i++) {
            if(rcount[ransomNote.charAt(i)] > mcount[ransomNote.charAt(i)]) return false;
        }
        return true;

    }
}