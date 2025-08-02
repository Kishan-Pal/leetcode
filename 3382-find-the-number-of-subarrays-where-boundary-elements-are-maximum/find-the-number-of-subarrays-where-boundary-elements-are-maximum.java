class Solution {
    public long numberOfSubarrays(int[] nums) {
        long res = 0;
        Deque<int[]> stack = new LinkedList<>();

        for(int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                // System.out.println("removed " + stack[top][0] + ": " + stack[top][1]);
                stack.pop();
            }
            if(stack.isEmpty() || nums[i] != stack.peek()[0]) {
                stack.push(new int[]{nums[i], 0});
                // System.out.println("pushed " + nums[i]);
            }
            res+= ++stack.peek()[1];

           
        }

        return res;
    }
}