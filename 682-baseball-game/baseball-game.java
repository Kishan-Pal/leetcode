class Solution {
    public int calPoints(String[] operations) {
        List<Integer> res = new ArrayList<>();
        int n = operations.length, k=0, sum=0, temp;
        for(String i: operations) {
            switch(i) {
                case "D":
                    temp = res.get(k-1) * 2;
                    res.add(temp);
                    sum += temp;
                    k = k + 1;
                    break;
                case "C":
                    k = k - 1;
                    temp = res.get(k);
                    res.remove(k);
                    sum -= temp;
                    break;
                case "+":
                    temp = res.get(k-1) + res.get(k-2);
                    res.add(temp);
                    sum += temp;
                    k = k + 1;
                    break;
                default:
                    temp = Integer.parseInt(i);
                    res.add(temp);
                    sum += temp;
                    k = k + 1;
            }
        }
        return sum;
    }
}