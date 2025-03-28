class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        int length = (1 << n) - 1;
        //System.out.println(length);
        int mid = length / 2;

        if(k == mid+1) return '1';
        if(k < mid+1) return findKthBit(n-1, k);
        return (findKthBit(n-1, length-k+1) == '0'?'1':'0');
    }
}