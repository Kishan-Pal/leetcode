class Solution {
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        List<List<Character>> graph = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            graph.add(new ArrayList<Character>());
        } 

        int i=0, inc = 1;
        for(int k=0; k<s.length(); k++) {
            //System.out.print(i + " " );
            graph.get(i).add(s.charAt(k));
            if(i == 0) inc = 1;
            if(i == numRows-1) inc = -1;
            i = Math.max(i + inc, 0);
        }

        for(i=0; i<numRows; i++) {
            for(char c: graph.get(i)){
                res.append(c);
            }
        }


        return res.toString();
    }
}