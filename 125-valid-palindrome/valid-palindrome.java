class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i=0, j=n-1;
        char a, b;
        while(i<j) {
            a = s.charAt(i);
            if((int)a <= 90 && (int)a >= 65)
                a = (char)((int)a + 32);
            if((int)a <= 122 && (int)a >= 97 || (int)a <= 57 && (int)a >= 48){
                b = s.charAt(j);
                if((int)b <= 90 && (int)b >= 65)
                    b = (char)((int)b + 32);
                if((int)b <= 122 && (int)b >= 97 || (int)b <= 57 && (int)b >= 48){
                    if(a != b) return false;
                    i = i + 1;
                    j = j - 1;
                }
                else j = j - 1;
            }
            else i = i + 1;
        }
        return true;
    }
}