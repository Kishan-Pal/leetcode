class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i=0; i<nums.length; i++) {
            count[nums[i]]++;
        }
        int i=0, k=1;
        while(k <= count[0]) {
            nums[i] = 0;
            i++;
            k++;
        }
        k = 1;
        while(k <= count[1]) {
            nums[i] = 1;
            i++;
            k++;
        }
        k = 1;
        while(k <= count[2]) {
            nums[i] = 2;
            i++;
            k++;
        }
    }
}