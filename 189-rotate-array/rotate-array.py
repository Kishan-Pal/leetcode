class Solution(object):
    def reverse(self, a, l, r):
        while l<r:
            temp = a[l]
            a[l] = a[r]
            a[r] = temp
            l = l + 1
            r = r - 1

    def rotate(self, nums, k):

        n = len(nums)
        while k > n:
            k = k-n

        if k == n/2.0:
            print(n/2)
            for i in range(n//2):
                temp = nums[i]
                nums[i] = nums[i+k]
                nums[i+k] = temp
            return
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)

        
        