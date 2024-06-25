class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;
        for(int i=n-1; i>=0; i--) {
            switch(s.charAt(i)) {
                case 'I':
                    sum = sum + 1;
                    break;
                case 'V':
                    if(i==0) {
                        sum = sum + 5;
                    }
                    else if(s.charAt(i-1) == 'I') {
                        sum = sum + 4;
                        i = i - 1;
                    }
                    else {
                        sum = sum + 5;
                    }
                    break;
                case 'X':
                    if(i==0) {
                        sum = sum + 10;
                    }
                    else if(s.charAt(i-1) == 'I') {
                        sum = sum + 9;
                        i = i - 1;
                    }
                    else {
                        sum = sum + 10;
                    }
                    break;
                case 'L':
                    if(i==0) {
                        sum = sum + 50;
                    }
                    else if(s.charAt(i-1) == 'X') {
                        sum = sum + 40;
                        i = i - 1;
                    }
                    else {
                        sum = sum + 50;
                    }
                    break;
                case 'C':
                    if(i==0) {
                        sum = sum + 100;
                    }
                    else if(s.charAt(i-1) == 'X') {
                        sum = sum + 90;
                        i = i - 1;
                    }
                    else {
                        sum = sum + 100;
                    }
                    break;
                case 'D':
                    if(i==0) {
                        sum = sum + 500;
                    }
                    else if(s.charAt(i-1) == 'C') {
                        sum = sum + 400;
                        i = i - 1;
                    }
                    else {
                        sum = sum + 500;
                    }
                    break;
                case 'M':
                    if(i==0) {
                        sum = sum + 1000;
                    }
                    else if(s.charAt(i-1) == 'C') {
                        sum = sum + 900;
                        i = i - 1;
                    }
                    else {
                        sum = sum + 1000;
                    }
                    break;
                default:
                    System.out.println("hi");
            }
        }
        return sum;
    }
}