class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        List<Integer> intersec = new ArrayList<>();
        for(int i: nums2) {
            hash2.put(i, 1);
        }
        for(int i: nums1) {
            if(!hash1.containsKey(i)){
                hash1.put(i, 1);
                if(hash2.containsKey(i))
                    intersec.add(i);
            }
        }
        int n = intersec.size();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = intersec.get(i);
        }
        return a;
    }
}