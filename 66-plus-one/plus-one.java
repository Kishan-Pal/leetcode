class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length, sum=0, i;
        digits[n-1] = digits[n-1] + 1;
        for(i=n-1; i>=0; i--){
            sum = sum + digits[i];
            if(sum <= 9){
                digits[i] = sum;
                sum = 0;
                break;
            }
            else {
                digits[i] = sum-10;
                sum = 1;
            }
        }
        System.out.println(sum +" "+ digits[0]);
        if(sum == 0){
            return digits;
        }
        else{
            int[] digits2= new int[n+1];
            digits2[0] = 1;
            for(i=0; i<n; i++) {
                digits2[i+1] = digits[i];
            }
            return digits2;
        }

        
    }
}