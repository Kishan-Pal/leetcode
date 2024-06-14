class Solution(object):
    def rotate(self, nums, k):

        n = len(nums)
        while k > n:
            k = k-n
        a = []
        for i in range(n-1, n-k-1, -1):
            a.append(nums[i])
        for i in range(n-1, k-1, -1):
            nums[i] = nums[i-k]
        for i in range(k):
            nums[i] = a[k-i-1]


        