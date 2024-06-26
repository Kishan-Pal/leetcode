class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int pow = 1;
        int res = 0;
        for(int i=n-1; i>=0; i--) {
            //System.out.println((int)columnTitle.charAt(i)-64);
            res = res + pow * ((int)columnTitle.charAt(i)-64);
            pow = pow * 26;
            //System.out.println(res);
        }
        return res;
    }
}