class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hash = new HashMap<>();
        List<String> common = new ArrayList<>();
        for(int i=0; i<list1.length; i++) {
            hash.put(list1[i], i);
        }
        int min = 3000;
        for(int i=0; i<list2.length; i++) {
            int temp = i + hash.getOrDefault(list2[i], 3001);
            if(temp < min) {
                common.clear();
                common.add(list2[i]);
                min = temp;
            }
            else if(temp == min) {
                common.add(list2[i]);
            }
        }
        int n = common.size();
        String[] res = new String[n];
        for(int i=0; i<n; i++) {
            res[i] = common.get(i);
        }
        return res;
    }
}