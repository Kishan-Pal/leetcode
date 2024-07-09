class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1, max = -1, volume;
        while(i<j) {
            if(height[j] < height[i]) {
                volume = height[j] * (j-i);
                j--;
            }
            else {
                volume = height[i] * (j-i);
                i++;
            }
            max = (max>volume?max: volume);
        }
        return max;
    }
}