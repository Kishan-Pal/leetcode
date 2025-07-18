class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] arr = new int[n];
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<triangle.get(i).size()-1; j++) {
                arr[j] = Math.min(arr[j] + triangle.get(i).get(j), arr[j+1] + triangle.get(i).get(j+1));
            }
        }
        return arr[0] + triangle.get(0).get(0);
    }

}