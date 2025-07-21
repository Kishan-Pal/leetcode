class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;

        int i = Math.abs(x);
        int rev = 0;
        while(i != 0) {
            int last = i % 10;

            if(rev > (max - last) / 10) return 0;
            rev = rev * 10;
            rev = rev + last;
            i = i / 10;
        }

        if(x<0) {
            return -rev;
        }
        else {
            return rev;
        }

        
    }
}