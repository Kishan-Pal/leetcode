class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1, max = -1;
        while(i<j) {
            int volume = Math.min(height[j], height[i]) * (j-i);
            max = (max>volume?max: volume);
            if(height[j] < height[i]) j--;
            else i++;
        }
        return max;
    }
}