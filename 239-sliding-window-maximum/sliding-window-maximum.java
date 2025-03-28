class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<Integer>();
        int[] res = new int[nums.length - k + 1];
        for(int i=0; i<k; i++) {
            while(!deq.isEmpty() && deq.getLast() < nums[i]) {
                deq.removeLast();
            }
            deq.addLast(nums[i]);
        }
        res[0] = deq.peekFirst();
        for(int i=1; i<nums.length - k + 1; i++) {
            if(nums[i-1] == deq.peekFirst()) {
                deq.pollFirst();
            }
            while(!deq.isEmpty() && deq.getLast() < nums[i+k-1]) {
                deq.removeLast();
            }
            deq.addLast(nums[i+k-1]);
            res[i] = deq.peekFirst();
        }
        return res;
    }
}