class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int i: machines) {
            sum += i;
        }
        if(sum % machines.length != 0) return -1;
        int req = sum / machines.length;
        int less = 0;
        int res = 0;

        // for(int i=0; i<machines.length; i++) {
        //     res = Math.max(res, machines[i] - req);  
        // }
        int temp = 0;
        for(int i=0; i<machines.length; i++) {
            int d = machines[i] - req;
            temp += d;
            res = Math.max(res, Math.max(Math.abs(temp), d));
        }
        return res;
    }
}