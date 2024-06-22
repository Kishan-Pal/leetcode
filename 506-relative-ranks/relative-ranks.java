class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        String[] result = new String[score.length];
        int n = score.length;
        for(int i=0; i<score.length; i++) {
            hash.put(score[i], i);
        }
        Arrays.sort(score);

        if(n==1) {
            result[hash.get(score[n-1])] = "Gold Medal";
        }
        if(n==2) {
            result[hash.get(score[n-1])] = "Gold Medal";
            result[hash.get(score[n-2])] = "Silver Medal";

        }
        if(n>=3) {
            result[hash.get(score[n-1])] = "Gold Medal";
            result[hash.get(score[n-2])] = "Silver Medal";
            result[hash.get(score[n-3])] = "Bronze Medal";

        }
        for(int i=0; i<n-3; i++) {
            
                result[hash.get(score[i])] = n-i + "";


        }
        return result;

    }
}