class Solution {
    Map<Integer, Integer[]> dp;
    public int waysToReachStair(int k) {
        int max = 0;
        for(int i=0; i<32; i++) {
            if((k >> i & 1) == 1) {
                max = i;
            }
        }
        max++;
        dp = new HashMap<>();
        dp.put(0, new Integer[32]);
        dp.put(1, new Integer[32]);
        dp.put(2, new Integer[32]);
        Integer[] a = dp.get(0);
        Arrays.fill(a, 0);
        a[0] = 1;
        a[1] = 1;
        a = dp.get(1);
        Arrays.fill(a, 0);
        a[0] = 1;
        a[1] = 2;
        a[2] = 1;
        a = dp.get(2);
        Arrays.fill(a, 0);
        a[1] = 1;
        a[2] = 3;
        if(k == 0) return 2;
        if(k == 1) return 4;
        if(k == 2) return 4;
        int res = 0;
        for(int i=1; i<=max; i++) {
            res += waysWithkAndJump(k, i);
            //System.out.println("k = " + k + " res: " + res + " i: " + i);
        
        }
        return res;
    }

    public int waysWithkAndJump(int k, int jump) {
        Integer[] dpk;
        if(dp.containsKey(k)) {
            dpk = dp.get(k);
        }
        else {
            dpk = new Integer[32];
            dpk[0] = 0;
            dpk[1] = 0;
            dp.put(k, dpk);
        }

        if(dpk[jump] != null) return dpk[jump];
        
        int res = 0;
        int i = jump - 1;
        int prev = k - (1 << i);
        if(prev >= 0) {
            res += waysWithkAndJump(prev, i);
            //System.out.println("k = " + k + " res: " + res + " prev, i: " + prev + ", " + i);
            res += waysWithkAndJump(prev + 1, i);
            //System.out.println("k = " + k + " res: " + res + " prev + 1, i: " + (prev + 1) + ", " + i);
        }
        dpk[jump] = res;
        return res;
    }
}

// if(jump == 0) {
//             if(k == 0 || k == 1) return 1;
//             else return 0;
//         }
//         if(k == 0) {
//             if(jump == 1) return 1;
//             else return 0;
//         }
//         if(k == 1) {
//             if(jump == 1) return 2;
//             else if(jump == 2) return 1;
//             else return 0;
//         }
//         if(k == 2) {
//             if(jump == 1) return 1;
//             if(jump == 2) return 3;
//             else return 0;
//         }