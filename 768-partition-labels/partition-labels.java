class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastocc = new int[200];
        for(int i=0; i<s.length(); i++) {
            lastocc[(int)s.charAt(i)] = i;
        }
        List<Integer> res = new ArrayList<>();
        int begin = 0;
        int end = -1;
        for(int i=0; i<s.length(); i++) {
            end = Math.max(end, lastocc[(int)s.charAt(i)]);
            if(i == end || i == s.length()-1) {
                res.add(end-begin+1);
                begin = end+1;
            }
        }
        return res;
    }
}