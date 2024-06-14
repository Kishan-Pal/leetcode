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
    if(k == numsSize/2.0){
        for(int i=0; i<k; i++){
            temp = nums[i];
            nums[i] = nums[i+k];
            nums[i+k] = temp;
        }
        return;
    }
    reverse(nums, 0, numsSize-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, numsSize-1);
    
}