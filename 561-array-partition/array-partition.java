class Solution {
    public int arrayPairSum(int[] nums) {
        int[] count = new int[20002];
        int var = 10000;
        boolean flag = false;
        int temp = 0, j, sum = 0;
        for(int i: nums) {
            count[i + var]++;
        }
        // for(int i=0; i<20002; i++) {
        //     if(count[i] >= 1) System.out.println(i + " " + count[i]);
        // }

        for(int i=0; i<=20001; i++) {
            if(count[i] == 0) continue;
            if(flag){
                count[i]--;
                sum += temp;
            }
            j = count[i] / 2;
            sum += (i - var) * j;
            if(count[i] % 2 == 1) {
                flag = true;
                temp = i - var;
            }
            else {
                flag = false;
            }
        }

        return sum;
    }
}