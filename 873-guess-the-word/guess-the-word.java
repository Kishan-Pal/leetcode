/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        List<String> candidates = Arrays.asList(words);
        Random random = new Random();
        for(int i=0; i<30; i++) {
            int guess = random.nextInt(candidates.size());
            String string = candidates.get(guess);
            int match = master.guess(string);

            if(match == 6) return;
           // System.out.println("match = " + match + " candidate was " + candidates.get(guess));
            List<String> tempCandidates = new ArrayList<>();
            for(String candidate: candidates) {
                if(match == getMatch(string, candidate)) {
                    tempCandidates.add(candidate);
                    //System.out.print(candidate + " ");
                }
            }
           // System.out.println("--------");

            candidates = tempCandidates;
        }
        
        return;
    }

    public int getMatch(String word1, String word2) {
        int equality = 0;
        for(int i=0; i<word1.length(); i++) {
            if(word1.charAt(i) == word2.charAt(i)) equality++;
        }
        return equality;
    }
}