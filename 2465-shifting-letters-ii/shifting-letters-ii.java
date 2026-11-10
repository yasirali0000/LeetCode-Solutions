class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int val = (shift[2] == 0) ? -1 : 1;
            diff[start] += val;
            diff[end+1] -= val;
        }
        StringBuilder ans = new StringBuilder();
        int shift = 0;
        for (int i = 0; i < n; i++) {
            // Current index par total shift
            shift += diff[i];
            // Negative shift ko bhi 0-25 range mein convert karo
            int actualShift = ((shift % 26) + 26) % 26;
            // Character ko shift karo
            char ch = (char) ('a' +(s.charAt(i) - 'a' + actualShift) % 26);
            ans.append(ch);
        }
        return ans.toString();
    }
}