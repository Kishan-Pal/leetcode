class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String i: details) {
            char char1 = i.charAt(11);
            char char2 = i.charAt(12);
            if(char1 > '6' || char1 == '6' && char2 > '0') count++;
        }
        return count;
    }
}