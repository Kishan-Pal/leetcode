class Solution {
    public int maximumSwap(int num) {
        int minIndex, maxIndex, i;
        Stack<Integer> minStack = new Stack<Integer>();
        char[] number = String.valueOf(num).toCharArray();
        minIndex = 0;
        maxIndex = 0;
        minStack.push(0);
        for(i=1; i<number.length; i++) {
            if(number[i]-'0' < number[minIndex]-'0') {
                minIndex = i;
                minStack.push(i);
            }
            if(number[i]-'0' <= number[maxIndex]-'0') {
                maxIndex = i;
            }
            else break;

        }
        while(i<number.length) {
            if(number[i]-'0' >= number[maxIndex]-'0') {
                maxIndex = i;
            }
            i++;
        }
        // System.out.println(minIndex + " " + maxIndex);
        while(!minStack.isEmpty() && number[minStack.peek()] < number[maxIndex]) {
            minIndex = minStack.pop();
        }
        // System.out.println(minIndex + " " + maxIndex);

        if(minIndex != maxIndex && number[minIndex] < number[maxIndex]) {
            number[minIndex] ^= number[maxIndex];
            number[maxIndex] ^= number[minIndex];
            number[minIndex] ^= number[maxIndex];
        }
        // for(char j: number) {
        //     System.out.print(j);
        // }
        // System.out.println();

        return Integer.parseInt(new String(number));
    }
}