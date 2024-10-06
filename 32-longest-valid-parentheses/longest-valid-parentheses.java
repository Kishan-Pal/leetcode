class Solution {

    public boolean isEqual(char a, char b) {
        if(a == '(' && b == ')') return true;
        else return false;
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        int pre = 0;
        Stack<Ele> stack = new Stack<>();
        stack.push(new Ele('#', 0));
        for(int i=0; i<s.length(); i++) {
            if(isEqual(stack.peek().ch, s.charAt(i))) {
                stack.pop();
            }
            else {
                stack.push(new Ele(s.charAt(i), i+1));
            }
        }
        stack.push(new Ele('#', s.length()+1));
        for(Ele a: stack) {
            res = Math.max(res, a.index - 1 - pre);
            pre = a.index;
            //System.out.println(a.ch + " = " + a.index);
        }
        return res;
    }
}

class Ele {
    protected char ch;
    protected int index;
    Ele(char a, int b) {
        this.ch = a;
        this.index = b;
    }
}