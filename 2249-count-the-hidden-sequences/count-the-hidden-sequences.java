class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = lower;
        int max = lower;
        int pre = lower;

        for(int i: differences) {
            int tempmax = pre + i;
            if(tempmax <= max && tempmax >= min) {
                pre = tempmax;
                continue;
            }
            else if(tempmax > max) {
                if(tempmax > upper) {
                    // System.out.println("tempmax: " + tempmax);
                    // System.out.println("i: " + i + " min: " + min + " max: " + max + " pre: " + pre);

                    return 0;
                }
                else {
                    max = tempmax;
                    pre = max;
                }
            }
            else if(tempmax < min) {
                int diff = lower - tempmax;
                pre = tempmax + diff;
                max = max + diff;
                
            }
            // System.out.println("i: " + i + " min: " + min + " max: " + max + " pre: " + pre);

        }
        if(upper < max || lower > min || max < lower) {
            return 0;
        }
        //System.out.println( " min: " + min + " max: " + max);
        return upper-max+1;
    }
}