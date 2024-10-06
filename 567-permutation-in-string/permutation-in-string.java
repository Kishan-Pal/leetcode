class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] hash2 = new int[27];
        int[] hash;
        int n1 = s1.length(), n;
        int n2 = s2.length();
        int j;
        for(int i=0; i<n1; i++) {
            hash2[(int) (s1.charAt(i) - 'a')]++;
        }
        for(int i=0; i<n2; i++) {
            hash = hash2.clone();
            n = n1;
            if(--hash[(int) (s2.charAt(i) - 'a')] >= 0) {
                n--;
                j = i + 1;
                while(n > 0 && j < n2) {
                    if(--hash[(int) (s2.charAt(j) - 'a')] >= 0) {
                        n--;
                    }
                    else break;
                    j++;
                }
                if(n==0) {
                    return true;
                }
            } 
        }
        return false;
    }
}