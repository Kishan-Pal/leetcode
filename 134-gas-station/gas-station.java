class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel = 0;
        int startIndex = -1;
        int totalDiff = 0;
        for(int i=0; i<gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalDiff += diff;
            int fuelRemaining = fuel + diff;
            if(fuelRemaining < 0) {
                fuel = 0;
                startIndex = -1;
            }
            else {
                fuel = fuel + diff;
                if(startIndex == -1) {
                    startIndex = i;
                    // System.out.println("si = " + i);
                }
            }


        }
        // System.out.println("si = " + startIndex);
        if(totalDiff >= 0) {
            return startIndex;
        }
        else {
            return -1;
        }
    }
}
// -2 -2 -2 3 3 
// -1 -1 1
// 2 -1 -1 