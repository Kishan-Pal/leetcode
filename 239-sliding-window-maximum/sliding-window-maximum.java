class Solution {
    public void insertDeque(Deque<Integer> deq, Integer ele) {
        while(!deq.isEmpty() && deq.getLast() < ele) {
            deq.removeLast();
        }
        deq.addLast(ele);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<Integer>();
        int[] res = new int[nums.length - k + 1];
        for(int i=0; i<k; i++) {
            insertDeque(deq, nums[i]);
        }
        res[0] = deq.peekFirst();
        for(int i=1; i<nums.length - k + 1; i++) {
            if(nums[i-1] == deq.peekFirst()) {
                deq.pollFirst();
            }
            insertDeque(deq, nums[i+k-1]);
            res[i] = deq.peekFirst();
        }
        return res;
    }
}