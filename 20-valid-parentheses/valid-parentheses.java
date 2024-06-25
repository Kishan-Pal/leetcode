class Solution {
    public boolean isOpen(char b) {
        if(b == '(' || b == '[' || b == '{') return true;
        else return false;
    }

    public boolean isEqual(char a, char b) {
        if(a == '(' && b == ')'
        || a == '[' && b == ']'
        || a == '{' && b == '}') return true;
        else return false;
    }

    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        int top = -1;
        for(int i=0; i<s.length(); i++) {
            if(isOpen(s.charAt(i))) {
                stack.add(s.charAt(i));
                top += 1;
            }
            else {
                if(stack.size() >= 1 && isEqual(stack.get(top), s.charAt(i))) {
                    stack.remove(top);
                    top -= 1;
                }
                else return false;
            }
        }
        if(top == -1) return true;
        else return false;
    }
}