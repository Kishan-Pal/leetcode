class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int i: candyType) {
            set.add(i);
        }
        int by2 = candyType.length/2;
        int size = set.size();
        return ((by2 < size)? by2: size);
    }
}