class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }
}