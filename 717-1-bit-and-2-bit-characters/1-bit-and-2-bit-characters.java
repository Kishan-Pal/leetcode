class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        boolean res = true;
        int i=0;
        while(i<n) {
            if(bits[i] == 0) {
                res = true;
                i += 1;
            }
            else {
                i += 2;
                res = false;
            }
        }
        return res;
    }
}