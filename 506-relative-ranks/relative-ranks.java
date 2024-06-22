class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        String[] result = new String[score.length];
        int n = score.length;
        for(int i=0; i<score.length; i++) {
            hash.put(score[i], i);
        }
        Arrays.sort(score);

        for(int i=0; i<n; i++) {
            if(i==n-1) {
                result[hash.get(score[i])] = "Gold Medal";
            }
            else if(i==n-2) {
                result[hash.get(score[i])] = "Silver Medal";
            }
            else if(i==n-3) {
                result[hash.get(score[i])] = "Bronze Medal";
            }
            else {
                result[hash.get(score[i])] = n-i + "";

            }

        }
        return result;

    }
}