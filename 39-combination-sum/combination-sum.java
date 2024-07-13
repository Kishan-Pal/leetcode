class Solution {
    private List<List<Integer>> res;
    private List<Integer> tempList;
    private int[] candidates;
    private int target;
    private int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.initialize(candidates, target);
        this.solve(0);
        //displayRes();
        return res;
    }

    public void initialize(int[] candidates, int target) {
        res = new ArrayList<>();
        tempList = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        this.sum = 0;
    }

    public void solve(int i) {
        for(; i<candidates.length; i++) {
            //System.out.println("i = " + i);
            sum = sum + candidates[i];
            tempList.add(candidates[i]);
            
            //this.displayList();
            //System.out.println("sum = " + sum);
            
            if(sum == target) {
                //System.out.println("sum = " + sum);
                res.add(new ArrayList<>(tempList));
                //this.displayRes();
            }
            else if(sum < target) {
                solve(i);
            }
            if(sum != 0 && tempList.size() != 0) {
                sum = sum - candidates[i];
                tempList.remove(tempList.size()-1);
            }
        }
    }

   
}