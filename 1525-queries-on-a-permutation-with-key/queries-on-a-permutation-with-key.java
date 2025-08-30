class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new LinkedList<>();
        for(int i=1; i<=m; i++) {
            list.add(i);
        }

        int[] res = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            int idx = list.indexOf(queries[i]);
            list.remove(idx);
            list.addFirst(queries[i]);
            res[i] = idx;
        }
        return res;
    }
}