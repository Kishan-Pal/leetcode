class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] comp1 = getComplex(num1);
        int[] comp2 = getComplex(num2);
        int[] comp3 = new int[2];
        // System.out.println(comp1[0] + " " + comp1[1]);
        // System.out.println(comp2[0] + " " + comp2[1]);

        comp3[0] = comp1[0] * comp2[0] - (comp1[1] * comp2[1]);
        comp3[1] = comp1[0] * comp2[1] + comp1[1] * comp2[0];
        return comp3[0] + "+" + comp3[1] + "i";
    }

    public int[] getComplex(String num) {
        int i=0, start = 0;
        int[] complex = new int[2];
        while(num.charAt(i) != '+') i++;
        complex[0] = Integer.parseInt(num.substring(start, i));
        start = i+1;
        while(num.charAt(i) != 'i') i++;
        complex[1] = Integer.parseInt(num.substring(start, i));
        return complex;
    }
}