class Solution {
    public int trap(int[] height) {
        int i, top = -1, temp, j, peek;
        Ele k;
        int[] res = new int[height.length];
        Stack<Ele> stack = new Stack<>();
        for(i=0; i<height.length-1; i++) {
            if(height[i] > height[i+1]) break;
        }
        if(i == height.length - 1) return 0;
        stack.push(new Ele(height[i], i));
        top++;
        while(true) {
            // going down
            while(i<height.length-1 && height[i] >= height[i+1]) {
                i++;
            }
            if(i == height.length - 1) break;
            // going up
            while(i<height.length-1 && height[i] <= height[i+1]) {
                i++;
            }
            //System.out.println("peek = " + height[i] + ":" + i + "::stack top = " + stack.peek().val);
            // for(Ele hi: stack) {
            //     System.out.println("sss  " + hi.val + " top = " + top);
            // }
            peek = stack.peek().val;
            if(height[i] > peek) {
                while(top > 0 && height[i] > stack.peek().val) {
                    stack.pop();
                    top--;
                }
                j = i-1;
                k = stack.peek();
                while(j != k.index) {
                    temp = Math.min(height[i], k.val) - height[j];
                    res[j] = ((temp > 0) ? temp : 0);
                    j--;
                }
                if(k.val <= height[i]) {
                    stack.pop();
                    top--;
                }
                stack.push(new Ele(height[i], i));
                top++;
            }
            else if(height[i] == peek) {
                j = i-1;
                k = stack.peek();
                while(j != k.index) {
                    temp = Math.min(height[i], k.val) - height[j];
                    res[j] = ((temp > 0) ? temp : 0);
                    j--;
                }
                stack.pop();
                stack.push(new Ele(height[i], i));
            }
            else {
                j = i-1;
                k = stack.peek();
                while(j != k.index) {
                    temp = Math.min(height[i], k.val) - height[j];
                    res[j] = ((temp > 0) ? temp : 0);
                    j--;
                }
                stack.push(new Ele(height[i], i));
                top++;
            }
            if(i == height.length - 1) break;
        }

        // for(int l=0; l<height.length; l++) {
        //     System.out.print(res[l] + ",");
        // }
        // System.out.println();

        int sum = 0;
        for(int hi: res) {
            sum += hi;
        }

        return sum;
    }
}

class Ele {
    public int val;
    public int index;
    Ele(int val, int index) {
        this.val = val;
        this.index = index;
    }
}