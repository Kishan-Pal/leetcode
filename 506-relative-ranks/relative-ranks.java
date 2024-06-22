class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        String[] result = new String[score.length];
        for(int i=0; i<score.length; i++) {
            hash.put(score[i], i);
        }
        Arrays.sort(score);


        for(int i: score) {
            System.out.println(i);
        }
        for(int i=0; i<score.length; i++) {
            if(i==score.length-1) {
                result[hash.get(score[i])] = "Gold Medal";
            }
            else if(i==score.length-2) {
                result[hash.get(score[i])] = "Silver Medal";
            }
            else if(i==score.length-3) {
                result[hash.get(score[i])] = "Bronze Medal";
            }
            else {
                result[hash.get(score[i])] = score.length-i + "";

            }

        }
        return result;

    }
}