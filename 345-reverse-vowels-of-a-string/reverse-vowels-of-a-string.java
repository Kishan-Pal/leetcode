class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int[] hash = new int[200];
        hash[(int)'a'] = 1;
        hash[(int)'e'] = 1;
        hash[(int)'i'] = 1;
        hash[(int)'o'] = 1;
        hash[(int)'u'] = 1;
        hash[(int)'A'] = 1;
        hash[(int)'E'] = 1;
        hash[(int)'I'] = 1;
        hash[(int)'O'] = 1;
        hash[(int)'U'] = 1;
        StringBuilder sb = new StringBuilder(s);
        int i=0, j=n-1;
        while(i<j) {
            while(i<j && hash[(int)s.charAt(i)] != 1) i++;
            while(i<j && hash[(int)s.charAt(j)] != 1) j--;
            if(i<j){
                this.swap(sb, i, j);
            }// System.out.println(s.charAt(i) + " " + s.charAt(j));
            i++;
            j--;

        }
        return sb.toString();
    }
    public void swap(StringBuilder s, int i, int j){
        char temp;
        temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
}