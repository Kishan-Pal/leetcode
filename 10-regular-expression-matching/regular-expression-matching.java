class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) {
            if(s.length() == 0) {
                return true;
            }
            else {
                return false;
            }
        }

        

        if(p.length() == 1) {
            if(s.length() == 0) return false;
            if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), "") ;
            }
            return false;
        }

        if(p.charAt(1) == '*') {
            if(s.length() == 0) {
                return isMatch(s, p.substring(2));
            }
            if(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
                boolean endStar = isMatch(s, p.substring(2));
                boolean continueStar = isMatch(s.substring(1), p);
                return endStar || continueStar;
            }
            if(p.charAt(0) != s.charAt(0)) {
                return isMatch(s, p.substring(2));
            }
            return false;
        }
        if(s.length() == 0) return false;
        if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        }

        return false;
    }
}