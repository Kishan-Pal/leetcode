class Solution {
    public int minSwapsCouples(int[] row) {
        int[] position = new int[row.length];
        for(int i=0; i<position.length; i++) {
            position[row[i]] = i;
        }
        int swap = 0;

        for(int i=0; i<row.length; i+=2) {
            int first = row[i];
            int second = row[i+1];

            int expectedPartner = first ^ 1;

            if(second != expectedPartner) {
                swap++;
                swap(row, i+1, position[expectedPartner]);

                position[second] = position[expectedPartner];
                position[expectedPartner] = i+1;
                
            }

        }
        return swap;
    }

    public void swap(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }
}