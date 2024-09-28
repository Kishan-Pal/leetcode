class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> set = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String i: strs) {
            String temp = sort(i);
            if(set.containsKey(temp)){
                result.get(set.get(temp)).add(i);
            }
            else {
                List<String> temp2 = new ArrayList<>();
                temp2.add(i);
                result.add(temp2);
                set.put(temp, result.size() - 1);
            }
        }
        return result;
    }

    public String sort(String str) {
        char[] temp = str.toCharArray();
        int n = temp.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (temp[j] > temp[j + 1]) {
                    // Swap characters
                    char temp1 = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = temp1;
                }
            }
        }

        String sortedStr = new String(temp);
        System.out.println(sortedStr);
        
        return sortedStr;
    }

}