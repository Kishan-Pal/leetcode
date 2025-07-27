class Solution {
    public int countOdds(int low, int high) {
        int count = high - low + 1;

        return count / 2 + (count & 1 & low);
    }
}