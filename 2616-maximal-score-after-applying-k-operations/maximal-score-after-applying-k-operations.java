class myComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if (a > b) {
            return -1;
        } else if (a < b) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new myComparator());
        long result = 0;
        for (int i : nums) {
            pq.add(i);
        }
        // System.out.println(pq);
        for(int i=0; i<k; i++) {
            int ele = pq.poll();
            result += ele;
            pq.add((ele + 2)/3);
        }
        return result;
    }
}
