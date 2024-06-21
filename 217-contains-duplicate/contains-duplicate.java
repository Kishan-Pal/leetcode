class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i: nums) {
            if(hash.containsKey(i))
                return true;
            else
                hash.put(i, 1);
        }
        return false;
    }
}