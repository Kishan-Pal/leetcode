class Solution {
    public String convertToTitle(int columnNumber) {
        int temp;
        String res = "";
        String[] a = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        while(columnNumber > 0) {
            temp = columnNumber % 26;
            if(temp == 0) {
                res = "Z" + res;
                columnNumber -= 26;
                
            }
            else {
                res = a[temp-1] + res;  




                
            }
            columnNumber /= 26;
            
        }

        return res;
    }
}