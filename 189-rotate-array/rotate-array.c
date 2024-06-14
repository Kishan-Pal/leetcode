void reverse(int *a, int l, int r) {
    int temp;
    while(l < r) {
        temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        l++;
        r--;
    }
}

void rotate(int* nums, int numsSize, int k) {
    k = k % numsSize;
    int temp;
    reverse(nums, 0, numsSize-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, numsSize-1);
    
}