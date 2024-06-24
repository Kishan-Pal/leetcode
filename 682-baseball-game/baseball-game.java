class Solution {
    public int calPoints(String[] operations) {
        List<Integer> res = new ArrayList<>();
        int n = operations.length, k=0, sum=0, temp;
        for(String i: operations) {
            switch(i) {
                case "D":
                    res.add(res.get(k-1) * 2);
                    k = k + 1;
                    break;
                case "C":
                    k = k - 1;
                    res.remove(res.get(k));
                    break;
                case "+":
                    res.add(res.get(k-1) + res.get(k-2));
                    k = k + 1;
                    break;
                default:
                    res.add(Integer.parseInt(i));
                    k = k + 1;
            }
        }
        for(Integer i: res) {
            sum += i;
        }
        return sum;
    }
}