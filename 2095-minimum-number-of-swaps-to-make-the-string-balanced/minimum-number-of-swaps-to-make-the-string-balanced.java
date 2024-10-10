class Solution {

    public boolean isEqual(char a, char b) {
        return (a == '[' && b == ']');
    }

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(!stack.isEmpty() && isEqual(stack.peek(), s.charAt(i))) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        return (stack.size()/2 + 1)/2;
    }
}