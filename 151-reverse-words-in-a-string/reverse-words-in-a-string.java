class Solution {
    public String reverseWords(String s) {
        List<String> a= new ArrayList<>();
        String temp = "";
        int len = 0, i;
        for(String j: s.split(" ", -1)) {
            if(j != "") {
                len = len+1;
                a.add(j);
            }
        }
        for(i=0; i<len/2; i++) {
            temp = a.get(i);
            a.set(i, a.get(len-i-1));
            a.set(len-i-1, temp);
        }
        /* for(String k: a) {
            System.out.println(k);
        }
        System.out.println(len); */
        return String.join(" ", a);
    }
}