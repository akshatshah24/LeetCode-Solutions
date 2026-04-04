class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int cols = len / rows;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < cols; i++) {
            for (int r = 0, c = i; r < rows && c < cols; r++, c++) {
                sb.append(encodedText.charAt(r * cols + c));
            }
        }
        
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }
        
        return sb.substring(0, end + 1);
    }
}