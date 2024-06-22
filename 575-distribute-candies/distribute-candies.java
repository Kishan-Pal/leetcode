class Solution {

    
    public int distributeCandies(int[] candyType) {
        final boolean[] containsType = new boolean[200001]; // 2 * Math.pow(10, 5) + 1
        final int maxCount = candyType.length / 2;
        int counter = 0;
        for (int i = 0; i < candyType.length; i++) {
            final int type = candyType[i];
            if (!containsType[100000 + type]) {
                containsType[100000 + type] = true;
                counter++;

                if (counter > maxCount) {
                    return maxCount;
                }
            }            
        }
        return counter;
    }
}