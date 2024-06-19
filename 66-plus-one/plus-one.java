class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length, carry=0, i;
        int[] digits2 = new int[n+1];
        digits[n-1] = digits[n-1] + 1;
        if(digits[n-1] <= 9)
            return digits;
        carry = 1;
        digits[n-1] = digits[n-1] - 10;
        for(i=n-2; i>=0; i--) {
            digits[i] = digits[i] + carry;
            if(digits[i] <= 9) {
                return digits;
            }
            digits2[i+2] = 0;
            digits[i] = digits[i] - 10;
            carry = 1;
        }
        digits2[1] = 0;
        digits2[0] = 1;
        return digits2;
    }
}