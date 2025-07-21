class Solution{
    static{
        for(int i = 0; i < 100; i++){
            longestPrefix(" ");
        }
    }
    public static String longestPrefix(String s){
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        int len = 0;
        while(i < n){
            if(ch[i] == ch[len]){
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) len = lps[len - 1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0, lps[n - 1]);
    }
}