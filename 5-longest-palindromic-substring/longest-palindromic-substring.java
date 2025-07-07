class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int length = 0;
        int n = s.length();
        for(int i=0; i<s.length(); i++) {
            int l=i, r=i;
            int tempLength = 0;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            tempLength = r-l-1;
            if(tempLength > length) {
                length = tempLength;
                res = s.substring(l+1, r);
            }
            l = i; r = i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            tempLength = r-l-1;
            if(tempLength>length) {
                length = tempLength;
                res = s.substring(l+1, r);
            }
        }
        return res;
        
    }
}