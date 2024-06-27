class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m) return false;
        int[] cs = new int[200];
        int[] ct = new int[200];
        char temp;
        for(int i=0; i<n; i++) {
            temp = s.charAt(i);
            cs[(int)temp] = cs[(int)temp] + 1;
            temp = t.charAt(i);
            ct[(int)temp] = ct[(int)temp] + 1;
        }
        for(int i=0; i<n; i++) {
            temp = s.charAt(i);
            if(cs[(int)temp] != ct[(int)temp]) return false;
            /* System.out.println(s.charAt(i) + " " +cs[(int)s.charAt(i)]);
            System.out.println(t.charAt(i) + " " +ct[(int)t.charAt(i)]);
            System.out.println(); */
        }
        return true;

    }
}