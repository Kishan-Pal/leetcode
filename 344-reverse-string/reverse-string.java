class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i=0; i<n/2; i++) {
            swap(s, i, n-i-1);
        }
    }
    public void swap(char[] s, int i, int j) {
        s[i] = (char)(s[i] ^ s[j]);
        s[j] = (char)(s[i] ^ s[j]);
        s[i] = (char)(s[i] ^ s[j]);
    }
}