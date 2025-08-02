class Solution {
    public char repeatedCharacter(String s) {
        boolean[] isPresent = new boolean[27];
        char[] a = s.toCharArray();
        for(char i: a) {
            if(isPresent[(int)(i - 'a')]) return i;
            isPresent[(int)(i - 'a')] = true;
        }
        return 'a';
    }
}