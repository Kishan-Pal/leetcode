class Solution {
    public int countOdds(int low, int high) {
        int count = high - low + 1;

        int res = count / 2 + (count & 1 & low);
        return res;
    }
}