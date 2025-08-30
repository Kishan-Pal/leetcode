class Solution {
    public int numTimesAllBlue(int[] flips) {
        TreeSet<Integer> set = new TreeSet<>();
        int result = 0;
        for(int i=0; i<flips.length; i++) {
            set.add(flips[i]);
            if(set.size() == i+1 && set.higher(i+1) == null) {
                result++;
            }
        }
        return result;  
    }
}