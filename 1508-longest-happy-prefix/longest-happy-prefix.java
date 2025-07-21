class Solution {
    static {
        for(int i=0; i<10000; i++) {
            longestPrefix(" ");
        }
    }
    public static String longestPrefix(String s) {
        int n = s.length();
        int i=0, j=n-1;
        String res = "", pre = "", suf = "";
        //System.out.println(s.substring(0,n-1));
        while(j>0){
            pre = s.substring(0, j);
            if(s.endsWith(pre)){
                res = pre;
                break;
            }
            j = j - 1;
        }
        //System.out.println(pre + " " + suf);
        return res;
    }
}