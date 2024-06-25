class Solution {
    public String addBinary(String a, String b) {
        int carry = 0, n = a.length(), m = b.length(), sum=0;
        int i=n-1, j=m-1;
        String res = "";
        while(i >= 0 && j >= 0) {
            System.out.println((a.charAt(i) - '0') + " " + (b.charAt(j) - '0'));
            sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            res = (sum % 2) + res;
            carry = sum / 2;
            j = j-1;
            i = i-1;
        }
        while(i >= 0) {
            sum = (a.charAt(i) - '0') + carry;
            res = (sum % 2) + res;
            carry = sum / 2;
            i = i-1;
        }
        while(j >= 0) {
            sum = (b.charAt(j) - '0') + carry;
            res = (sum % 2) + res;
            carry = sum / 2;
            j = j-1;
        }
        if(carry == 1) {
            res = 1 + res;
        }
        System.out.println(carry);
        return res;
    }
}