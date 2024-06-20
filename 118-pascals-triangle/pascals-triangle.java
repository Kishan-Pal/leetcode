class Solution {
    public List<List<Integer>> generate(int numRows) {
        int i, j;
        List<List<Integer>> a = new ArrayList<>();
        for(i=0; i<numRows; i++) {
            a.add(new ArrayList<Integer>());
            for(j=0; j<=i; j++) {
                if(j==0 || j==i){
                    a.get(i).add(1);
                }
                else {
                    a.get(i).add(a.get(i-1).get(j-1) + a.get(i-1).get(j));
                }
            }
            
        }
        return a;
    }
}