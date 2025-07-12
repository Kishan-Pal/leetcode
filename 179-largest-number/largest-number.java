class Solution {
    class myComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String a1, b1;
            a1 = a+b;
            b1 = b+a;
            for(int i=0; i<a1.length(); i++) {
                if(a1.charAt(i) < b1.charAt(i)) {
                    return 1;
                }
                else if(a1.charAt(i) > b1.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }
    }
    public String largestNumber(int[] nums) {
        String[] stringNums= new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums, new myComparator());
        if(stringNums[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for(String i: stringNums) {
            res.append(i);
           // System.out.println(i);
        }

        return res.toString();
    }
}

// 312 3123
// 3123 312

// 123 1231
// 1231 123

// 1113111113
// 1113111311

// 1113221113
// 1113111322