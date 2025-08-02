import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1; // Minimum possible distance
        int right = position[position.length - 1] - position[0];
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlace(position, m, mid)) {
                answer = mid;
                left = mid + 1; // Try for a larger minimum distance
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean canPlace(int[] position, int m, int minDist) {
        int count = 1; // First magnet placed
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
            }
            if (count >= m) return true;
        }
        return false;
    }
}
