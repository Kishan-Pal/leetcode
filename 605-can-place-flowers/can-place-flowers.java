class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        int len = flowerbed.length;
        if(len == 1) {
            if(flowerbed[0] == 0)
                count = 1;
        }
        else {
            if(flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                count = count + 1;
            }
            if(flowerbed[len-1] == 0 && flowerbed[len-2] == 0) {
                flowerbed[len-1] = 1;
                count = count + 1;
            }
            for(int i=1; i<len-1; i++) {
                if(flowerbed[i] == 0) {
                    if(flowerbed[i-1] == 0 && flowerbed[i+1]==0) {
                        flowerbed[i] = 1;
                        count = count + 1;
                    }
                }
            }
        }
        return (n <= count? true: false);
    }
}