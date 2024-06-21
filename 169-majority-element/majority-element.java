class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0, res = 0;
        for(int i: nums) {
            if(majority == 0) {
                res = i;
            }
            majority = majority + ((i == res)? 1: -1);
        }
        return res;        
    }
}