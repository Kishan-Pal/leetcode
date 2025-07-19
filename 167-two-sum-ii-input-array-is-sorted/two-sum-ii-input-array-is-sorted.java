class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0; i<numbers.length; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;
            int l=i+1, r=numbers.length-1;
            while(l<=r) {
                int mid = (l+r)/2;
                if(numbers[mid] == num2) {
                    res[0] = i+1;
                    res[1] = mid+1;
                    return res;
                }
                else if(num2 < numbers[mid]) {
                    r = mid-1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return res;
    }
}