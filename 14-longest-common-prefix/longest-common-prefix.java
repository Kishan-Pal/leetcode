class Solution {
    

    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        int n = strs.length;
        for(int i=1; i<n; i++) {
            while(strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
                if(res == "") return "";
            }
        }
        return res;
    }
}