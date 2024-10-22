class Solution {

    public int getClosing(String expression, int startIndex) {
        if(expression.charAt(startIndex) == '&' || expression.charAt(startIndex) == '|' || expression.charAt(startIndex) == '!') {
            int count = 1;
            int index = startIndex+2;
            while(index < expression.length() &&  count != 0) {
                if(expression.charAt(index) == '(') count++;
                else if(expression.charAt(index) == ')') count--;
                index++;
            }
            return index;
        }
        else return startIndex+1;
        
    }

    public boolean parseBoolExpr(String expression) {
        char a = expression.charAt(0);
        int i;
        boolean result = false;
        switch(a) {
            case '&':
                i=2;
                //result = true;
                while(i < expression.length()-1) {
                    int end = getClosing(expression, i);
                    boolean temp = parseBoolExpr(expression.substring(i, end));
                    if(temp == false) return false;
                    i = end+1;
                }
                return true;
            case '|':
                i=2;
                //result = true;
                while(i < expression.length()-1) {
                    int end = getClosing(expression, i);
                    boolean temp = parseBoolExpr(expression.substring(i, end));
                    if(temp == true) return true;
                    i = end+1;
                }
                return false;
            case '!':
                i=2;
                //result = true;
                int end = getClosing(expression, i);
                boolean temp = parseBoolExpr(expression.substring(i, end));
                return (!temp);
            case 'f':
                return false;
            case 't':
                return true;
            default:
        }
        System.out.println(getClosing(expression, 1));
        return false;
    }
}