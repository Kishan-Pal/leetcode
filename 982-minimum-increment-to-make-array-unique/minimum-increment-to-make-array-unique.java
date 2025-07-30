class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max = 100000000;
        boolean[] contains = new boolean[max];
        int res = 0;
        for(int i: nums) {
            if(!contains[i]) {
                contains[i] = true;
            }
            else {
                int k = 0;
                while(true) {
                    k++;
                    if(i+k < max && !contains[i+k]) {
                        res += k;
                        contains[i+k] = true;
                        break;
                    }
                    // else if(i+k >= 100001) {
                    //     System.out.println(i + " " + k);
                    //     System.exit(0);
                    // }
                }
            }
        }
        return res;
    }
}