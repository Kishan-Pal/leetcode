class Solution {
    public int countOdds(int low, int high) {
        // int count = high - low + 1;

        return (high - low + 1) / 2 + ((high - low + 1) & 1 & low);
    }
}