class Solution {
    public String[] findWords(String[] words) {
        String top = "qwertyuiopQWERTYUIOP"; int n1 = 20;
        String mid = "asdfghjklASDFGHJKL"; int n2 = 18;
        String bot = "zxcvbnmZXCVBNM"; int n3 = 14;
        HashMap<Character, Integer> hash = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i=0; i<n1; i++) {
            hash.put(top.charAt(i), 1);
        }
        for(int i=0; i<n2; i++) {
            hash.put(mid.charAt(i), 2);
        }
        for(int i=0; i<n3; i++) {
            hash.put(bot.charAt(i), 3);
        }
        //hash.forEach((key, value) -> System.out.println(key + " " + value));
        for(String i: words) {
            int j, n = i.length();
            for(j=0; j<n-1; j++){
                //System.out.println(i.charAt(j) + " " + hash.get(i.charAt(j)));
                //System.out.println(i.charAt(j+1) + " " + hash.get(i.charAt(j+1)));
                if(hash.get(i.charAt(j)) != hash.get(i.charAt(j+1))) break;
            }
            if(j == n-1) res.add(i);
            System.out.println(j);
        }
        int n = res.size();
        String[] result = new String[n];
        for(int i=0; i<n; i++) {
            result[i] = res.get(i);
        }
        return result;


    }
}