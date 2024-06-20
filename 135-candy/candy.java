class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        if(n == 1) return 1;
        int i, sum = 1;
        
        int a[] = new int[n], j=0,temp;
        a[0] = 1;
        while(j<n-1 && ratings[j] > ratings[j+1]) {
            a[0] = a[0] + 1;
            sum = sum + 1;
            j = j+1;
        }
        for(i=1; i<n-1; i++) {
            a[i] = 1;
            if(ratings[i-1] >= ratings[i]) {
                j=i;
                while(j<n-1 && ratings[j] > ratings[j+1]) {
                    a[i] = a[i] + 1;
                    j = j+1;
                }
            }
            else {
                temp = 1;
                j=i;
                while(j<n-1 && ratings[j] > ratings[j+1]) {
                    temp = temp + 1;
                    j = j+1;
                }
                a[i] = Math.max(a[i-1] + 1, temp);
            }
            sum = sum + a[i];
        }
        if(ratings[n-2] < ratings[n-1]) {
            sum = sum + a[n-2] + 1;
        }
        else{
            sum = sum + 1;
        }
        return sum;
    }
}