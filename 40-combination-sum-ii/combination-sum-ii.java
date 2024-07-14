class Solution {
    int[] count;
    HashSet<List<Integer>> res;
    List<Integer> tempList;
    int sum, target;

    Solution() {
        this.count = new int[51];
        this.res = new HashSet<>();
        this.tempList = new ArrayList<>();
        this.sum = 0;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        for(int i: candidates) {
            this.count[i]++;
        }
       
        this.solve(30);
        return new ArrayList<>(this.res);
    }

    public void solve(int i) {
        while(i >= 0 && this.count[i] == 0) i--;
        if(i <= 0) return;
        int k=count[i];
        for(int j=0; j<count[i]; j++) {
            this.sum += i;
            this.tempList.add(i);
        }
        while(k > 0) {
            if(this.sum == this.target) {
                this.res.add(new ArrayList<>(tempList));
            }
            else if(this.sum < this.target){
                solve(i-1);
            }
            this.sum -= i;
            this.tempList.removeLast();
            k--;
        }
        solve(i-1);
    }

}